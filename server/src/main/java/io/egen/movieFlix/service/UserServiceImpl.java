package io.egen.movieFlix.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.movieFlix.entity.User;
import io.egen.movieFlix.exception.UserAlreadyExistsException;
import io.egen.movieFlix.exception.UserNotFoundException;
import io.egen.movieFlix.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findOne(String id) {
		User existingUser = userRepository.findOne(id);
		if (existingUser == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return existingUser;
	}

	@Override
	@Transactional
	public User create(User user) {
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			throw new UserAlreadyExistsException("Email is already in use: " + user.getEmail());
		}
		return userRepository.create(user);
	}

	@Override
	@Transactional
	public User update(String id, User user) {
		User existingUser = userRepository.findOne(id);
		if (existingUser == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		return userRepository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existingUser = userRepository.findOne(id);
		if (existingUser == null) {
			throw new UserNotFoundException("User with id:" + id + " not found");
		}
		userRepository.delete(existingUser);
	}

}
