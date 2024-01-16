package com.durys.jakub.offerservice.client.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.rebate.RebateId;

public record RemoveRebateCommand(ClientId clientId, RebateId rebateId) implements Command {
}
