package com.refresh.bean.refreshbean.controller;

import com.refresh.bean.refreshbean.service.RefreshBeanService;
import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bean")
public class RefreshBeanController {
    Logger logger = LoggerFactory.getLogger(RefreshBeanController.class);

    public final RefreshBeanService refreshBeanService;
    public final ApplicationContext context;

    public RefreshBeanController(RefreshBeanService refreshBeanService, ApplicationContext context) {
        this.refreshBeanService = refreshBeanService;
        this.context = context;
    }

    @GetMapping("/refresh")
    public ResponseEntity<Void> refreshBean() {
        Boontje refreshBoontje = (Boontje) context.getBean("refreshBoontje");
        logRefreshBoontje(refreshBoontje);

        refreshBeanService.refreshBean();

        refreshBoontje = (Boontje) context.getBean("refreshBoontje");
        logRefreshBoontje(refreshBoontje);

        return ResponseEntity.ok().build();
    }

    private void logRefreshBoontje(Boontje refreshBoontje) {
        logger.warn("Application context is geladen met: {} en heeft als property: {}", refreshBoontje, refreshBoontje.getProperty());
    }
}
