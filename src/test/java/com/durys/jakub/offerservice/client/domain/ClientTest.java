package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainException;
import com.durys.jakub.offerservice.events.EventPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    private EventPublisher eventPublisher = Mockito.mock(EventPublisher.class);

    @Test
    void shouldAddRebate() {

        Client client = new Client(new ClientId("Client1"), Client.Type.Regular, eventPublisher);
        BigDecimal rebateAmount = new BigDecimal("10.00");

        client.grantRebate(rebateAmount);

        assertEquals(1, client.rebates().size());
    }

    @Test
    void shouldRemoveRebate() {

        Client client = new Client(new ClientId("Client1"), Client.Type.Regular, eventPublisher);
        BigDecimal rebateAmount = new BigDecimal("10.00");
        UUID rebateId = client.grantRebate(rebateAmount);

        assertEquals(1, client.rebates().size());

        client.removeRebate(rebateId);

        assertEquals(0, client.rebates().size());
    }

    @Test
    void shouldMarkClientAsVip() {

        Client client = new Client(new ClientId("Client1"), Client.Type.Regular, eventPublisher);

        client.markAsVipClient();

        assertEquals(Client.Type.Vip, client.type());
    }

    @Test
    void shouldMarkClientAsRegular() {

        Client client = new Client(new ClientId("Client1"), Client.Type.Vip, eventPublisher);

        client.markAsRegularClient();

        assertEquals(Client.Type.Regular, client.type());
    }

    @Test
    void shouldNotMarkClientAsVip() {
        Client client = new Client(new ClientId("Client1"), Client.Type.Vip, eventPublisher);

        assertThrows(DomainException.class, client::markAsVipClient);
    }

    @Test
    void shouldNotMarkClientAsRegular() {
        Client client = new Client(new ClientId("Client1"), Client.Type.Regular, eventPublisher);

        assertThrows(DomainException.class, client::markAsRegularClient);
    }
}