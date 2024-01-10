package com.durys.jakub.offerservice.client.intrastructure;

import com.durys.jakub.offerservice.client.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InMemoryPublishedOfferRepository implements PublishedOfferRepository {

    private static final Map<PublishedOffer.Id, PublishedOffer> DB = new HashMap<>();

    @Override
    public PublishedOffer load(PublishedOffer.Id id) {
        PublishedOffer offer = DB.get(id);
        if (Objects.isNull(offer)) {
            throw new RuntimeException("Client not found");
        }
        return offer;
    }

    @Override
    public void save(PublishedOffer offer) {
        DB.put(offer.id(), offer);
    }

    public void clear() {
        DB.clear();
    }
}
