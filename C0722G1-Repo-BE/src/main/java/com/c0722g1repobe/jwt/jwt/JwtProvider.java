package com.c0722g1repobe.jwt.jwt;

import com.c0722g1repobe.jwt.userprincal.AccountPrinciple;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String jwtSecret = "letahaphuong@gmail.com";
    private int jwtExpiration = 86400;// 60 * 60 * 24

    public String createToken(Authentication authentication) {
        AccountPrinciple accountPrinciple = (AccountPrinciple) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(accountPrinciple.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration * 1000))
                .signWith(SignatureAlgorithm.HS384, jwtSecret)
                .compact();
    }

    public boolean validateToken(String token) { // kiểm tra còn sống hay không
        try {
            if (Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().equals("letahaphuong@gmail.com")) {
                return true;
            }
        } catch (UnsupportedJwtException e) {
            logger.error("Unsupported JWT token -> Message: {}", e);
        } catch (MalformedJwtException e) {
            logger.error("The token invalid format -> Message: {}", e);

        } catch (SignatureException e) {
            logger.error("Invalid JWT Signature -> Message: {}", e);

        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty -> Message: {}", e);
        } catch (ExpiredJwtException e) {
            logger.error("Expired JWT token -> Message: {thời gian sống}", e);
        }
        return false;
    }

    public String getUserNameFromToken(String token) {
        String username = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
        return username;
    }
}
