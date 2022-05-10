package com.mcj.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({
        "com.mcj.core"
})
@EntityScan({
        "com.mcj.core"
})
@EnableJpaRepositories({
        "com.mcj.core"
})
@Configuration
public class ModuleConfig {
}
