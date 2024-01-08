package com.durys.jakub.offerservice.events.outbox;

import com.durys.jakub.offerservice.events.DomainEvent;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.context.ApplicationEventPublisher;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutboxServiceTest {

    private class MockEvent implements DomainEvent {

        @Override
        public Instant at() {
            return Instant.now();
        }
    }

    private final EventsRepository eventsRepository = new InMemoryEventsRepository();

    private final ApplicationEventPublisher applicationEventPublisher = Mockito.mock(ApplicationEventPublisher.class);

    private final OutboxService outboxService = new OutboxService(eventsRepository, applicationEventPublisher);

    @Test
    void shouldSendEvents() {

        List<DomainEvent> mockEvents = Arrays.asList(new MockEvent(), new MockEvent());

        mockEvents.stream()
                    .forEach(eventsRepository::save);

        outboxService.sendEvents();

        assertTrue(eventsRepository.loadPending().isEmpty());
        Mockito.verify(applicationEventPublisher, Mockito.times(2)).publishEvent(Mockito.any(MockEvent.class));
    }

}