package org.example;
/*


Andy D.

 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.StandardEnvironment;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
@SpringBootApplication
class NV9Base extends SpringApplication {
    NV9Base(String[] args) throws ClassNotFoundException {


        setWebApplicationType(WebApplicationType.NONE);
        setEnvironment(new StandardEnvironment());
        Set<String> set = new HashSet<String>();
        //set.add("Main");
        getAllSources().forEach(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                setSources((Set<String>) o);
            }
        });


        getInitializers().forEach(new Consumer<ApplicationContextInitializer<?>>() {
            @Override
            public void accept(ApplicationContextInitializer<?> applicationContextInitializer) {
                System.out.println("New Initializer: " + applicationContextInitializer.getClass().getName());

            }
        });
        run(Class.forName( "java.lang.String"), args);

        System.out.println( getMainApplicationClass());
        getSources().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("New Source: " + s);
            }
        });

        setLogStartupInfo(true);

        setAddCommandLineProperties(false);
       /* setApplicationContextFactory(new ApplicationContextFactory() {
            @Override
            public ConfigurableApplicationContext create(WebApplicationType webApplicationType) {

                return  createApplicationContext();

            }
        });*/

       // setWebApplicationType(getWebApplicationType());
        getListeners().forEach(new Consumer<ApplicationListener<?>>() {
            @Override
            public void accept(ApplicationListener<?> applicationListener) {
                System.out.println("New Listener: " + applicationListener.getClass().getName());
            }
        });


        getApplicationLog().warn( "This application is running slower than usual.");
        getApplicationLog().error("This is probably dead");
    }

}
