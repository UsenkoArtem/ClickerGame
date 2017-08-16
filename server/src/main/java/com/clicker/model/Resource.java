package com.clicker.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "resource_dictionary")

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Resource {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Override
    public String toString() {
        String inBuildingString = "";
        String outBuildingString = "";
        if (inBuilding == null) {
            inBuildingString = "nothing";
        } else {
            inBuildingString = inBuilding.getName();
        }
        if (outBuilding == null) {
            outBuildingString = "nothing";
        } else {
            outBuildingString = outBuilding.getName();
        }
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", inBuilding=" + inBuildingString +
                ", outBuilding=" + outBuildingString +
                '}';
    }

    @Column
    String name;

    @ManyToOne
    @JoinColumn(name = "in_building_fk")
    Building inBuilding;


    @ManyToOne
    @JoinColumn(name = "out_building_fk")
    Building outBuilding;

    public Resource(String name, Building inBuilding, Building outBuilding) {
        this.name = name;
        this.inBuilding = inBuilding;
        this.outBuilding = outBuilding;
    }

    public Resource() {
    }
}
