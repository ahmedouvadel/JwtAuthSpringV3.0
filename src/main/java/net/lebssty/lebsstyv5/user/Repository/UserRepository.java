package net.lebssty.lebsstyv5.user.Repository;

import net.lebssty.lebsstyv5.user.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByEmail(String email);
}
