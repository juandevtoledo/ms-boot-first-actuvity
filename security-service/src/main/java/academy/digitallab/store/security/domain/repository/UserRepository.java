package academy.digitallab.store.security.domain.repository;

import academy.digitallab.store.security.domain.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, String> {
}
