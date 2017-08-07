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
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUserRole;

    @Column
    private String userLogin;
    @Column
    private String role;
}
