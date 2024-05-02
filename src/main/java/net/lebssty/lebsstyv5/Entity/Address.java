package net.lebssty.lebsstyv5.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.lebssty.lebsstyv5.Dto.AddressDto;
import net.lebssty.lebsstyv5.user.Entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String house;
    private String landmark;
    private String city;
    private String country;
    private String postalCode;

    @ManyToOne
    private User user;

    public AddressDto getDto() {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(id);
        addressDto.setName(name);
        addressDto.setMobile(mobile);
        addressDto.setHouse(house);
        addressDto.setLandmark(landmark);
        addressDto.setCity(city);
        addressDto.setCountry(country);
        addressDto.setPostalCode(postalCode);
        return addressDto;
    }
}

