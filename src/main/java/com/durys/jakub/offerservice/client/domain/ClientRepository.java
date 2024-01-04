package com.durys.jakub.offerservice.client.domain;

public interface ClientRepository {

    Client load(ClientId client);

    void save(Client client);
}
