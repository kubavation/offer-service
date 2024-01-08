package com.durys.jakub.offerservice.offer.domain;

public interface OfferRepository {
    Offer load(OfferId offerId);
    void save(Offer offer);
}
