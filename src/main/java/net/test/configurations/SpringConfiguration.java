package net.test.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {

    public CustomBeanDefinitionRegistry customBeanDefinitionRegistry(){
        return new CustomBeanDefinitionRegistry();
    }
}
