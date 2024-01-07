package com.durys.jakub.offerservice.client.intrastructure;

import com.durys.jakub.offerservice.client.domain.Client;
import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.client.domain.ClientRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InMemoryClientRepository implements ClientRepository {

    private static final Map<ClientId, Client> DB = new HashMap<>();

    @Override
    public Client load(ClientId clientId) {
        Client client = DB.get(clientId);
        if (Objects.isNull(client)) {
            throw new RuntimeException("Client not found");
        }
        return client;
    }

    @Override
    public void save(Client client) {
        DB.put(client.id(), client);
    }

    public void clear() {
        DB.clear();
    }
}
