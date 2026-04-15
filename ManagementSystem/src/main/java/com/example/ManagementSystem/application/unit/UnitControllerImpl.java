package com.example.ManagementSystem.application.unit;

import com.example.ManagementSystem.application.unit.dto.ResidentRequestDTO;
import com.example.ManagementSystem.application.unit.dto.UnitDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.unit.Unit;
import com.example.ManagementSystem.domain.unit.UnitService;
import com.example.ManagementSystem.domain.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UnitControllerImpl implements UnitController{
    private final UnitService unitService;
    private final UserService userService;

    public UnitControllerImpl(UnitService unitService, UserService userService) {
        this.unitService = unitService;
        this.userService = userService;
    }


    @Override
    public ResponseEntity<List<UnitDTO>> findByResidentId(Long id) {
        return ResponseEntity.ok(unitService.findByResidentId(id).stream().map(UnitDTO::fromUnit).toList());
    }

    @Override
    public ResponseEntity<UnitDTO> findById(Long id) {
        return  ResponseEntity.ok(UnitDTO.fromUnit(unitService.findById(id)));
    }

    @Override
    public ResponseEntity<List<UnitDTO>> findAll() {
        return ResponseEntity.ok(unitService.findAll().stream().map(UnitDTO::fromUnit).toList());
    }

    @Override
    public ResponseEntity<List<UnitDTO>> findByFloor(int floor) {
        return ResponseEntity.ok(unitService.findByFloor(floor).stream().map(UnitDTO::fromUnit).toList());
    }

    @Override
    public ResponseEntity<UnitDTO> findByIdentification(String identification) {
        return ResponseEntity.ok(UnitDTO.fromUnit(unitService.findByIdentification(identification)));
    }

    @Override
    public ResponseEntity<List<UnitDTO>> findByBlockId(Long blockId) {
        return ResponseEntity.ok(unitService.findByBlockId(blockId).stream().map(UnitDTO::fromUnit).toList());
    }

    @Override
    public ResponseEntity<List<UnitDTO>> findByFloorAndBlockId(Integer floor, Long blockId) {
        return ResponseEntity.ok(unitService.findByFloorAndBlockId(floor, blockId).stream().map(UnitDTO::fromUnit).toList());
    }

    @Override
    public ResponseEntity<Void> save(UnitDTO unit) {
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Unit> populateUnit(ResidentRequestDTO request) {
        Unit unit = unitService.findByIdentification(request.unitIdentification());
        if( unit == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(unitService.populate(unit, request.username()));

    }

}
