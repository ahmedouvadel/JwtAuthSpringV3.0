package net.lebssty.lebsstyv5.Repository;

import net.lebssty.lebsstyv5.Entity.Category;
import net.lebssty.lebsstyv5.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Override
    Optional<Order> findById(Long userId);

}
