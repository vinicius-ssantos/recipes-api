package com.viniciussantos.config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtProvider {
    private SecretKey key = Keys.hmacShaKeyFor(JwtConstant.JWT_SECRET.getBytes());
    public String generateToken(Authentication authentication) {
            String jwt= Jwts.builder()
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 864000000))
                    .claim("email",authentication.getName())
                    .signWith(key).compact();
            return jwt;
    }

    public String getEmailFromToken(String jwt) {
       jwt = jwt.substring(7);
        Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
        String email = String.valueOf(claims.get("email"));
        return email;
    }

}
