package net.lebssty.lebsstyv5.Entity;

import jakarta.persistence.*;
import lombok.Data;
import net.lebssty.lebsstyv5.Dto.OrderDto;
import net.lebssty.lebsstyv5.Enum.OrderStutus;
import net.lebssty.lebsstyv5.user.Entity.User;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createdAt;
    private String paymentMethod;
    @Enumerated(EnumType.STRING)
    private OrderStutus orderStatus;
    private Long totalAmount;
    private UUID trackingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @JoinColumn(name = "address_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Address address;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CartItems> cartItems;

    public OrderDto getDto() {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(id);
        orderDto.setCreatedAt(createdAt);
        orderDto.setPaymentMethod(paymentMethod);
        orderDto.setOrderStatus(String.valueOf(orderStatus));
        orderDto.setTotalAmount(totalAmount);
        orderDto.setTrackingId(trackingId);
        orderDto.setUserId(user.getId()); // Assuming User entity has an 'id' field
        orderDto.setAddressdto(address.getDto()); // Convert Address entity to AddressDto if not null
        orderDto.setCartItems(cartItems.stream().map(CartItems::getDto).collect(Collectors.toList())); // Convert CartItems to CartItemDto
        return orderDto;
    }
}
