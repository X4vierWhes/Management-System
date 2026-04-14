package com.example.ManagementSystem.application.block;

import com.example.ManagementSystem.application.block.dto.BlockDTO;
import com.example.ManagementSystem.domain.block.Block;
import com.example.ManagementSystem.domain.block.BlockService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BlockControllerImpl implements BlockController{
    private final BlockService blockService;

    public BlockControllerImpl(BlockService blockService) {
        this.blockService = blockService;
    }

    @Override
    public ResponseEntity<List<BlockDTO>> getAllBlocks() {
        return ResponseEntity.ok(blockService.findAll().stream().map(BlockDTO::fromBlock).toList());
    }

    @Override
    public ResponseEntity<Block> createBlock(BlockDTO blockdto) {
        Block block = blockdto.toBlock();
        return ResponseEntity.ok(blockService.createBlock(block));
    }
}
