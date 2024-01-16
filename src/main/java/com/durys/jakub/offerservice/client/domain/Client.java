package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.client.domain.event.ClientStatusChanged;
import com.durys.jakub.offerservice.client.domain.event.RebateGranted;
import com.durys.jakub.offerservice.client.domain.event.RebateRemoved;
import com.durys.jakub.offerservice.common.DomainException;
import com.durys.jakub.offerservice.ddd.AggregateRoot;
import com.durys.jakub.offerservice.events.EventPublisher;
import com.durys.jakub.offerservice.rebate.Rebate;
import com.durys.jakub.offerservice.rebate.RebateId;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Client extends AggregateRoot {

    public enum Type {
        Vip, Regular
    }

    private final ClientId clientId;
    private Type type;
    private final List<Rebate> rebates = new ArrayList<>();

    public Client(ClientId clientId, Type type, EventPublisher eventPublisher) {
        super(eventPublisher);
        this.clientId = clientId;
        this.type = type;
    }

    public void accept(PublishedOffer offer, RebateId rebateId) {

        if (Objects.nonNull(rebateId)) {
            Rebate rebate = load(rebateId);
            offer.changePrice(rebate);
        }

        offer.accept();
    }

    public UUID grantRebate(BigDecimal amount) {

        var rebateId = UUID.randomUUID();

        rebates.add(
            new Rebate(rebateId, amount)
        );

        apply(new RebateGranted(clientId, rebateId, amount));

        return rebateId;
    }

    public void removeRebate(RebateId rebateId) {
        rebates
            .removeIf(rebate -> rebate.id().equals(rebateId));

        apply(new RebateRemoved(clientId, rebateId));
    }

    public void markAsVipClient() {

        if (type == Type.Vip) {
            throw new DomainException("Client is already marked as VIP");
        }

        type = Type.Vip;
        apply(new ClientStatusChanged(clientId, type));
    }

    public void markAsRegularClient() {

        if (type == Type.Regular) {
            throw new DomainException("Client is already marked as Regular");
        }

        type = Type.Regular;
        apply(new ClientStatusChanged(clientId, type));
    }

    public List<Rebate> rebates() {
        return rebates;
    }

    public Type type() {
        return type;
    }

    public ClientId id() {
        return clientId;
    }

    Rebate load(RebateId rebateId) {
        return rebates.stream()
                .filter(rebate -> rebate.id().equals(rebateId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Rebate not found"));
    }
}
