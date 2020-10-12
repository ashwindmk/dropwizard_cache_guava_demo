package com.ashwin.java;

import com.ashwin.java.api.di.GuavaDemoModule;
import com.ashwin.java.api.resource.StudentResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GuavaDemoApplication extends Application<GuavaDemoConfiguration> {
    private static final String TAG = GuavaDemoApplication.class.getName();
    private static final Logger logger = LoggerFactory.getLogger(GuavaDemoApplication.class);

    public static void main(String[] args) throws Exception {
        new GuavaDemoApplication().run(args);
    }

    @Override
    public void run(GuavaDemoConfiguration config, Environment env) throws Exception {
        logger.info(TAG + " | run");
        env.jersey().getResourceConfig().register(new GuavaDemoModule());
        env.jersey().register(StudentResource.class);
    }
}
