package mum.edu.cs544.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import mum.edu.cs544.model.User;

public interface UserRepository extends JpaRepository<User, String> {


	List<User> findAll();
	User findOne(String userName);
	
	@Query("select u from User u join u.userCredential c where c.userName = :username")
	List<User> findUsersByUserName(@Param("username") String username);
	
	User save(User user);
	Integer deleteUserById(int id);
}
