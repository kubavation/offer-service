package com.durys.jakub.offerservice.client.application;

import com.durys.jakub.offerservice.client.domain.Client;
import com.durys.jakub.offerservice.client.domain.ClientRepository;
import com.durys.jakub.offerservice.client.domain.RebatePolicy;
import com.durys.jakub.offerservice.client.domain.command.MarkClientAsRegularCommand;
import com.durys.jakub.offerservice.client.domain.command.MarkClientAsVipCommand;
import com.durys.jakub.offerservice.client.domain.command.GrantRebateCommand;
import com.durys.jakub.offerservice.client.domain.command.RemoveRebateCommand;
import com.durys.jakub.offerservice.ddd.ApplicationService;

import java.util.Objects;

@ApplicationService
public class ClientApplicationService {

    private final ClientRepository clientRepository;
    private final RebatePolicy rebatePolicy;

    public ClientApplicationService(ClientRepository clientRepository, RebatePolicy rebatePolicy) {
        this.clientRepository = clientRepository;
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

}
