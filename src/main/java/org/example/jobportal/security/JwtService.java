package org.example.jobportal.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {
    @Value("${jwt.token}")
    private String token;
    @Value("${expire}")
    private Long expire;
    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(token.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(String email) {
        return  Jwts.builder().subject(email).signWith(getSecretKey()).issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + expire)).compact();
    }
    public String extractEmail(String token) {
        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload().getSubject();
    }
    public Date extractExpiration(String token) {
        return Jwts.parser().verifyWith( getSecretKey()).build().parseSignedClaims(token).getPayload().getExpiration();
    }
    public boolean validateToken(String token, String email) {
        return  extractEmail(token).equals(email) && extractExpiration(token).after(new Date());
    }
}
