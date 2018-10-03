package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class BlockProvider {

    private final BlockRepository blockRepository;


    static void getBlock(){
    }

    public Boolean isChainValid() {
        Block currentBlock;
        Block previousBlock;

        ArrayList<Block> blockChain = blockRepository.getBlockChain();

        for(int i=1; i < blockChain.size(); i++) {
            currentBlock = blockChain.get(i);
            previousBlock = blockChain.get(i-1);

            // hash값이 옳은지 확인
            if(!currentBlock.getHash().equals(currentBlock.calculateHash()) ){
                System.out.println("Current Hashes not equal");
                return false;
            }

            // 이 전 블록과의 연결이 유효한지 확인
            if(!previousBlock.getHash().equals(currentBlock.getPreviousHash()) ) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

}
