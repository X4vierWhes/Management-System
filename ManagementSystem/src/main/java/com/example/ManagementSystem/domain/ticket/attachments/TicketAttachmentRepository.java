package com.example.ManagementSystem.domain.ticket.attachments;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketAttachmentRepository extends JpaRepository<TicketAttachment, Long> {
    List<TicketAttachment> findByTicketId(Long ticketId);

    List<TicketAttachment> findByTicketIdAndFileTypeContaining(Long ticketId, String type);
}