package net.lebssty.lebsstyv5.Auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

    private String user;
    //@JsonProperty("token")
    private String token;
    //@JsonProperty("refresh_token")
    private String refreshToken;
}