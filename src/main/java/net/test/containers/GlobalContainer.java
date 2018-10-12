package net.test.containers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class GlobalContainer implements ApplicationContextAware {

    @Bean("GlobalServiceResourceProvider")
    public IServiceResourceProvider buildServiceResourceProvider(){
        return new ServiceResourceProvider(applicationContext);
    }

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}

