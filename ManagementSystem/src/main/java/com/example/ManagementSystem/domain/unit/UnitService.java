package com.example.ManagementSystem.domain.unit;

import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.user.User;

import java.util.List;

public interface UnitService {
    List<Unit> findByResidentId(Long id);

    Unit findById(Long id);

    void save(Unit unit);

    List<Unit> findAll();

    List<Unit> findByFloor(int floor);

    Unit findByIdentification(String identification);

    List<Unit> findByBlockId(Long blockId);

    List<Unit> findByFloorAndBlockId(Integer floor, Long blockId);

    Unit populate(Unit unit, String username);
}
