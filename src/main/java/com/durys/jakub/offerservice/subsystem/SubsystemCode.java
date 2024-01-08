package com.durys.jakub.offerservice.subsystem;

import com.durys.jakub.offerservice.common.DomainValidationException;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public record SubsystemCode(String value) {

    public SubsystemCode {
        if (Objects.isNull(value) || StringUtils.isBlank(value)) {
            throw new DomainValidationException("Invalid subsystem code");
        }
    }
}
