package fr.mbds.estia.lecoincoin_estia_25_26.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String pseudo;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String mail;
    @Column(unique = true)
    private String phone;
    private Date dob;
}
