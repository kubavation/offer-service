package com.durys.jakub.offerservice.offer.domain.command;

import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.offer.domain.OfferId;

public record RemoveOfferCommand(OfferId offerId) implements Command {
}
