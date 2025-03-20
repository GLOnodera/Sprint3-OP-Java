package com.saudebucal.repository;

import com.saudebucal.model.ItemMarketplace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMarketplaceRepository extends JpaRepository<ItemMarketplace, Long> {
    List<ItemMarketplace> findByNomeContaining(String nome);
}