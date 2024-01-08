package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.ddd.DomainFactory;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.subsystem.SubsystemCode;

@DomainFactory
public class OfferFactory {

    private final EventPublisher eventPublisher;

    OfferFactory(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public Offer create(String name, String description, SubsystemCode subsystem) {
        return new Offer(name, description, subsystem, eventPublisher);
    }

}
