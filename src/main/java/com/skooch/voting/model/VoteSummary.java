package com.skooch.voting.model;

import lombok.Data;

@Data
public class VoteSummary {

    private int id;
    private String name;
    private String address;
    private String winner;
    private boolean state;

}
