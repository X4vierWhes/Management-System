package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name= "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @CreatedDate
    private LocalDateTime createdAt;

    private Boolean isActive = true;

    public void updateUser(SignUpDTO dto) {
        setEmail(dto.email());
        setUsername(dto.username());
        //setPassword(passwordEncoder.encode(dto.passwd()));
    }

    public UserDTO toDTO() {
        return new UserDTO(this.getUsername(), this.getEmail(), this.getCreatedAt());
    }
}
