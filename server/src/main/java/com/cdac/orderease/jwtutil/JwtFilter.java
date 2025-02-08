package com.cdac.orderease.jwtutil;

import java.io.IOException;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cdac.orderease.exception.UserNotFoundException;
import com.cdac.orderease.serviceimpl.UserServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JwtUtils jwtUtils;
    
	@Autowired
	@Lazy
	private UserServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String requestPath = request.getRequestURI();

	    if (requestPath.startsWith("/auth")) {
	        filterChain.doFilter(request, response);
	        return;
	    }
	    
	    final String authHeader = request.getHeader("Authorization");
	    if (authHeader == null || !authHeader.startsWith("Bearer ")) {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);  
	        response.getWriter().write("Missing or invalid token");
	        return;
	    }
		
		String username = null;
		String token = null;
		
		if(authHeader!=null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			try {				
				username = jwtUtils.extractUsername(token);
			} catch (ExpiredJwtException | MalformedJwtException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid or expired token");
                return;
			}
		}
		
		if(username!=null && SecurityContextHolder.getContext().getAuthentication() == null) {
			try {
			UserDetails userDetails = userDetailsService.loginUserForSpringSecurity(username);
			
			if(jwtUtils.validateToken(token)) {
				Set<String> roles = jwtUtils.extractRoles(token);
				
				var authorities = roles.stream().map(role->new org.springframework.security.core.authority.SimpleGrantedAuthority(role))
                        .collect(Collectors.toList());
								
				 UsernamePasswordAuthenticationToken authentication =
                         new UsernamePasswordAuthenticationToken(userDetails, null, authorities);

                 authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                 SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}catch (UsernameNotFoundException | UserNotFoundException e) {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("User not found");
                return;
			}
		}
		filterChain.doFilter(request, response);
	}
}
