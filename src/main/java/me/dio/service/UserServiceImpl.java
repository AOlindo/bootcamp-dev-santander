package me.dio.service;

import java.util.NoSuchElementException;
import org.springframework.stereotype.Service;
import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
	}

	@Override
	public User create(User userToCreate) {
		if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
			throw new IllegalArgumentException("This Account number already exists");
			//este número de conta já existe
		}
		return userRepository.save(userToCreate);
	}

}
