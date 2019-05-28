package application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import resources.TastySearchResource;

public class TastySearchApplication extends Application<TastySearchConfiguration> {
    @Override
    public void initialize(Bootstrap<TastySearchConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(TastySearchConfiguration tastySearchConfiguration, Environment environment) throws Exception {
        // Register resources
        Injector injector = Guice.createInjector();
        environment.jersey().register(injector.getInstance(TastySearchResource.class));
    }
}
