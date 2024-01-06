package com.durys.jakub.offerservice.events;

import java.time.Instant;

public interface DomainEvent {
    Instant at();
}
