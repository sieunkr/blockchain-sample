package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blocks")
public class BlockController {

    private final BlockProvider blockProvider;

    @GetMapping
    public Collection<Block> findAllBlockChain(){

        if(!blockProvider.isChainValid()){
            //블록체인 깨진 경우
        }

        return blockProvider.findAllBlockChain();
    }


    @PostMapping
    public String mineBlock(@RequestParam(name="data") String data){

        blockProvider.mineBlock(data);
        return "OK";
    }


}
