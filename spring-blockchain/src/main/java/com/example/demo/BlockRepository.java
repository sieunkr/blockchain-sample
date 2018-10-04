package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BlockRepository {

    private static ArrayList<Block> blockChain = new ArrayList<>();

    public ArrayList<Block> findAllBlockChain() {
        return blockChain;
    }

}
