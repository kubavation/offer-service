package com.durys.jakub.offerservice.events;

import com.durys.jakub.offerservice.events.outbox.EventsRepository;
import com.durys.jakub.offerservice.events.outbox.InMemoryEventsRepository;
import com.durys.jakub.offerservice.events.outbox.OutboxEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
class EventsConfiguration {

    @Bean
    EventsRepository eventsRepository() {
        return new InMemoryEventsRepository();
    }

    @Bean
    EventPublisher eventPublisher(EventsRepository eventsRepository) {
        return new OutboxEventPublisher(eventsRepository);
    }

}
