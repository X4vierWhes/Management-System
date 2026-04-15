package com.example.ManagementSystem.domain.ticket.status;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketStatusRepository extends JpaRepository<TicketStatus, Long> {
    Optional<TicketStatus> findByIsDefaultTrue();
    Optional<TicketStatus> findByIsFinalTrue();
}