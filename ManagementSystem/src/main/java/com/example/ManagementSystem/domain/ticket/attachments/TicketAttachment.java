package com.example.ManagementSystem.domain.ticket.attachments;

import com.example.ManagementSystem.domain.ticket.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ticket_attachments")
public class TicketAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    private String fileName;
    private String fileUrl;
    private String fileType;

    @org.hibernate.annotations.CreationTimestamp
    private java.time.LocalDateTime createdAt;
}