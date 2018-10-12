package net.test.containers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

//@Component
public class ServiceResourceProvider implements IServiceResourceProvider {
//    @Autowired
//    private GlobalServiceResourceContainer container;


    public ServiceResourceProvider(ApplicationContext applicationContext) {
        this.applicationContext=applicationContext;
    }

    private ApplicationContext applicationContext;

    @Override
    public <T> T getService(String typeKey, Class<T> serviceClass) {
        return applicationContext.getBean(typeKey,serviceClass);
    }

    @Override
    public <T> T getService(Class<T> serviceClass) {
        return applicationContext.getBean(serviceClass);
    }
}
