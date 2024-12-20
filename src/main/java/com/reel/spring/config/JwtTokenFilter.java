/**
package com.reel.spring.config;

import java.io.IOException;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenFilter extends OncePerRequestFilter {
	private JwtTokenProvider tokenProvider;
	
	public JwtTokenFilter(JwtTokenProvider tokenProvider) {
		this.tokenProvider = tokenProvider;
	}

	@Override
	public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if (token != null) {
			try {
				Claims claims = tokenProvider.getClaimsFromToken(token);
				if (!claims.getExpiration().before(new Date())) {
					Authentication authentication = tokenProvider.getAuthentication(claims.getSubject());
					if (authentication.isAuthenticated()) {
						SecurityContextHolder.getContext().setAuthentication(authentication);
					}
				}
			} catch (RuntimeException e) {
				SecurityContextHolder.clearContext();
				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().println(e.getMessage());
				return;
			}
		}
		filterChain.doFilter(request, response);
	}
	
}
*/