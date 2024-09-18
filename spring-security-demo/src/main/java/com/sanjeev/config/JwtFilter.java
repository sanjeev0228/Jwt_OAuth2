package com.sanjeev.config;

import com.sanjeev.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsByNameServiceWrapper;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
       String jwtToken = "";
       String username = null;
       if (authHeader != null && authHeader.startsWith("Bearer ")) {
           jwtToken = authHeader.substring(7);
           username = jwtToken.split(" ")[0];

       }

       if (jwtToken != null && username != null) {
           UserDetails  userDetails =context.getBean(MyUserDetailsService ).loadUserByName(UserDetailsByNameServiceWrapper);



       }


    }
}
