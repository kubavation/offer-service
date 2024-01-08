package com.durys.jakub.offerservice.client.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.cqrs.Command;

public record MarkClientAsRegularCommand(ClientId clientId) implements Command {
}
