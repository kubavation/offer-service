package com.durys.jakub.offerservice.subsystem;

import java.util.HashMap;
import java.util.Map;

class InMemorySubsystemRepository implements SubsystemRepository {

    private final static Map<SubsystemCode, Subsystem> DB = new HashMap<>();

    @Override
    public Subsystem load(SubsystemCode code) {
        return DB.get(code);
    }
}
