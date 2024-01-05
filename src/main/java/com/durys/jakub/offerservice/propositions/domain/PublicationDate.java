package com.durys.jakub.offerservice.propositions.domain;

import com.durys.jakub.offerservice.common.DomainValidationException;

import java.time.LocalDate;
import java.util.Objects;

record PublicationDate(LocalDate value) {

    PublicationDate {

        if (Objects.isNull(value)) {
            throw new DomainValidationException("Invalid value of publication date");
        }

    }

}
