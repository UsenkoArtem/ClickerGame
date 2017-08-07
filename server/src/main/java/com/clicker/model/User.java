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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String email;

    @Column
    private String login;

    @Column
    private String password;

    public User(User user) {
        this.email = user.email;
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.id = user.id;
        this.login = user.login;
        this.password = user.password;
    }
}
