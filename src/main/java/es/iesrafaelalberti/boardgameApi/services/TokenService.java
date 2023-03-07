package es.iesrafaelalberti.boardgameApi.services;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    private final JwtEncoder encoder;

    public TokenService(JwtEncoder encoder){this.encoder = encoder}

    public String generateToken(Authentication)

}
