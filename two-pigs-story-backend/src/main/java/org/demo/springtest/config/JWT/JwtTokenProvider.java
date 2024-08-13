//package org.demo.springtest.config.JWT;
//
//import io.jsonwebtoken.*;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtTokenProvider {
//
//    private String secretKey = "SECRET_KEY";
//    private long tokenValidityInMilliseconds = 1000 * 60 * 60 * 10; // 10 hours
//
//    public String generateToken(UserDetails userDetails) {
//        long now = System.currentTimeMillis();
//        Date validity = new Date(now + tokenValidityInMilliseconds);
//
//        return Jwts.builder()
//                .setSubject(userDetails.getUsername())
//                .setIssuedAt(new Date(now))
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS512, secretKey)
//                .compact();
//    }
//
//    public String getUsernameFromJWT(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
//    }
//
//    public Date getIssuedAtDateFromJWT(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getIssuedAt();
//    }
//
//    public Date getExpirationDateFromJWT(String token) {
//        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getExpiration();
//    }
//
//    public boolean validateToken(String authToken) {
//        try {
//            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
//            return true;
//        } catch (SignatureException e) {
//            return false;
//        }
//    }
//}
