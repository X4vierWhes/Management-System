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
    public List<Unit> findByResidentId(Long id) {
        return unitRepository.findByResidents_Id(id);
    }

    @Override
    public Unit findById(Long id) {
        return unitRepository.findById(id).orElseThrow(() -> new RuntimeException("Unit not found with id: " + id));
    }

    @Override
    public void save(Unit unit) {
        unitRepository.save(unit);
    }

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAll();
    }

    @Override
    public List<Unit> findByFloor(int floor) {
        return unitRepository.findByFloor(floor);
    }

    @Override
    public Unit findByIdentification(String identification) {
        return unitRepository.findByIdentification(identification).orElseThrow(() -> new RuntimeException("Unit not found with identification: " + identification));
    }

    @Override
    public List<Unit> findByBlockId(Long blockId) {
        return unitRepository.findByBlock_Id(blockId);
    }

    @Override
    public List<Unit> findByFloorAndBlockId(Integer floor, Long blockId) {
        return unitRepository.findByFloorAndBlock_Id(floor, blockId);
    }
}
