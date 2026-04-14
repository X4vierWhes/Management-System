package com.example.ManagementSystem.domain.unit;

import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {

    List<Unit> findByResidents(User resident);

    List<Unit> findByFloor(int floor);

    Optional<Unit> findByIdentification(String identification);

    List<Unit> findByBlock_Id(Long blockId);

    List<Unit> findByFloorAndBlock_Id(int floor, Long blockId);

}