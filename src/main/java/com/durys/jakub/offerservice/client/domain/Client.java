package com.durys.jakub.offerservice.client.domain;

import java.util.ArrayList;
import java.util.List;

public class Client {

    enum Type {
        Vip, Regular
    }

    private final ClientId clientId;
    private Type type;
    private final List<Rebate> rebates = new ArrayList<>();

    Client(ClientId clientId, Type type) {
        this.clientId = clientId;
        this.type = type;
    }
}
