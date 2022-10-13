package com.skooch.voting.utils;

import com.skooch.voting.contracts.Ballot;
import com.skooch.voting.model.VoteInfo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.util.HashMap;

@Component
public class web3jUtils {

    private static Ballot chairman_ballot;

    private static VoteInfo voteInfo;

    //将字符串转换为比特流，修正
    public static byte[] stringToBytes32(String str){
        byte[] a = new byte[32];
        System.arraycopy(str.getBytes(),0,a,0,str.getBytes().length);
        return a;
    }
    //获取web3j对象
    @Bean("Web3j")
    private static Web3j getWeb3j(){
        return Web3j.build(new HttpService("http://localhost:8545"));
    }

    public static Ballot getBallot() {
        return chairman_ballot;
    }

    public static void setBallot(Ballot ballot) {
        web3jUtils.chairman_ballot = ballot;
    }


    public static VoteInfo getVoteInfo() {
        return voteInfo;
    }

    public static void setVoteInfo(VoteInfo voteInfo) {
        web3jUtils.voteInfo = voteInfo;
    }

    public static HashMap<String, Integer> checkVotes() throws Exception {

        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0;i<chairman_ballot.getProposalNumber().send().getValue().intValue();i++){
            byte[] value1 = chairman_ballot.proposals(new Uint256(i)).send().getValue1().getValue();
            String value = new String(value1).trim();
            int value2 = chairman_ballot.proposals(new Uint256(i)).send().getValue2().getValue().intValue();
            map.put(value,value2);
        }
        return map;
    }
}
