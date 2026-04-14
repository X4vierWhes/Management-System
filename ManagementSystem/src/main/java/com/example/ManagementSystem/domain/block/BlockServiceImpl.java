package com.example.ManagementSystem.domain.block;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    private final BlockRepository blockRepository;

    public BlockServiceImpl(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @Override
    public List<Block> findAll() {
        return blockRepository.findAll();
    }

    @Override
    public Block findByIdentification(String identification) {
        return blockRepository.findByIdentification(identification).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Block not found with identification: " + identification));
    }

    @Override
    public void deleteByIdentification(String identification) {
            Block block = blockRepository.findByIdentification(identification)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Block not found with identification: " + identification));
            blockRepository.delete(block);
    }

    @Override
    public Block createBlock(Block block) {
        if(blockRepository.findByIdentification(block.getIdentification()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Block already exists");
        }

        block.generateUnits();
        return blockRepository.save(block);
    }

    @Override
    public void updateBlock(Block block) {
            Block existingBlock = blockRepository.findById(block.getId())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Block not found"));

            existingBlock.setIdentification(block.getIdentification());
            existingBlock.setAmtFloors(block.getAmtFloors());
            existingBlock.setAptPerFloor(block.getAptPerFloor());

            blockRepository.save(existingBlock);
    }
}
