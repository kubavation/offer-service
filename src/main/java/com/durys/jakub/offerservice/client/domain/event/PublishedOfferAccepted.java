package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.PublishedOffer;
import com.durys.jakub.offerservice.events.DomainEvent;

import java.time.Instant;

public record PublishedOfferAccepted(Instant at, PublishedOffer.Id offerId) implements DomainEvent {

    public PublishedOfferAccepted(PublishedOffer.Id offerId) {
        this(Instant.now(), offerId);
    }

}
