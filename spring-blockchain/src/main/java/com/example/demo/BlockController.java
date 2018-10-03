package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blocks")
public class BlockController {

    //TODO:Repository 바로 호출하지 않고, Service 레이어 또는 Provider 레이어에서 호출하도록 변경
    private final BlockRepository blockRepository;

    private final BlockProvider blockProvider;

    @GetMapping
    public String blockChainInfo(){

        //TODO:블록체인 정보 조회
        System.out.println(blockProvider.isChainValid());

        return "";
    }


    @PostMapping
    public String mineBlock(@RequestParam(name="data") String data){

        String previousHash = blockRepository.getBlockChain().isEmpty()? "0" : blockRepository.getBlockChain().get(blockRepository.getBlockChain().size() - 1).getHash();
        blockRepository.getBlockChain().add(new Block(data, previousHash));

        return "OK";
    }


}
