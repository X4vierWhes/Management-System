package com.example.ManagementSystem.application.unit.dto;

import com.example.ManagementSystem.domain.unit.Unit;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import java.util.List;
import java.util.stream.Collectors;

public record UnitDTO(
        Long id,
        Long blockId,
        String blockIdentification,
        int floor,
        String unitIdentification,
        boolean isEmpty,
        List<UserDTO> residents
) {

    public static UnitDTO fromUnit(Unit unit) {
        return new UnitDTO(
                unit.getId(),
                unit.getBlock() != null ? unit.getBlock().getId() : null,
                unit.getBlock() != null ? unit.getBlock().getIdentification() : null,
                unit.getFloor(),
                unit.getIdentification(),
                unit.isEmpty(),
                unit.getResidents() != null ?
                        unit.getResidents().stream()
                        .map(UserDTO::fromUser)
                        .collect(Collectors.toList()) : List.of()
        );
    }
}