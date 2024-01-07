package com.durys.jakub.offerservice.client.domain;

public interface ClientRepository {

    Client load(ClientId clientId);

    void save(Client client);
}
