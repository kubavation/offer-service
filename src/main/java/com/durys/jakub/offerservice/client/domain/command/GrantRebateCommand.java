package com.durys.jakub.offerservice.client.domain.command;

import com.durys.jakub.offerservice.client.domain.ClientId;

import java.math.BigDecimal;
import java.util.Objects;

public record GrantRebateCommand(ClientId clientId, BigDecimal amount) {

    public GrantRebateCommand(ClientId clientId) {
        this(clientId, null);
    }

    public boolean amountDefined() {
        return Objects.nonNull(amount);
    }

}
