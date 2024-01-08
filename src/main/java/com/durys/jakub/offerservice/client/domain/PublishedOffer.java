package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;

public class PublishedOffer extends AggregateRoot {

    protected PublishedOffer(EventPublisher eventPublisher) {
        super(eventPublisher);
    }


    public void accept() {
        //todo
    }

}
