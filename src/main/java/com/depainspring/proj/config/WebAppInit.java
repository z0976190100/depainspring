package com.depainspring.proj.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class WebAppInit implements WebApplicationInitializer {

        public void onStartup(ServletContext container) throws ServletException{
            // Create the 'root' Spring application context
            AnnotationConfigWebApplicationContext rootContext =
                    new AnnotationConfigWebApplicationContext();
            rootContext.register(SpringConfig.class, MessagesConfig.class);

            container.addListener(new ContextLoaderListener(rootContext));




            // Create the dispatcher servlet's Spring application context
            AnnotationConfigWebApplicationContext dispatcherContext =
                    new AnnotationConfigWebApplicationContext();
            dispatcherContext.register(SprindWebConfig.class);

            // Register and map the dispatcher servlet
            ServletRegistration.Dynamic dispatcher =
                    container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
            dispatcher.setLoadOnStartup(1);
            dispatcher.addMapping("/");
        }

    }
