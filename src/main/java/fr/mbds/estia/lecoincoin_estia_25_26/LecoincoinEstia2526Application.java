package fr.mbds.estia.lecoincoin_estia_25_26;

import fr.mbds.estia.lecoincoin_estia_25_26.model.GrantedAuthorityImpl;
import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import fr.mbds.estia.lecoincoin_estia_25_26.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LecoincoinEstia2526Application {

    public static void main(String[] args) {
        SpringApplication.run(LecoincoinEstia2526Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user = User.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .mail("john.doe@estia.fr")
                    .phone("0606060606")
                    .pseudo("johndoe")
                    .dob(new java.util.Date())
                    .username("test")
                    .password(passwordEncoder.encode("test"))
                    .grantedAuthorities(
                            java.util.List.of(
                                    GrantedAuthorityImpl.builder().authority("ROLE_ADMIN").build()
                            )
                    )
                    .build();
            userRepository.save(user);
        };
    }
}
