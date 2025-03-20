package com.saudebucal.service;

import com.saudebucal.model.User;
import com.saudebucal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Salvar ou atualizar um usuário
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Buscar todos os usuários
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Buscar um usuário por ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Excluir um usuário por ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Buscar um usuário por email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}