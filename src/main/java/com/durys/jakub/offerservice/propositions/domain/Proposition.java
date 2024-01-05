package com.durys.jakub.offerservice.propositions.domain;

import com.durys.jakub.offerservice.client.domain.ClientId;

public class Proposition {

    enum State {
        Published, Answered
    }

    private final PropositionId propositionId;
    private final ClientId clientId;
    private final Details details;
    private final PublicationDate publicationDate;

    Proposition(PropositionId propositionId, ClientId clientId, Details details, PublicationDate publicationDate) {
        this.propositionId = propositionId;
        this.clientId = clientId;
        this.details = details;
        this.publicationDate = publicationDate;
    }
}
