package br.com.backend.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.controller.form.RecipeForm;
import br.com.backend.model.Recipe;
import br.com.backend.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository repository;

	public List<Recipe> list() {
		return this.repository.findAll();
	}

	public Recipe add(Recipe recipe) {
		return this.repository.save(recipe);
	}

	public Recipe update(Long id, RecipeForm form) {
		Recipe recipe = repository.getReferenceById(id);
		recipe.setName(form.getName());
		recipe.setDescription(form.getDescription());
		recipe.setInstructions(form.getInstructions());
		recipe.setUpdatedAt(LocalDateTime.now());
		return recipe;
	}

	public void delete(Long id) {
		this.repository.deleteById(id);
	}
}
