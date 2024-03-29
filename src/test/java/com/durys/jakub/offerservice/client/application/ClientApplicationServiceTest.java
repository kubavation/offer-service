package com.durys.jakub.offerservice.client.application;

import com.durys.jakub.offerservice.client.domain.Client;
import com.durys.jakub.offerservice.client.domain.ClientFactory;
import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.client.domain.ClientRepository;
import com.durys.jakub.offerservice.client.domain.command.GrantRebateCommand;
import com.durys.jakub.offerservice.client.domain.command.MarkClientAsRegularCommand;
import com.durys.jakub.offerservice.client.domain.command.MarkClientAsVipCommand;
import com.durys.jakub.offerservice.client.domain.command.RemoveRebateCommand;
import com.durys.jakub.offerservice.common.DomainException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientApplicationServiceTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientFactory clientFactory;

    @Autowired
    private ClientApplicationService clientApplicationService;


    @Test
    void shouldGrantRebate_whenAmountIsSpecified() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Vip);
        clientRepository.save(client);

        assertTrue(client.rebates().isEmpty());
        var command = new GrantRebateCommand(client.id(), BigDecimal.valueOf(70));
        clientApplicationService.handle(command);


        Client loaded = clientRepository.load(client.id());
        assertFalse(loaded.rebates().isEmpty());
    }

    @Test
    void shouldGrantRebate_whenAmountIsNotSpecified() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Vip);
        clientRepository.save(client);

        assertTrue(client.rebates().isEmpty());
        var command = new GrantRebateCommand(client.id(), BigDecimal.valueOf(70));
        clientApplicationService.handle(command);


        Client loaded = clientRepository.load(client.id());
        assertFalse(loaded.rebates().isEmpty());
    }


    @Test
    void shouldRemoveRebate() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Vip);
        UUID rebateId = client.grantRebate(BigDecimal.valueOf(20));
        clientRepository.save(client);

        var command = new RemoveRebateCommand(client.id(), rebateId);
        clientApplicationService.handle(command);

        Client loaded = clientRepository.load(client.id());
        assertTrue(loaded.rebates().isEmpty());
    }

    @Test
    void shouldMarkClientAsVip() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Regular);
        clientRepository.save(client);

        var command = new MarkClientAsVipCommand(client.id());
        clientApplicationService.handle(command);

        Client loaded = clientRepository.load(client.id());
        assertEquals(Client.Type.Vip, loaded.type());
    }

    @Test
    void shouldNotMarkClientAsVip() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Vip);
        clientRepository.save(client);

        var command = new MarkClientAsVipCommand(client.id());
        DomainException exception = assertThrows(DomainException.class, () -> clientApplicationService.handle(command));

        assertEquals("Client is already marked as VIP", exception.getMessage());
    }

    @Test
    void shouldMarkClientAsRegular() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Vip);
        clientRepository.save(client);

        var command = new MarkClientAsRegularCommand(client.id());
        clientApplicationService.handle(command);

        Client loaded = clientRepository.load(client.id());
        assertEquals(Client.Type.Regular, loaded.type());
    }

    @Test
    void shouldNotMarkClientAsRegular() {

        Client client = clientFactory.create(UUID.randomUUID().toString(), Client.Type.Regular);
        clientRepository.save(client);

        var command = new MarkClientAsRegularCommand(client.id());
        DomainException exception = assertThrows(DomainException.class, () -> clientApplicationService.handle(command));

        assertEquals("Client is already marked as Regular", exception.getMessage());
    }

}