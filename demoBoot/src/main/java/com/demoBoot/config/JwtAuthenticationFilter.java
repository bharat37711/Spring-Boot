package com.demoBoot.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demoBoot.service.UserPasswordService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserPasswordService userService;
	@Autowired
	private JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String tokenHeader = request.getHeader("Authorization");

		String username = null;
		String jwtToken = null;

		if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {

			jwtToken = tokenHeader.substring(7);
			try {

				username = jwtUtil.extractUsername(jwtToken);

			} catch (Exception e) {
				
				e.printStackTrace();
			}

			UserDetails userDetails = this.userService.loadUserByUsername(username);

			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

				UsernamePasswordAuthenticationToken obj = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());

				obj.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(obj);

			} else {
				System.out.println("user not validate");
			}

		}

		filterChain.doFilter(request, response);
	}

}
