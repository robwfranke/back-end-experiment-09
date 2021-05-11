package nl.lotrac.bv.service;


import nl.lotrac.bv.model.Authority;
import nl.lotrac.bv.model.User;
import nl.lotrac.bv.utils.RandomStringGenerator;

import nl.lotrac.bv.exceptions.RecordNotFoundException;
import nl.lotrac.bv.exceptions.UsernameExistsException;
import nl.lotrac.bv.exceptions.UsernameNotFoundException;

import nl.lotrac.bv.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public boolean userExists(String username) {
        return userRepository.existsById(username);
    }


    @Override
    public String createUser(User user) {
        if (userRepository.existsById(user.getUsername()))
            throw new UsernameExistsException(user.getUsername() + "  exists!!");
        System.out.println("create user");
        String randomString = RandomStringGenerator.generateAlphaNumeric(20);
        user.setApikey(randomString);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        return (newUser.getUsername());
    }

    @Override
    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new RecordNotFoundException();
        User user = userRepository.findById(username).get();
//        user.setPassword(newUser.getPassword());
        user.setEmail(newUser.getEmail());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public Optional<User> getUser(String username) {
        return userRepository.findById(username);
    }

    @Override
    public Collection<User> getUsers() {
        return userRepository.findAll();
    }


    @Override
    public Collection<User> getAllAuthorities() {
        return userRepository.findAll();
    }


    @Override
    public Set<Authority> getAuthorities(String username) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    @Override
    public void addAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, String authority) {
        if (!userRepository.existsById(username)) throw new UsernameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthority().equalsIgnoreCase(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

}