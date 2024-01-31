package com.app.user.config;

import com.app.user.domain.model.User;
import com.app.user.libs.JwtToken;
import com.app.user.repository.SaveUserInDataBase;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.apache.logging.log4j.util.Strings.isEmpty;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtToken jwtToken;
    private final SaveUserInDataBase userRepo;

    public JwtTokenFilter(JwtToken jwtToken,
                          SaveUserInDataBase userRepo) {
        this.jwtToken = jwtToken;
        this.userRepo = userRepo;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (isEmpty(header) || !header.startsWith("Bearer ")) {
            chain.doFilter(request, response);
            return;
        }

        final String token = header.split(" ")[1].trim();
        if (!jwtToken.validateToken(token)) {
            chain.doFilter(request, response);
            return;
        }

        String email = jwtToken.getEmail(token);
        User userDetails;
        if (email.equals("admin@admin.com")) {
            userDetails= new User();
        }else {
             userDetails = userRepo
                    .findUserForEmail(email);
        }

        UsernamePasswordAuthenticationToken
                authentication = new UsernamePasswordAuthenticationToken(
                userDetails, null,
                List.of()
        );

        authentication.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

}
