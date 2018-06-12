package org.dimatech.service;


import org.dimatech.model.User;
import org.dimatech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserService implements UserDetailsService {

	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}

	public User findByEmailAndPassword(String email,String password){
		return userRepository.findUserByEmailAndPassword(email,password);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	    return  userRepository.findByEmail(email);
    }
}