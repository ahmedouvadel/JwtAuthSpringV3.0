package net.lebssty.lebsstyv5.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private Long id;
    private String name;
    private Long price;
    private Long quantity;
    private byte[] bytes;

    private MultipartFile img;
}
