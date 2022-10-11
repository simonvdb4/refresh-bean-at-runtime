package com.refresh.bean.refreshbean.config;

import com.refresh.bean.refreshbean.service.domain.Boontje;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
public class RefreshBeanConfiguration {
    @Bean("refreshBoontje")
    public Boontje refreshBoontje() {
        Boontje boontje = new Boontje();
        boontje.setProperty("at runtime write" + Instant.now());
        return boontje;
    }
}
