package fr.mbds.estia.lecoincoin_estia_25_26;

import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import fr.mbds.estia.lecoincoin_estia_25_26.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LecoincoinEstia2526Application {

    public static void main(String[] args) {
        SpringApplication.run(LecoincoinEstia2526Application.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository) {
        return args -> {
            User user = User.builder()
                    .firstName("John")
                    .lastName("Doe")
                    .mail("john.doe@estia.fr")
                    .phone("0606060606")
                    .pseudo("johndoe")
                    .dob(new java.util.Date())
                    .build();
            userRepository.save(user);
        };
    }
}
