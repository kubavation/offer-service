package com.durys.jakub.offerservice.subsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SubsystemConfiguration {

    @Bean
    SubsystemRepository subsystemRepository() {
        return new InMemorySubsystemRepository();
    }

}
