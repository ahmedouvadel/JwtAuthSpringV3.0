package net.lebssty.lebsstyv5.Auth;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;

import java.io.IOException;

public interface AuthenticationService {

    public AuthenticationResponse register(RegisterRequest request);
    public AuthenticationResponse authenticate(AuthenticationRequest request, HttpServletResponse response) throws IOException, JSONException;
    public void refreshToken( HttpServletRequest request, HttpServletResponse response) throws IOException;

}
