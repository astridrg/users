package com.app.user.config;

import com.app.user.domain.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private static final String NAME = "name";
    private static final String EMAIL = "email";
    private static final String SECRET = "pfksncgFAWtnPJ2AFlL8WXn043cnufe2r63pvzgbsir0ii6h";
    private static final Integer EXPIRES = 7;

    public String createToken(User data) {
        Map name = Collections.singletonMap(NAME, data.getName());
        Map email = Collections.singletonMap(EMAIL, data.getEmail());
        return Jwts.builder()
                .issuer(data.getEmail())
                .expiration(expire(EXPIRES))
                .claims(name)
                .claims(email)
                .signWith(new SecretKeySpec(Decoders.BASE64.decode(SECRET),
                        SignatureAlgorithm.HS256.getJcaName())).compact();
    }

    public Boolean validateToken(String token) {
        try {
            getToken(token);
        } catch (JwtException e) {
            return false;
        }

        return true;
    }

    public String getEmail(String token) {
        Jws<Claims> claimsJws = getToken(token);
        return claimsJws.getPayload().get(EMAIL).toString();
    }

    private Jws<Claims> getToken(String token) throws JwtException {
        Key hmacKey = new SecretKeySpec(Decoders.BASE64.decode(SECRET),
                SignatureAlgorithm.HS256.getJcaName());

        return Jwts.parser()
                .setSigningKey(hmacKey)
                .build()
                .parseClaimsJws(token);
    }

    private Date expire(int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }
}
