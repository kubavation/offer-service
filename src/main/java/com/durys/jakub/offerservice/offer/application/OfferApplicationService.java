package com.durys.jakub.offerservice.offer.application;

import com.durys.jakub.offerservice.ddd.ApplicationService;
import com.durys.jakub.offerservice.offer.domain.Offer;
import com.durys.jakub.offerservice.offer.domain.OfferFactory;
import com.durys.jakub.offerservice.offer.domain.OfferRepository;
import com.durys.jakub.offerservice.offer.domain.command.SubmitOfferCommand;

@ApplicationService
public class OfferApplicationService {

    private final OfferRepository offerRepository;
    private final OfferFactory offerFactory;

    public OfferApplicationService(OfferRepository offerRepository, OfferFactory offerFactory) {
        this.offerRepository = offerRepository;
        this.offerFactory = offerFactory;
    }

    void handle(SubmitOfferCommand command) {

        Offer offer = offerFactory.create(command.name(), command.description(), command.subsystemCode(), command.price());

        offerRepository.save(offer);
    }

}
