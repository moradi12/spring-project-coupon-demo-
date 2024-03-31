package Openconnection.example.demo.utills;

import Openconnection.example.demo.beans.Credentials;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@NoArgsConstructor
public class JWT {
    private final String signatureAlgorithm = SignatureAlgorithm.HS256.getJcaName();
    private final String secretKey = "Tamir+Moradi+Try+mustWork+workkkkk+GGGGGGGGG+gggggggg+ggggg+ggggg+gggkk";
    private final Key decodedSecretKey = new SecretKeySpec(
            Base64.getDecoder().decode(secretKey), SignatureAlgorithm.HS256.getJcaName()
    );

    //token
    public String generateToken(Credentials credentials) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userEmail", credentials.getUserEmail());
        claims.put("id", credentials.getId());
        claims.put("userType", "company " + credentials.getUserType());

        return "Bearer " + createToken(claims, credentials.getUserName());
    }

    public String createToken(Map<String, Object> claims, String userName) {
        Instant now = Instant.now();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(now.plus(30, ChronoUnit.MINUTES)))
                .signWith(decodedSecretKey)
                .compact();
    }


    public Claims extractAllClaims(String token) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(decodedSecretKey).build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public String extractSignature(String token) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(decodedSecretKey).build();
        return jwtParser.parseClaimsJws(token).getSignature();
    }

    public String extractSubject(String token) {
        return extractAllClaims(token.replace("Bearer ", "")).getSubject();
    }

    public String checkUser(String token) throws JwtException {
        Claims claims = extractAllClaims(token.replace("Bearer ", ""));
        Credentials credentials = new Credentials();
        credentials.setUserName(claims.getSubject());
        credentials.setUserEmail((String) claims.get("userEmail"));
        credentials.setId((int) claims.get("id"));
        return generateToken(credentials);
    }
}
