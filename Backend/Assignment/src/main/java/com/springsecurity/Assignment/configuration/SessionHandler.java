package com.springsecurity.Assignment.configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import javax.crypto.SecretKey;
import java.util.Date;

public class SessionHandler {

    private SecretKey secretKey = MacProvider.generateKey();

    public String createSession(String user) {
        Claims claims = Jwts.claims().setSubject(user);
        claims.put("role", "MANAGER");
        Date date = new Date();
        Date expireAt = new Date(System.currentTimeMillis() + 160 * 60000);
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(expireAt)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
        return jwt;
    }

    public String validateToken(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (Exception e) {

        }
        return null;
    }
}
