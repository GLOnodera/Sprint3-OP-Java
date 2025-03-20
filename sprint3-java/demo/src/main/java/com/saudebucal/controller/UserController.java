package com.saudebucal.controller;

import com.saudebucal.model.User;
import com.saudebucal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Listar todos os usuários
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", userRepository.findAll());
        return "usuarios/list";
    }

    // Mostrar formulário de cadastro
    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new User());
        return "usuarios/form";
    }

    // Salvar um novo usuário
    @PostMapping("/salvar")
    public String salvarUsuario(@ModelAttribute User usuario) {
        userRepository.save(usuario);
        return "redirect:/usuarios";
    }

    // Editar um usuário existente
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        User usuario = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuário inválido: " + id));
        model.addAttribute("usuario", usuario);
        return "usuarios/form";
    }

    // Excluir um usuário
    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable Long id) {
        userRepository.deleteById(id);
        return "redirect:/usuarios";
    }
}