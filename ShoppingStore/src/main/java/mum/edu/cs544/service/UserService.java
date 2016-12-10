package mum.edu.cs544.service;

import java.util.List;

//import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import mum.edu.cs544.model.User;

public interface UserService {
	
	public void addUser(User user);
	public void deleteUser(int id);
	public List<User> getAll();
	public User getUser(String username);

	

}
