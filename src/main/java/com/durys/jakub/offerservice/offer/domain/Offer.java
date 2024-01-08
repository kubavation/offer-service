package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;

public class Offer extends AggregateRoot {

    private final OfferId offerId;

    Offer(EventPublisher eventPublisher, OfferId offerId) {
        super(eventPublisher);
        this.offerId = offerId;
    }
}
