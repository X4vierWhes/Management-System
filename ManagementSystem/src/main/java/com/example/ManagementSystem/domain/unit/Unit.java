package com.example.ManagementSystem.domain.unit;

import com.example.ManagementSystem.domain.block.Block;
import com.example.ManagementSystem.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "units")
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "block_id", nullable = false)
    private Block block;

    @ManyToMany(mappedBy = "units")
    private List<User> residents;

    @Column(nullable = false)
    private int floor;

    @Column(nullable = false)
    private String identification;

    private boolean isEmpty;
}
