package com.mt.springmongo;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller which is responsible for retrieving {@link User}s.
 *
 * @author Mithun
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/users")
public class UserResource {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserResource.class);

    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
    	List<User> users = (List<User>) userRepository.findAll();
    	logger.info("Get Users Total Users: {}", users.size());
        return users;
    }

    @GetMapping(value = "/{id}", produces = "application/JSON")
    public Optional<User> findById(@PathVariable("id") String userID) {
    	logger.info("Get User By Id : {}", userID);
        return userRepository.findById(userID);
    }
}
