package com.clicker.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column
    String name;
}
