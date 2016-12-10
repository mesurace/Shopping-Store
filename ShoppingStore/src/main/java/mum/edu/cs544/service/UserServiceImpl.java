package mum.edu.cs544.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.edu.cs544.model.User;
import mum.edu.cs544.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteUserById(id);

	}
	
	@Override
	@Transactional
	public User getUser(String userName) {
		return userRepository.findUsersByUserName(userName).get(0);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	
}
