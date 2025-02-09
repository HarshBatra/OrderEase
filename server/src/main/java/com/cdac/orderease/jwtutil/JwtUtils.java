package com.cdac.orderease.jwtutil;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	@Value("${jwt.secretKey}")
	private String secretKey;
	
	@Value("${jwt.validity}")
	private long validity;
	
	public String generateToken(String username, String roles) {
		String prefixedRoles = "ROLE_"+roles;
		
		return Jwts.builder().setSubject(username)
				.claim("roles", prefixedRoles)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + validity))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
	}
	
	public String extractUsername(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
	}
	
	public Set<String> extractRoles(String token){
		Claims claim = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		Object rolesClaim = claim.get("roles");
		
		if (rolesClaim instanceof String) {  
	        return Set.of((String) rolesClaim);
	    } else {
			return Set.of(rolesClaim.toString());
		}
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
}




