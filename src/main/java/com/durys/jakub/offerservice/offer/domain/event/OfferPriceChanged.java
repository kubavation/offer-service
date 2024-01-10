package com.durys.jakub.offerservice.offer.domain.event;

import com.durys.jakub.offerservice.events.DomainEvent;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.offer.domain.Price;

import java.time.Instant;

public record OfferPriceChanged(Instant at, OfferId offerId, Price price) implements DomainEvent {

    public OfferPriceChanged(OfferId offerId, Price price) {
        this(Instant.now(), offerId, price);
    }

}
