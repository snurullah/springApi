package com.adresetiket.AdresEtiket.Service;

import com.adresetiket.AdresEtiket.Entity.User;
import com.adresetiket.AdresEtiket.Repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IUserService implements UserService {

    private final UserRepository userRepository;

    public IUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getList() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Integer userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User getLoginUserName(String name){
        return userRepository.getLoginUserName(name);
    }
}