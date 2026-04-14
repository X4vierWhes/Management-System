package com.example.ManagementSystem.domain.user;

import com.example.ManagementSystem.application.auth.dto.SignUpDTO;
import com.example.ManagementSystem.application.user.dto.UserDTO;
import com.example.ManagementSystem.domain.unit.Unit;
import com.example.ManagementSystem.domain.utils.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Profile profile;

    @CreatedDate
    private LocalDateTime createdAt;

    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(
            name = "resident_unit",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "unit_id")
    )
    private List<Unit> units;

    public void updateUser(SignUpDTO dto) {
        setEmail(dto.email());
        setUsername(dto.username());
        //setPassword(passwordEncoder.encode(dto.passwd()));
    }

    public UserDTO toDTO() {
        return new UserDTO(this.getUsername(), this.getEmail(),this.getProfile().name(),this.getIsActive(), this.getCreatedAt());
    }
}
