package com.durys.jakub.offerservice.offer.domain.event;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.offer.domain.Price;

import java.time.Instant;

public record OfferPublished(Instant at, OfferId offerId, ClientId clientId, Price price) implements DomainEvent { //todo

    public OfferPublished(OfferId offerId, ClientId clientId, Price price) {
        this(Instant.now(), offerId, clientId, price);
    }

}
