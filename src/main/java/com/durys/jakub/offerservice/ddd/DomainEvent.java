package com.durys.jakub.offerservice.ddd;

import java.time.Instant;

public interface DomainEvent {
    Instant at();
}
