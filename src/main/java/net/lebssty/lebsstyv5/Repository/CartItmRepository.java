package net.lebssty.lebsstyv5.Repository;

import net.lebssty.lebsstyv5.Entity.CartItems;
import net.lebssty.lebsstyv5.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItmRepository extends JpaRepository<CartItems, Long> {
}
