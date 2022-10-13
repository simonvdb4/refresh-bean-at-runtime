package com.refresh.bean.refreshbean.service;

import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RefreshBeanService {
    public final ApplicationContext context;

    @Resource(name = "refreshBoontje")
    Boontje boontje;

    public RefreshBeanService(ApplicationContext context) {
        this.context = context;
    }

    public void refreshBean() {
        boontje.setProperty("new property");
    }
}
