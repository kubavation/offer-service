package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.subsystem.SubsystemCode;

import java.util.UUID;

public class Offer extends AggregateRoot {

    public enum State {
        Submitted, Published, Removed
    }

    private final OfferId offerId;
    private final SubsystemCode subsystemCode;
    private Details details;
    private State state;

    Offer(EventPublisher eventPublisher, OfferId offerId, SubsystemCode subsystemCode) {
        super(eventPublisher);
        this.offerId = offerId;
        this.subsystemCode = subsystemCode;
    }

    Offer(String name, String description, SubsystemCode subsystemCode, EventPublisher eventPublisher) {
        super(eventPublisher);
        this.offerId = new OfferId(UUID.randomUUID());
        this.details = new Details(name, description);
        this.subsystemCode = subsystemCode;
        this.state = State.Submitted;
    }
}
