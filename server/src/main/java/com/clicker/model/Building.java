package com.clicker.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "buildings_dictionary")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Building {
    @Override
    public String toString() {
        return "Building{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", basicCost=" + basicCost +
                ", basicLvlUpMultiplierCost=" + basicLvlUpMultiplierCost +
                ", basicProduction=" + basicProduction +
                ", basicConsume=" + basicConsume +
                ", basicLvlMultiplierProd=" + basicLvlMultiplierProd +
                ", basicQuality=" + basicQuality +
                ", inResource=" + inResource.toString() +
                ", outResource=" + outResource.toString() +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "basic_cost")
    Double basicCost;

    @Column(name = "b_lvl_up_m_cost")
    Double basicLvlUpMultiplierCost;

    @Column(name = "b_prod")
    Double basicProduction;

    @Column(name = "b_consume")
    Double basicConsume;

    @Column(name = "b_m_prod")
    Double basicLvlMultiplierProd;

    @Column(name = "b_quality")
    Double basicQuality;

    @OneToMany(mappedBy = "inBuilding", cascade = CascadeType.ALL)
    Set<Resource> inResource;

    @OneToMany(mappedBy = "outBuilding", cascade = CascadeType.ALL)
    Set<Resource> outResource;



}
