package com.depainspring.proj.service.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Component
public class MessageManager  {

    private Environment environment;

    public MessageManager(Environment environment) {
        this.environment = environment;
        }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

}

    /* public static MessageManager getInstance() {
        if (instance == null) {
            instance = new MessageManager();
*//*
            try (InputStream input = new FileInputStream(BUNDLE_NAME)) {
                instance.properties.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*//*

        }
        return instance;
    }*/

   /*public static void errorRedirect(HttpServletRequest request, HttpServletResponse resp) {

        request.setAttribute("errorMessage", MessageManager.getInstance().getProperty(MessageManager.SERVLET_EXCEPTION_ERROR_MESSAGE));
        String pagePath = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ERROR_PAGE_PATH);
        try {
            request.getRequestDispatcher(pagePath).forward(request, resp);
        }catch (ServletException | IOException e){
            e.printStackTrace();
        }
    }*/


   /* public String getProperty(String key) {
        return environment.getProperty(key);
    }
*/

