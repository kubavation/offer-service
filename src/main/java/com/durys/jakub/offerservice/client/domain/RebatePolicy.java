package com.durys.jakub.offerservice.client.domain;

interface RebatePolicy {
    Rebate calculateRebate(Client.Type clientType);
}
