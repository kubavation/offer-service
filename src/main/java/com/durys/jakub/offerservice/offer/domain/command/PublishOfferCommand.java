package com.durys.jakub.offerservice.offer.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.math.BigDecimal;

public record PublishOfferCommand(OfferId offerId, ClientId clientId, BigDecimal price) implements Command {
}
