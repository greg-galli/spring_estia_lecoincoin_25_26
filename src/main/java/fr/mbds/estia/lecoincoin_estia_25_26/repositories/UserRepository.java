package fr.mbds.estia.lecoincoin_estia_25_26.repositories;

import fr.mbds.estia.lecoincoin_estia_25_26.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
