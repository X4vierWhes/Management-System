package com.example.ManagementSystem.domain.unit;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository {
    Optional<Unit> findByResidentId(Long id);

    Optional<Unit> findById(Long id);

    void save(Unit unit);

    List<Unit> findAll();

    List<Unit> findByFloor(int floor);

    Unit findByIdentification(String identification);

    List<Unit> findByBlockId(Long blockId);

    List<Unit> findByFloorAndBlockId(Integer floor, Integer blockId);

}
