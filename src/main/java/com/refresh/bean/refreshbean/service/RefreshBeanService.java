package com.refresh.bean.refreshbean.service;

import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class RefreshBeanService {
    public final ApplicationContext context;

    public RefreshBeanService(ApplicationContext context) {
        this.context = context;
    }

    public void refreshBean() {
        // Retrieve BeanDefinitionRegistry
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) context.getAutowireCapableBeanFactory();

        // remove bean
        String beanNameOld = "refreshBoontje";
        registry.removeBeanDefinition(beanNameOld);

        // create bean
        RootBeanDefinition beanDefinition = new RootBeanDefinition(Boontje.class);
        beanDefinition.setPropertyValues(new MutablePropertyValues().add("property", "new property"));

        // add bean to registry
        String beanNameNew = "refreshBoontje";
        registry.registerBeanDefinition(beanNameNew, beanDefinition);
    }
}
