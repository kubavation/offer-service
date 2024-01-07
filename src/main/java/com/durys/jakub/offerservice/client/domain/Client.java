package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Client {


    public enum Type {
        Vip, Regular
    }

    private final ClientId clientId;
    private Type type;
    private final List<Rebate> rebates = new ArrayList<>();

    public Client(ClientId clientId, Type type) {
        this.clientId = clientId;
        this.type = type;
    }


    public UUID grantRebate(BigDecimal amount) {

        var rebateId = UUID.randomUUID();

        rebates.add(new Rebate(rebateId, amount));

        return rebateId;
    }

    public void removeRebate(UUID rebateId) {
        rebates.removeIf(rebate -> rebate.id().equals(rebateId));
    }

    public void markAsVipClient() {

        if (type == Type.Vip) {
            throw new DomainException("Client is already marked as VIP");
        }

        type = Type.Vip;
    }

    public void markAsRegularClient() {

        if (type == Type.Regular) {
            throw new DomainException("Client is already marked as Regular");
        }

        type = Type.Regular;
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
}
