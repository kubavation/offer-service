package com.durys.jakub.offerservice.client.application;

import com.durys.jakub.offerservice.client.domain.Client;
import com.durys.jakub.offerservice.client.domain.ClientRepository;
import com.durys.jakub.offerservice.client.domain.PublishedOffer;
import com.durys.jakub.offerservice.client.domain.PublishedOfferRepository;
import com.durys.jakub.offerservice.client.domain.command.*;
import com.durys.jakub.offerservice.rebate.Rebate;
import com.durys.jakub.offerservice.rebate.RebatePolicy;
import com.durys.jakub.offerservice.ddd.ApplicationService;

import java.util.Objects;

@ApplicationService
public class ClientApplicationService {

    private final ClientRepository clientRepository;
    private final PublishedOfferRepository publishedOfferRepository;
    private final RebatePolicy rebatePolicy;

    ClientApplicationService(ClientRepository clientRepository, PublishedOfferRepository publishedOfferRepository, RebatePolicy rebatePolicy) {
        this.clientRepository = clientRepository;
        this.publishedOfferRepository = publishedOfferRepository;
        this.rebatePolicy = rebatePolicy;
    }

    //transactional
    public void handle(GrantRebateCommand command) {

        Client client = clientRepository.load(command.clientId());

        var rebateAmount = command.amount();

        if (Objects.isNull(rebateAmount)) {
            rebateAmount = rebatePolicy.calculateRebate(client.type()).amount();
        }

        client.grantRebate(rebateAmount);

        clientRepository.save(client);
    }

    public void handle(RemoveRebateCommand command) {

        Client client = clientRepository.load(command.clientId());

        client.removeRebate(command.rebateId());

        clientRepository.save(client);
    }

    public void handle(MarkClientAsVipCommand command) {

        Client client = clientRepository.load(command.clientId());

        client.markAsVipClient();

        clientRepository.save(client);
    }

    public void handle(MarkClientAsRegularCommand command) {

        Client client = clientRepository.load(command.clientId());

        client.markAsRegularClient();

        clientRepository.save(client);
    }

    public void handle(AcceptOfferCommand command) {

        Client client = clientRepository.load(command.clientId());

        PublishedOffer offer = publishedOfferRepository.load(new PublishedOffer.Id(command.offerId(), command.clientId()));

        if (command.rebateUsed()) {
            Rebate rebate = client.findRebate(command.rebateId());
            offer.apply(rebate);
        }

        offer.accept();

        publishedOfferRepository.save(offer);
    }

}
