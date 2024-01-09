package com.durys.jakub.offerservice.offer.domain.event;

import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.time.Instant;

public record OfferRemoved(Instant at, OfferId offerId) implements DomainEvent {

    public OfferRemoved(OfferId offerId) {
        this(Instant.now(), offerId);
    }

}
