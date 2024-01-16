package com.durys.jakub.offerservice.rebate;

import com.durys.jakub.offerservice.client.domain.Client;

public interface RebatePolicy {
    Rebate calculateRebate(Client.Type clientType);
}
