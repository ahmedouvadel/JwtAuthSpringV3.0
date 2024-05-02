package net.lebssty.lebsstyv5.Repository;

import net.lebssty.lebsstyv5.Entity.Address;
import net.lebssty.lebsstyv5.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
