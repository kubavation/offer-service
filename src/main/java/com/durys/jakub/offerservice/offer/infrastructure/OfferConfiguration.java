package com.durys.jakub.offerservice.offer.infrastructure;

import com.durys.jakub.offerservice.offer.domain.OfferRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OfferConfiguration {
    
    @Bean
    OfferRepository offerRepository() {
        return new InMemoryOfferRepository();
    }
}
