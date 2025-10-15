package fr.mbds.estia.lecoincoin_estia_25_26.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class UserDto {
    private Long id;
    private String pseudo;
    private String firstName;
    private String lastName;
    private String mail;
    private String phone;
    private Date dob;
}
