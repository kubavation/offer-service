package com.durys.jakub.offerservice.offer.infrastructure;

import com.durys.jakub.offerservice.offer.domain.Offer;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.offer.domain.OfferRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryOfferRepository implements OfferRepository {

    private static final Map<OfferId, Offer> DB = new HashMap<>();

    @Override
    public Offer load(OfferId offerId) {
        return DB.get(offerId);
    }

    @Override
    public void save(Offer offer) {
        DB.put(offer.id(), offer);
    }
}
