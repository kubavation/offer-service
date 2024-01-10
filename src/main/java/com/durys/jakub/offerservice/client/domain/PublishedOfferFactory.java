package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.ddd.DomainFactory;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.offer.domain.Price;

@DomainFactory
public class PublishedOfferFactory {

    private final EventPublisher eventPublisher;

    PublishedOfferFactory(EventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public PublishedOffer create(OfferId offerId, ClientId clientId, Price price) {
        return new PublishedOffer(new PublishedOffer.Id(offerId, clientId), price, eventPublisher);
    }

}
