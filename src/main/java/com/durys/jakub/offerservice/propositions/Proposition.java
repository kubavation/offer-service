package com.durys.jakub.offerservice.propositions;

import com.durys.jakub.offerservice.client.domain.ClientId;

public class Proposition {

    private final PropositionId propositionId;
    private final ClientId clientId;
    private final Details details;

    public Proposition(PropositionId propositionId, ClientId clientId, Details details) {
        this.propositionId = propositionId;
        this.clientId = clientId;
        this.details = details;
    }
}
