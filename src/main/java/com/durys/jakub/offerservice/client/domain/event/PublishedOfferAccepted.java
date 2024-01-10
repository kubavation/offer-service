package com.durys.jakub.offerservice.client.domain.event;

import com.durys.jakub.offerservice.client.domain.PublishedOffer;
import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.offer.domain.Price;

import java.time.Instant;

public record PublishedOfferAccepted(Instant at, PublishedOffer.Id offerId, Price price) implements DomainEvent {

    public PublishedOfferAccepted(PublishedOffer.Id offerId, Price price) {
        this(Instant.now(), offerId, price);
    }

}
