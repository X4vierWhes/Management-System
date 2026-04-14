package com.example.ManagementSystem.application.block;

import com.example.ManagementSystem.application.block.dto.BlockDTO;
import com.example.ManagementSystem.domain.block.Block;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/blocks")
public interface BlockController {
    @GetMapping("/all")
    ResponseEntity<List<BlockDTO>> getAllBlocks();
    @PostMapping("/create")
    ResponseEntity<Block> createBlock(@RequestBody @Valid BlockDTO block);

}
