package com.example.ManagementSystem.domain.unit;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements UnitService {
    final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @Override
    public Unit findByResidentId(Long id) {
        return null;
    }

    @Override
    public Unit findById(Long id) {
        return null;
    }

    @Override
    public void save(Unit unit) {

    }

    @Override
    public List<Unit> findAll() {
        return List.of();
    }

    @Override
    public List<Unit> findByFloor(int floor) {
        return List.of();
    }

    @Override
    public Unit findByIdentification(String identification) {
        return null;
    }

    @Override
    public List<Unit> findByBlockId(Long blockId) {
        return List.of();
    }

    @Override
    public List<Unit> findByFloorAndBlockId(Integer floor, Integer blockId) {
        return List.of();
    }
}
