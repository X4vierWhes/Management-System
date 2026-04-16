package com.example.ManagementSystem.domain.ticket;


import com.example.ManagementSystem.application.ticket.dto.TicketDTO;
import com.example.ManagementSystem.domain.ticket.attachments.TicketAttachment;
import com.example.ManagementSystem.domain.ticket.attachments.TicketAttachmentRepository;
import com.example.ManagementSystem.domain.ticket.comment.TicketComment;
import com.example.ManagementSystem.domain.ticket.comment.TicketCommentRepository;
import com.example.ManagementSystem.domain.ticket.status.TicketStatus;
import com.example.ManagementSystem.domain.ticket.status.TicketStatusRepository;
import com.example.ManagementSystem.domain.ticket.type.TicketType;
import com.example.ManagementSystem.domain.ticket.type.TicketTypeRepository;
import com.example.ManagementSystem.domain.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final TicketRepository ticketRepository;
    private final TicketCommentRepository ticketCommentRepository;
    private final TicketAttachmentRepository ticketAttachmentRepository;
    private final TicketStatusRepository ticketStatusRepository;
    private final TicketTypeRepository ticketTypeRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, TicketCommentRepository ticketCommentRepository, TicketAttachmentRepository ticketAttachmentRepository, TicketStatusRepository ticketStatusRepository, TicketTypeRepository ticketTypeRepository) {
        this.ticketRepository = ticketRepository;
        this.ticketCommentRepository = ticketCommentRepository;
        this.ticketAttachmentRepository = ticketAttachmentRepository;
        this.ticketStatusRepository = ticketStatusRepository;
        this.ticketTypeRepository = ticketTypeRepository;
    }

    @Override
    public Ticket createTicket(TicketDTO ticketDTO) {
        return null;
    }

    @Override
    public List<Ticket> findByCreator(User creator) {
        return ticketRepository.findByCreator(creator);
    }

    @Override
    public List<Ticket> findByAssignedUser(User assignedUser) {
        return ticketRepository.findByAssignedUser(assignedUser);
    }

    @Override
    public List<Ticket> findByStatus_Name(String statusName) {
        return ticketRepository.findByStatus_Name(statusName);
    }

    @Override
    public List<Ticket> findByUnit_Id(Long unitId) {
        return ticketRepository.findByUnit_Id(unitId);
    }

    @Override
    public TicketType findTypeByTitle(String title) {
        return ticketTypeRepository.findByTitle(title).orElse(null);
    }

    @Override
    public TicketStatus findStatusByIsDefaultTrue() {
        return ticketStatusRepository.findByIsDefaultTrue().orElse(null);
    }

    @Override
    public TicketStatus findStatusByIsFinalTrue() {
        return ticketStatusRepository.findByIsFinalTrue().orElse(null);
    }

    @Override
    public List<TicketComment> findByTicketIdOrderByCreatedAtAsc(Long ticketId) {
        return ticketCommentRepository.findByTicketIdOrderByCreatedAtAsc(ticketId);
    }

    @Override
    public TicketComment findCommentByTicketId(Long ticketId) {
        return ticketCommentRepository.findById(ticketId).orElse(null);
    }

    @Override
    public List<TicketAttachment> findAttachmentByTicketId(Long ticketId) {
        return ticketAttachmentRepository.findByTicketId(ticketId);
    }

    @Override
    public List<TicketAttachment> findAttachmentByTicketIdAndFileTypeContaining(Long ticketId, String type) {
        return ticketAttachmentRepository.findByTicketIdAndFileTypeContaining(ticketId, type);
    }
}
