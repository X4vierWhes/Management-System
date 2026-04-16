package com.example.ManagementSystem.application.ticket.dto;

import com.example.ManagementSystem.domain.ticket.Ticket;
import com.example.ManagementSystem.domain.ticket.attachments.TicketAttachment;

import java.time.LocalDateTime;
import java.util.List;

public record TicketDTO(
        Long id,
        String title,
        String description,
        String typeTitle,
        String statusName,
        String unitIdentification,
        String creatorUserName,
        String assignedUserName,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime finishedAt,
        List<String> attachmentUrls){

    public TicketDTO FromTicket(Ticket ticket) {
        return new TicketDTO(
                ticket.getId(),
                ticket.getTitle(),
                ticket.getDescription(),
                ticket.getType() != null ? ticket.getType().getTitle() : null,
                ticket.getStatus() != null ? ticket.getStatus().getName() : null,
                ticket.getUnit() != null ? ticket.getUnit().getIdentification() : null,
                ticket.getCreator() != null ? ticket.getCreator().getUsername() : null,
                ticket.getAssignedUser() != null ? ticket.getAssignedUser().getUsername() : null,
                ticket.getCreatedAt(),
                ticket.getUpdatedAt(),
                ticket.getFinishedAt(),
                ticket.getAttachments().stream().map(TicketAttachment::getFileUrl).toList()
        );
    }
}