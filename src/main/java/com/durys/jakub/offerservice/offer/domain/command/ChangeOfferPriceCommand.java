package com.durys.jakub.offerservice.offer.domain.command;

import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.offer.domain.OfferId;

import java.math.BigDecimal;

public record ChangeOfferPriceCommand(OfferId offerId, BigDecimal price) implements Command {
}
