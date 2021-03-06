package nl.lotrac.bv.service;


import nl.lotrac.bv.exceptions.*;
import nl.lotrac.bv.model.Authority;
import nl.lotrac.bv.model.Role;
import nl.lotrac.bv.model.User;
import nl.lotrac.bv.utils.RandomStringGenerator;

import nl.lotrac.bv.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
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
            throw new NameExistsException(user.getUsername() + "  exists!!");
        System.out.println("create user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = userRepository.save(user);
        return (newUser.getUsername());
    }

    @Override
    public void updateUser(String username, User newUser) {
        if (!userRepository.existsById(username)) throw new NameNotFoundException("user does not exists");
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
    public User getUser(String username) {
        System.out.println("UserServiceImpl getUser");
        User user = userRepository.getUserByUsername(username);
        return user;
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
        if (!userRepository.existsById(username)) throw new NameNotFoundException(username);
        User user = userRepository.findById(username).get();
        return user.getAuthorities();
    }

    @Override
    public void addAuthority(String username, Role authority) {
        if (!userRepository.existsById(username)) throw new NameNotFoundException(username);
        User user = userRepository.findById(username).get();
        user.addAuthority(new Authority(username, authority));
        userRepository.save(user);
    }

    @Override
    public void removeAuthority(String username, Role authority) {
        if (!userRepository.existsById(username)) throw new NameNotFoundException(username);
        User user = userRepository.findById(username).get();
        Authority authorityToRemove = user.getAuthorities().stream().filter((a) -> a.getAuthorityRole().equals(authority)).findAny().get();
        user.removeAuthority(authorityToRemove);
        userRepository.save(user);
    }

}