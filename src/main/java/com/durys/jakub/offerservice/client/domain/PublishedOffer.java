package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainException;
import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.util.Objects;

public class PublishedOffer extends AggregateRoot {

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

    PublishedOffer(Id id, EventPublisher eventPublisher) {
        super(eventPublisher);
        this.id = id;
    }

    public void accept() {
        //todo
    }

}
