package com.refresh.bean.refreshbean.config;

import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefreshBeanConfiguration {
    @Bean("refreshBoontje")
    @RefreshScope
    public Boontje refreshBoontje() {
        Boontje boontje = new Boontje();
        boontje.setProperty("old property");
        return boontje;
    }
}
