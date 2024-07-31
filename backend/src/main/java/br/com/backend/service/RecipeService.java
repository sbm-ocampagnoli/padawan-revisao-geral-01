package br.com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.model.Recipe;
import br.com.backend.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	private RecipeRepository repository;

	public List<Recipe> list() {
		return this.repository.findAll();
	}
}
