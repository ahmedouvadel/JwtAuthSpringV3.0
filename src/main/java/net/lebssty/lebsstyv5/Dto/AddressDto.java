package net.lebssty.lebsstyv5.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private Long id;
    private String name;
    private String mobile;
    private String house;
    private String landmark;
    private String city;
    private String country;
    private String postalCode;
}
