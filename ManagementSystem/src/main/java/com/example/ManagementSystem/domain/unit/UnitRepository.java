package com.example.ManagementSystem.domain.unit;

import com.example.ManagementSystem.application.user.dto.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
    List<Unit> findByResidents_Id(Long userId);

    List<Unit> findByFloor(int floor);

    Optional<Unit> findByIdentification(String identification);

    List<Unit> findByBlock_Id(Long blockId);

    List<Unit> findByFloorAndBlock_Id(int floor, Long blockId);

    @Modifying
    @Query(value = "DELETE FROM resident_unit WHERE unit_id = :unitId", nativeQuery = true)
    void removeAllResidentsFromUnit(@Param("unitId") Long unitId);
}