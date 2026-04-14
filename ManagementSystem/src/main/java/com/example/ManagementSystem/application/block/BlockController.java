package com.example.ManagementSystem.application.block;

import com.example.ManagementSystem.application.block.dto.BlockDTO;
import com.example.ManagementSystem.domain.block.Block;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/blocks")
public interface BlockController {
    @PostMapping("/create")
    ResponseEntity<Block> createBlock(@RequestBody @Valid BlockDTO block);

}
