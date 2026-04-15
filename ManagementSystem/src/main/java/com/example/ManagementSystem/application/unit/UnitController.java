package com.example.ManagementSystem.application.unit;

import com.example.ManagementSystem.application.unit.dto.ResidentRequestDTO;
import com.example.ManagementSystem.application.unit.dto.UnitDTO;
import com.example.ManagementSystem.domain.unit.Unit;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/units")
public interface UnitController {

    @GetMapping
    ResponseEntity<List<UnitDTO>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<UnitDTO> findById(@PathVariable Long id);

    @GetMapping("/resident/{id}")
    ResponseEntity<List<UnitDTO>> findByResidentId(@PathVariable Long id);

    @GetMapping("/floor/{floor}")
    ResponseEntity<List<UnitDTO>> findByFloor(@PathVariable int floor);

    @GetMapping("/identification/{identification}")
    ResponseEntity<UnitDTO> findByIdentification(@PathVariable String identification);

    @GetMapping("/block/{blockId}")
    ResponseEntity<List<UnitDTO>> findByBlockId(@PathVariable Long blockId);

    @GetMapping("/filter")
    ResponseEntity<List<UnitDTO>> findByFloorAndBlockId(
            @RequestParam Integer floor,
            @RequestParam Long blockId
    );

    @PostMapping
    ResponseEntity<Void> save(@RequestBody @Valid UnitDTO unit);

    @PostMapping("/resident")
    ResponseEntity<Unit> populateUnit(@RequestBody @Valid ResidentRequestDTO request);



}