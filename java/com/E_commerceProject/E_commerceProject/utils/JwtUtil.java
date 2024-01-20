package com.E_commerceProject.E_commerceProject.utils;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import javax.xml.crypto.Data;
import java.security.Key;
import java.security.Signature;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

@Component
public class JwtUtil {
    public static final String SECRET = "413F4428472B4B6250655368566D5970337336763979244226452948404D6351";
    public String generateToken(String userName)
    {
        Map<String, Object> claims =new HashMap<>();
        return createToken(claims, userName);

    }
    private String createToken(Map<String,Object> claims, String userName){
     return Jwts.builder()
             .setClaims(claims)
             .setSubject(username)
             .setIssuedAt(new Data(System.currentTimeMillis()))
             .setExpiration(new Data(System.currentTimeMillis()+10000*60*30))
             signWith(getSignkey(), SignatureAlgorithm.HS256).compact();
    }
    private Key getSignkey()
    {
        byte[] keybytes=Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keybytes);
    }
    public String extractUsername(String token){
        return extractClaim(token,Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T>claimsResolver){
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder().setSigninKey(getSignkey()).build().parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Data());
    }
     public Date extractExpiration(String token){
        return extractClaim(token,Claims::getExpiration);
     }
     public Boolean validateToken(String token,UserDetails userDetails){
        final String username =extractUsername(token);
        return (username.equals(userDetails.getusername())&& !isTokenExpired(token));
     }
}
