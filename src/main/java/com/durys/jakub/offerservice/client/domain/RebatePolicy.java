package com.durys.jakub.offerservice.client.domain;

public interface RebatePolicy {
    Rebate calculateRebate(Client.Type clientType);
}
