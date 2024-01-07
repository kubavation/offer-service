package com.durys.jakub.offerservice.client.intrastructure;

import com.durys.jakub.offerservice.client.domain.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class ClientsConfig {

    @Bean
    ClientRepository clientRepository() {
        return new InMemoryClientRepository();
    }
}
