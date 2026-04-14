package com.example.ManagementSystem.domain.block;

import com.example.ManagementSystem.domain.unit.Unit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identification;

    @Column(name = "amt_floors", nullable = false)
    private int amtFloors;

    @Column(name = "apt_per_floor", nullable = false)
    private int aptPerFloor;

    @OneToMany(mappedBy = "block", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Unit> units = new ArrayList<>();

    public void generateUnits(){
        for (int floor = 1; floor <= amtFloors; floor++) {
            for (int apt = 1; apt <= aptPerFloor; apt++) {
                Unit unit = new Unit();
                unit.setFloor(floor);
                unit.setBlock(this);
                unit.setEmpty(true);
                String unitId = String.format("%s - %d%02d", this.identification, floor, apt);
                unit.setIdentification(unitId);
                units.add(unit);
            }
        }
    }

}
