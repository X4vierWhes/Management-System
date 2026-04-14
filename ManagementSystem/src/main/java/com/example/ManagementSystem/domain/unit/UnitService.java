package com.example.ManagementSystem.domain.unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {
    List<Unit> findByResidentId(Long id);

    Unit findById(Long id);

    void save(Unit unit);

    List<Unit> findAll();

    List<Unit> findByFloor(int floor);

    Unit findByIdentification(String identification);

    List<Unit> findByBlockId(Long blockId);

    List<Unit> findByFloorAndBlockId(Integer floor, Long blockId);
}
