package com.durys.jakub.offerservice.client.domain;

public interface PublishedOfferRepository {

    PublishedOffer load(PublishedOffer.Id id);

    void save(PublishedOffer offer);
}
