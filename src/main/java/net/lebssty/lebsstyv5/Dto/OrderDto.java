package net.lebssty.lebsstyv5.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private Date createdAt;
    private String paymentMethod;
    private String orderStatus;
    private Long totalAmount;
    private UUID trackingId;
    private Long userId;
    private AddressDto addressdto; // Modified to include AddressDto instead of List<AddressDto>
    private List<CartItemDto> cartItems;
}
