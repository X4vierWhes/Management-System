package com.example.ManagementSystem.domain.block;

import java.util.Optional;

public interface BlockService {
    Block findByIdentification(String identification);

    void deleteByIdentification(String identification);

    Block createBlock(Block block);

    void updateBlock(Block block);
}
