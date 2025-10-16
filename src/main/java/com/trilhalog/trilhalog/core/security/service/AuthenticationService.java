package com.trilhalog.trilhalog.core.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.trilhalog.trilhalog.core.security.userDetails.AuthenticatedUser;
import com.trilhalog.trilhalog.core.usuario.repository.UsuarioRepository;
@Service
public class AuthenticationService implements UserDetailsService{
	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repository.findByEmail(username)
				.map(AuthenticatedUser::new)
				.orElseThrow(() -> new UsernameNotFoundException("credenciais invalidas"+username));
	}

}
