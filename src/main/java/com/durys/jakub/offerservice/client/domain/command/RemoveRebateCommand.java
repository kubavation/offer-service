package com.durys.jakub.offerservice.client.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;

import java.util.UUID;

public record RemoveRebateCommand(ClientId clientId, UUID rebateId) {
}
