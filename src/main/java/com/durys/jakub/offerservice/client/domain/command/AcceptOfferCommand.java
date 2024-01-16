package com.durys.jakub.offerservice.client.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;
import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.offer.domain.OfferId;
import com.durys.jakub.offerservice.rebate.RebateId;

import java.util.Objects;

public record AcceptOfferCommand(ClientId clientId, OfferId offerId, RebateId rebateId) implements Command {

    public boolean rebateUsed() {
        return Objects.nonNull(rebateId);
    }

}
