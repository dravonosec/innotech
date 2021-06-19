package com.innotech.education.service;

import com.innotech.education.details.MyUserDetails;
import com.innotech.education.entity.Character;
import com.innotech.education.entity.User;
import com.innotech.education.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		
		return new MyUserDetails(user);
	}

	public User getUser(String username){return userRepository.getUserByUsername(username);}


}
