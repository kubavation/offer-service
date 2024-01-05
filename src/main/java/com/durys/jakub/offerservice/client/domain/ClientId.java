package com.durys.jakub.offerservice.client.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;
import org.apache.commons.lang3.StringUtils;

public record ClientId(String value) {

    public ClientId {
        if (StringUtils.isEmpty(value)) {
            throw new DomainValidationException("Invalid clientId value");
        }
    }
}
