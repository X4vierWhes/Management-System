package com.example.ManagementSystem.domain.ticket;

import com.example.ManagementSystem.application.ticket.dto.TicketDTO;
import com.example.ManagementSystem.domain.ticket.attachments.TicketAttachment;
import com.example.ManagementSystem.domain.ticket.comment.TicketComment;
import com.example.ManagementSystem.domain.ticket.status.TicketStatus;
import com.example.ManagementSystem.domain.ticket.type.TicketType;
import com.example.ManagementSystem.domain.user.User;
import java.util.List;


public interface TicketService {
    Ticket createTicket(TicketDTO ticketDTO);

    List<Ticket> findByCreator(User creator);

    List<Ticket> findByAssignedUser(User assignedUser);

    List<Ticket> findByStatus_Name(String statusName);

    List<Ticket> findByUnit_Id(Long unitId);

    TicketType findTypeByTitle(String title);

    TicketStatus findStatusByIsDefaultTrue();

    TicketStatus findStatusByIsFinalTrue();

    List<TicketComment> findByTicketIdOrderByCreatedAtAsc(Long ticketId);

    TicketComment findCommentByTicketId(Long ticketId);

    List<TicketAttachment> findAttachmentByTicketId(Long ticketId);

    List<TicketAttachment> findAttachmentByTicketIdAndFileTypeContaining(Long ticketId, String type);
}
