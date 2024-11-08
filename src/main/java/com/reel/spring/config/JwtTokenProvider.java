/**
package com.reel.spring.config;

import java.io.Serializable;
import java.util.Base64;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.reel.spring.model.Role;
import com.reel.spring.service.UserService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;

@Component
public class JwtTokenProvider implements Serializable {

	private static long MINUTE = 60000;
	private static final long serialVersionUID = 7955971572817852012L;
	
	public static final long JWT_TOKEN_VALIDITY = 30 * MINUTE;
	
	@Value("${jwt.secret-key}")
	private String secretKey;
	
	
	@PostConstruct
	protected void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
	}
	
	public String createToken(String username, Collection<Role> roles) {
		System.out.println(username);
		System.out.println(secretKey);
		Claims claims = Jwts.claims().setSubject(username);
		claims.put("auth", roles);
		
		Date now = new Date();
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + JWT_TOKEN_VALIDITY))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	@Autowired
	private UserService userService;
	
	public Authentication getAuthentication(String username) {
		UserDetails userDetails = userService.loadUserByUsername(username);
		return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
	}
	
	public Claims getClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
}
*/