package com.skooch.voting.model;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;

@Data
@ToString
public class VoteInfo {
    private String voteName;
    private int voteNumber;
    private long SuccessPercentage;
    private ArrayList<String> candidates;
    private String privateKey;
}
