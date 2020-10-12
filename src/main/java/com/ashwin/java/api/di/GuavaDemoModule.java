package com.ashwin.java.api.di;

import com.ashwin.java.api.resource.StudentResource;
import com.ashwin.java.data.repositoryimpl.StudentRepositoryImpl;
import com.ashwin.java.data.source.StudentSource;
import com.ashwin.java.data.source.cache.StudentCacheSource;
import com.ashwin.java.data.source.remote.StudentRemoteSource;
import com.ashwin.java.domain.repository.StudentRepository;
import com.ashwin.java.domain.service.StudentService;
import org.glassfish.jersey.internal.inject.AbstractBinder;

import javax.inject.Singleton;

public class GuavaDemoModule extends AbstractBinder {
    @Override
    protected void configure() {
        bind(StudentRemoteSource.class).named("student-remote-source").to(StudentSource.class).in(Singleton.class);
        bind(StudentCacheSource.class).named("student-cache-source").to(StudentSource.class).in(Singleton.class);
        bind(StudentRepositoryImpl.class).to(StudentRepository.class).in(Singleton.class);
        bind(StudentService.class).to(StudentService.class).in(Singleton.class);
        bind(StudentResource.class).to(StudentResource.class).in(Singleton.class);
    }
}
