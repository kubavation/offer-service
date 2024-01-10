package com.durys.jakub.offerservice.offer.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.math.BigDecimal;
import java.util.Set;

public record PublishOfferCommand(OfferId offerId, Set<ClientId> clientIds, BigDecimal price) implements Command {
}
