package com.saudebucal.service;

import com.saudebucal.model.HabitoBucal;
import com.saudebucal.model.User;
import com.saudebucal.repository.HabitoBucalRepository;
import com.saudebucal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitoBucalService {

    @Autowired
    private HabitoBucalRepository habitoBucalRepository;

    @Autowired
    private UserRepository userRepository;

    // Salvar ou atualizar um hábito bucal
    public HabitoBucal saveHabito(HabitoBucal habito, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        habito.setUser(user);
        return habitoBucalRepository.save(habito);
    }

    // Buscar todos os hábitos bucais
    public List<HabitoBucal> getAllHabitos() {
        return habitoBucalRepository.findAll();
    }

    // Buscar hábitos bucais de um usuário específico
    public List<HabitoBucal> getHabitosByUserId(Long userId) {
        return habitoBucalRepository.findByUserId(userId);
    }

    // Excluir um hábito bucal por ID
    public void deleteHabito(Long id) {
        habitoBucalRepository.deleteById(id);
    }
}