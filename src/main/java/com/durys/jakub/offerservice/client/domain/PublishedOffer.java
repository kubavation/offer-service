package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.client.domain.event.PublishedOfferAccepted;
import com.durys.jakub.offerservice.common.DomainException;
import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.offer.domain.Price;

import java.util.Objects;

public class PublishedOffer extends AggregateRoot {

    public enum State {
        New, Accepted
    }


    public record Id(OfferId offerId, ClientId clientId) {

        public Id {
            if (Objects.isNull(offerId)) {
                throw new DomainException("Invalid offer ID value");
            }

            if (Objects.isNull(clientId)) {
                throw new DomainException("Invalid client ID value");
            }
        }

    }

    private final Id id;
    private Price price;
    private State state;

    PublishedOffer(Id id, Price price, EventPublisher eventPublisher) {
        super(eventPublisher);
        this.id = id;
        this.price = price;
        this.state = State.New;
    }

    public void changePrice(Rebate rebate) {
        //todo
    }

    public void accept() {

        if (state != State.New) {
            throw new DomainException("Cannot accept offer");
        }

        apply(new PublishedOfferAccepted(id, price));
    }


    public Id id() {
        return id;
    }


}
