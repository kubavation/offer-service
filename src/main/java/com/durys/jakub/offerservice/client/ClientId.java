package com.durys.jakub.offerservice.client;


import org.apache.commons.lang3.StringUtils;

public record ClientId(String value) {

    public ClientId {
        if (StringUtils.isEmpty(value)) {
            throw new RuntimeException("Invalid clientId value");
        }
    }
}
