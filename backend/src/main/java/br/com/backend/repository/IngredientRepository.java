package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
