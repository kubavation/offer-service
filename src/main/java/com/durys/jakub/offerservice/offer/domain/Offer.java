package com.durys.jakub.offerservice.offer.domain;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.common.DomainException;
import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.offer.domain.event.OfferPublished;
import com.durys.jakub.offerservice.offer.domain.event.OfferRemoved;
import com.durys.jakub.offerservice.subsystem.SubsystemCode;

import java.util.UUID;

public class Offer extends AggregateRoot {

    public enum State {
        Submitted, Published, Removed
    }

    private final OfferId offerId;
    private final SubsystemCode subsystemCode;
    private Details details;
    private Price price;
    private State state;

    //todo local state of clients?

    Offer(EventPublisher eventPublisher, OfferId offerId, SubsystemCode subsystemCode) {
        super(eventPublisher);
        this.offerId = offerId;
        this.subsystemCode = subsystemCode;
    }

    Offer(String name, String description, SubsystemCode subsystemCode, Price price, EventPublisher eventPublisher) {
        super(eventPublisher);
        this.offerId = new OfferId(UUID.randomUUID());
        this.details = new Details(name, description);
        this.subsystemCode = subsystemCode;
        this.price = price;
        this.state = State.Submitted;
    }

    public void publishTo(ClientId client) {

        apply(new OfferPublished(offerId, client));
    }

    public void remove() {

        if (state == State.Removed) {
            throw new DomainException("Cannot remove offer");
        }

        state = State.Removed;

        apply(new OfferRemoved(offerId));
    }

    public OfferId id() {
        return offerId;
    }
}
