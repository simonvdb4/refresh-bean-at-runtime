package com.refresh.bean.refreshbean.service;

import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.parsing.BeanComponentDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
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
//        context.getStartupDate()
        AutowireCapableBeanFactory factory =
                context.getAutowireCapableBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
        String beanID = "refreshBoontje";
        registry.removeBeanDefinition(beanID);

        RootBeanDefinition beanDefinition =
                new RootBeanDefinition(Boontje.class); //The service implementation

        beanDefinition.setAttribute("property", "test");
//        beanDefinition.set

        registry.registerBeanDefinition(beanID, beanDefinition);
    }
}
