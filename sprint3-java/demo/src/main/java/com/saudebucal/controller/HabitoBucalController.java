package com.saudebucal.controller;

import com.saudebucal.model.HabitoBucal;
import com.saudebucal.model.User;
import com.saudebucal.repository.HabitoBucalRepository;
import com.saudebucal.repository.UserRepository;
import com.saudebucal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/habitos")
public class HabitoBucalController {

    @Autowired
    private HabitoBucalRepository habitoBucalRepository;

    @Autowired
    private UserRepository userRepository;
    private UserService userService;

    // Listar todos os hábitos
    @GetMapping
    public String listarHabitos(Model model) {
        model.addAttribute("habitos", habitoBucalRepository.findAll());
        return "habitos/list";
    }

    // Mostrar formulário de registro de hábito
    @GetMapping("/habitos/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("habito", new HabitoBucal());
        model.addAttribute("usuarios", userService.getAllUsers());
        return "habitos/form";
    }

    // Salvar um novo hábito
    @PostMapping("/salvar")
    public String salvarHabito(@ModelAttribute HabitoBucal habito, @RequestParam Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário inválido: " + userId));
        habito.setUser(user);
        habitoBucalRepository.save(habito);

        // Atualiza os pontos do usuário
        user.setPontos(user.getPontos() + habito.getPontosGerados());
        userRepository.save(user);

        return "redirect:/habitos";
    }

    // Excluir um hábito
    @GetMapping("/excluir/{id}")
    public String excluirHabito(@PathVariable Long id) {
        habitoBucalRepository.deleteById(id);
        return "redirect:/habitos";
    }
}