package com.durys.jakub.offerservice.client.application.event;

import com.durys.jakub.offerservice.client.domain.PublishedOfferRepository;
import com.durys.jakub.offerservice.ddd.DomainEventHandler;
import com.durys.jakub.offerservice.offer.domain.event.OfferPublished;

@DomainEventHandler
class OfferEventHandler {

    private final PublishedOfferRepository publishedOfferRepository;

    OfferEventHandler(PublishedOfferRepository publishedOfferRepository) {
        this.publishedOfferRepository = publishedOfferRepository;
    }

    void handle(OfferPublished offerPublished) {



    }
}
