package br.com.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.backend.model.Recipe;

public interface RecipeRepository  extends JpaRepository<Recipe, Long>{

}
