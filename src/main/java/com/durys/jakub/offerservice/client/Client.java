package com.durys.jakub.offerservice.client;

public class Client {

    enum Type {
        Vip, Regular
    }


    private final ClientId clientId;
    
    public Client(ClientId clientId) {
        this.clientId = clientId;
    }
}
