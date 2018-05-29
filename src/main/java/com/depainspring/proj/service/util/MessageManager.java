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
public class MessageManager implements MessageManagerConstants {



   /* private static MessageManager instance = null;
    private Properties properties;*/
   private String DEP_RECORD_UPDATE_SUCCESS_MESSAGE;


//private Environment environment;

    public MessageManager() {

    }

    public String getDEP_RECORD_UPDATE_SUCCESS_MESSAGE() {
        return DEP_RECORD_UPDATE_SUCCESS_MESSAGE;
    }

    public void setDEP_RECORD_UPDATE_SUCCESS_MESSAGE(String DEP_RECORD_UPDATE_SUCCESS_MESSAGE) {
        this.DEP_RECORD_UPDATE_SUCCESS_MESSAGE = DEP_RECORD_UPDATE_SUCCESS_MESSAGE;
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

}
