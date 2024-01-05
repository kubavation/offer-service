package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainException;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public enum Type {
        Vip, Regular
    }

    private final ClientId clientId;
    private Type type;
    private final List<Rebate> rebates = new ArrayList<>();

    Client(ClientId clientId, Type type) {
        this.clientId = clientId;
        this.type = type;
    }

    public void grantRebate(Rebate rebate) {
        rebates.add(rebate);
    }

    public void markAsVipClient() {

        if (type == Type.Vip) {
            throw new DomainException("Client is already marked as VIP");
        }

        type = Type.Vip;
    }

    public void markAsRegularClient() {

        if (type == Type.Regular) {
            throw new DomainException("Client is already marked as VIP");
        }

        type = Type.Regular;
    }
}
