package com.example.ManagementSystem.application.block.dto;

import com.example.ManagementSystem.domain.block.Block;
import jakarta.validation.constraints.NotBlank;

public record BlockDTO(
        @NotBlank(message = "identification must not be empty")
        String identification,
        @NotBlank(message = "amtFloors is mandatory")
        String amtFloors,
        @NotBlank(message = "aptPerFloor is mandatory")
        String aptPerFloor) {

    public Block toBlock() {
        Block block = new Block();
        block.setIdentification(identification);
        block.setAmtFloors(Integer.parseInt(amtFloors));
        block.setAptPerFloor(Integer.parseInt(aptPerFloor));
        return block;
    }
}
