package net.lebssty.lebsstyv5.Entity;

import jakarta.persistence.*;
import lombok.Data;
import net.lebssty.lebsstyv5.Dto.CartItemDto;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long price;
    private Long quantity;

    @Lob
    private byte[] img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public CartItemDto getDto() {
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(id);
        cartItemDto.setName(name);
        cartItemDto.setPrice(price);
        cartItemDto.setQuantity(quantity);
        cartItemDto.setBytes(img);
        // Set MultipartFile to null
        //cartItemDto.setImg(null);
        return cartItemDto;
    }
}
