package com.durys.jakub.offerservice.subsystem;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.util.Objects;

public record Subsystem(SubsystemCode code) {

    public Subsystem {
        if (Objects.isNull(code)) {
            throw new DomainValidationException("Invalid subsystem code");
        }
    }
}
