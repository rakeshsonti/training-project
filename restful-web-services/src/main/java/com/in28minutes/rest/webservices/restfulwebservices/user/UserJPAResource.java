package com.in28minutes.rest.webservices.restfulwebservices.user;
//import java.net.URI;
import java.util.List;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {
	@Autowired
	private UserDaoService service;
	@Autowired
	private UserRepository userRepository;
	// retrieve all user
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUser() {
		return userRepository.findAll();
	}

	// retrieve one user
//	@GetMapping("/users/{id}")
//	public EntityModel<User> retieveOne(@PathVariable int id) {
//		User user = service.findOne(id);
//		if (user == null) {
//			throw new UserNotFoundException("id-" + id);
//		}
//		
//		//"all-users", SERVER_PATH+"/users
//		//HATEOAS
//		EntityModel<User> resource = EntityModel.of(user);
//		WebMvcLinkBuilder linkTo = 
//				linkTo(methodOn(this.getClass()).retrieveAllUser());
//		
//		resource.add(linkTo.withRel("all-users"));
//		
//		//HATEOAS
//		
//		return resource;
//	}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteOne(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-" + id);
		}
	
	}

	// create -details of user
//	@PostMapping("/users")
//	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
//		User savedUser = service.save(user);
//		// output- created & return the created URI
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.path("/{id}").buildAndExpand(savedUser.getId())
//				.toUri();
//		return ResponseEntity.created(location).build();
//	}

}
