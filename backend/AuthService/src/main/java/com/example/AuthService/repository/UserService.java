package com.example.AuthService.repository;

import com.example.AuthService.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

//    @Cacheable(value="userList")
    public List<User> retrieveUsers(){
        return repository.findAll();
    }

    public User retrieveUserByName(String firstname) {
        return repository.findByName(firstname);
    }
//    @Cacheable(value="user", key="#id")
    public User retrieveUserByID(String _id) {
        return repository.findByID(_id);
    }

    public User validate(String email, String password) {
        User user = repository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }

        return null;
    }

    public User createUser(User user) {
        return repository.save(user);
    }

//    @CachePut(value="user", key="#wizard.getName()")
//    @CacheEvict(value="userList", allEntries=true)
    public User updateUser(User user) {
        return repository.save(user);
    }

//    @CacheEvict(value="wizard", key="#wizard.getName()")
//    @Caching(evict={ @CacheEvict(value="wizardList", allEntries=true) })
    public boolean deleteUser(User user) {
        try {
            repository.delete(user);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
