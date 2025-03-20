package com.saudebucal.controller;

import com.saudebucal.model.ItemMarketplace;
import com.saudebucal.model.User;
import com.saudebucal.repository.ItemMarketplaceRepository;
import com.saudebucal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/marketplace")
public class MarketplaceController {

    @Autowired
    private ItemMarketplaceRepository itemMarketplaceRepository;

    @Autowired
    private UserRepository userRepository;

    // Listar todos os itens do marketplace
    @GetMapping
    public String listarItens(Model model) {
        model.addAttribute("itens", itemMarketplaceRepository.findAll());
        return "marketplace/list";
    }

    // Comprar um item
    @PostMapping("/comprar")
    public String comprarItem(@RequestParam Long itemId, @RequestParam Long userId) {
        ItemMarketplace item = itemMarketplaceRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item inválido: " + itemId));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Usuário inválido: " + userId));

        if (user.getPontos() >= item.getPontosNecessarios()) {
            user.setPontos(user.getPontos() - item.getPontosNecessarios());
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Pontos insuficientes para comprar o item.");
        }

        return "redirect:/marketplace";
    }
}