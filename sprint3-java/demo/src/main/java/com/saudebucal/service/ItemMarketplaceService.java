package com.saudebucal.service;

import com.saudebucal.model.ItemMarketplace;
import com.saudebucal.model.User;
import com.saudebucal.repository.ItemMarketplaceRepository;
import com.saudebucal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMarketplaceService {

    @Autowired
    private ItemMarketplaceRepository itemMarketplaceRepository;

    @Autowired
    private UserRepository userRepository;

    // Salvar ou atualizar um item do marketplace
    public ItemMarketplace saveItem(ItemMarketplace item) {
        return itemMarketplaceRepository.save(item);
    }

    // Buscar todos os itens do marketplace
    public List<ItemMarketplace> getAllItems() {
        return itemMarketplaceRepository.findAll();
    }

    // Buscar itens por nome
    public List<ItemMarketplace> getItemsByNome(String nome) {
        return itemMarketplaceRepository.findByNomeContaining(nome);
    }

    // Comprar um item (deduzir pontos do usuário)
    public void comprarItem(Long itemId, Long userId) {
        ItemMarketplace item = itemMarketplaceRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (user.getPontos() >= item.getPontosNecessarios()) {
            user.setPontos(user.getPontos() - item.getPontosNecessarios());
            userRepository.save(user);
        } else {
            throw new RuntimeException("Pontos insuficientes para comprar o item.");
        }
    }
}