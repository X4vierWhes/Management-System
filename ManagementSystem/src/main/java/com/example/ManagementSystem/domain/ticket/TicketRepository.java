package com.example.ManagementSystem.domain.ticket;

import com.example.ManagementSystem.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByCreator(User creator);

    List<Ticket> findByAssignedUser(User assignedUser);

    List<Ticket> findByStatus_Name(String statusName);

    List<Ticket> findByUnit_Id(Long unitId);
}