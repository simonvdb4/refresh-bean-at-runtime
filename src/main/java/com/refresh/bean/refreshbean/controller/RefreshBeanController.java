package com.refresh.bean.refreshbean.controller;

import com.refresh.bean.refreshbean.service.RefreshBeanService;
import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bean")
public class RefreshBeanController {
    public final RefreshBeanService refreshBeanService;
    public final ApplicationContext context;

    public RefreshBeanController(RefreshBeanService refreshBeanService, ApplicationContext context) {
        this.refreshBeanService = refreshBeanService;
        this.context = context;
    }

    @GetMapping("/refresh")
    public ResponseEntity<Void> refreshBean() {
        Boontje refreshBoontje = (Boontje) context.getBean("refreshBoontje");
        System.out.println("Application context is geladen met: " + refreshBoontje + " en heeft als property: " + refreshBoontje.getProperty());

        refreshBeanService.refreshBean();

        refreshBoontje = (Boontje) context.getBean("refreshBoontje");
        System.out.println("Application context is geladen met: " + refreshBoontje + " en heeft als property: " + refreshBoontje.getProperty());

        return ResponseEntity.ok().build();
    }
}
