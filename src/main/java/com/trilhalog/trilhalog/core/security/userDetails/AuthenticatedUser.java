package com.trilhalog.trilhalog.core.security.userDetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.trilhalog.trilhalog.core.usuario.entity.Usuario;

public class AuthenticatedUser implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Usuario usuario;
	
	public AuthenticatedUser(Usuario usuario) {
		super();
		this.usuario = usuario;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return AuthorityUtils.NO_AUTHORITIES;
	}

	@Override
	public String getPassword() {
		return usuario.getSenha();

	}

	@Override
	public String getUsername() {
		return usuario.getEmail();
	}

}
