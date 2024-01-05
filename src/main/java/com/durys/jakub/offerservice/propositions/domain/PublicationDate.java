package com.durys.jakub.offerservice.propositions.domain;

import java.time.LocalDate;
import java.util.Objects;

record PublicationDate(LocalDate value) {

    PublicationDate {

        if (Objects.isNull(value)) {
            throw new RuntimeException("Invalid value of publication date");
        }

    }

}
