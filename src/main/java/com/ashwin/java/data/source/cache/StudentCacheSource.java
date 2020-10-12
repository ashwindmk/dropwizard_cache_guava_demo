package com.ashwin.java.data.source.cache;

import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.domain.model.Student;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class StudentCacheSource implements StudentSource {
    private static final String TAG = StudentCacheSource.class.getName();
    private static final Logger logger = LoggerFactory.getLogger(StudentCacheSource.class);
    private LoadingCache<Long, Student> studentCache;
    private StudentSource studentRemoteSource;

    @Inject
    public StudentCacheSource(@Named("student-remote-source") StudentSource remoteSource) {
        this.studentRemoteSource = remoteSource;

        studentCache = CacheBuilder.newBuilder()
            .concurrencyLevel(10)
            .maximumSize(10)
            .expireAfterAccess(30, TimeUnit.MINUTES)
            .recordStats()
            .build(new CacheLoader<Long, Student>() {
                @Override
                public Student load(Long aLong) throws Exception {
                    logger.info(TAG + " | Loading from remote source");
                    return studentRemoteSource.getById(aLong);
                }
            });
    }

    @Override
    public Student getById(Long id) {
        try {
            return studentCache.get(id);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
