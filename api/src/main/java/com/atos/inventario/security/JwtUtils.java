package com.atos.inventario.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.atos.inventario.model.Empregado;
import io.jsonwebtoken.*;

@Component
public class JwtUtils {

	private String jwtSecret="Atos";

	private int jwtExpirationMs = 5 * 60 * 60;

	public String generateJwtToken(Authentication authentication) {

		Empregado userPrincipal = (Empregado) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
				.signWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			//console.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			//logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			//logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			//logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			//logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
}
