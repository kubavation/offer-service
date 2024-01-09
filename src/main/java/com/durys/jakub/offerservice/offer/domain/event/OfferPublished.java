package com.durys.jakub.offerservice.offer.domain.event;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.time.Instant;

public record OfferPublished(Instant at, OfferId offerId, ClientId clientId) implements DomainEvent { //todo

    public OfferPublished(OfferId offerId, ClientId clientId) {
        this(Instant.now(), offerId, clientId);
    }

}
