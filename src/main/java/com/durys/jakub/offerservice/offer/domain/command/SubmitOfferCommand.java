package com.durys.jakub.offerservice.offer.domain.command;

import com.durys.jakub.offerservice.cqrs.Command;
import com.durys.jakub.offerservice.subsystem.SubsystemCode;

import java.math.BigDecimal;

public record SubmitOfferCommand(String name, String description, BigDecimal price, SubsystemCode subsystemCode) implements Command {
}
