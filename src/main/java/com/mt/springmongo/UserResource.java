package com.mt.springmongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * Rest controller which is responsible for retrieving {@link User}s.
 *
 * @author Mithun
 */
@RestController
@RequestMapping(value = "/api/users")
public class UserResource {

    private final UserRepository userRepository;

    @Autowired
    public UserResource(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(produces = "application/JSON")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = "application/JSON")
    public Optional<User> findById(@PathVariable("id") String userID) {
        return userRepository.findById(userID);
    }
}
