package com.durys.jakub.offerservice.client.application.event;

import com.durys.jakub.offerservice.client.domain.PublishedOffer;
import com.durys.jakub.offerservice.client.domain.PublishedOfferFactory;
import com.durys.jakub.offerservice.client.domain.PublishedOfferRepository;
import com.durys.jakub.offerservice.ddd.DomainEventHandler;
import com.durys.jakub.offerservice.offer.domain.event.OfferPublished;

@DomainEventHandler
class OfferEventHandler {

    private final PublishedOfferRepository publishedOfferRepository;
    private final PublishedOfferFactory publishedOfferFactory;

    OfferEventHandler(PublishedOfferRepository publishedOfferRepository,
                      PublishedOfferFactory publishedOfferFactory) {
        this.publishedOfferRepository = publishedOfferRepository;
        this.publishedOfferFactory = publishedOfferFactory;
    }

    //handler
    void handle(OfferPublished event) {

        PublishedOffer offer = publishedOfferFactory.create(event.offerId(), event.clientId(), event.price());

        publishedOfferRepository.save(offer);
    }
}
