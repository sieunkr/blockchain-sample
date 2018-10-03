package com.example.demo;

import java.util.Date;

public class Block {

    private String hash;
    private String previousHash;
    private String data;
    private long timeStamp;
    private int nonce;

    private String target = "00000";
    private int targetDepth = 5;

    public Block(String data,String previousHash ) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = new Date().getTime();
        this.hash = calculateHash();
        mineNewBlock();
    }


    /**
     * 신규 블록체인을 생성한다.
     */
    private void mineNewBlock(){

        // 조건에 맞는 Hash 값을 찾을 때까지 계속 반복한다.
        while(!hash.substring(0, targetDepth).equals(target)) {
            nonce ++;
            hash = calculateHash();
        }
    }


    /**
     * Hash 값을 조회한다.
     */
    public String calculateHash() {
        String calculatedhash = StringUtil.getSha256(
                    previousHash +
                        Long.toString(timeStamp) +
                        Integer.toString(nonce) +
                        data
        );
        return calculatedhash;
    }

    public String getHash(){
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }
}
