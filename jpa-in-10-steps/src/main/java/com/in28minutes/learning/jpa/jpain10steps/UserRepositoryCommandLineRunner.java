package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jill", "Admin");
		// i.l.j.j.UserDaoServiceCommandLineRunner : New User is CreatedUser [id=1,
		// name=Jack, role=Admin]
		// saved successfully in database
		userRepository.save(user);
		Optional<User> userWithIdOne=userRepository.findById(1L);
		
		log.info("New User is Created with id " + userWithIdOne);
		List<User> users=userRepository.findAll();
		log.info("All User" + users);
	}

}
