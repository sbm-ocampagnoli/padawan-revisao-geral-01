package br.com.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.backend.model.Ingredient;
import br.com.backend.repository.IngredientRepository;

@Service
public class IngredientService {

	@Autowired
	private IngredientRepository repository;

	public List<Ingredient> list() {
		return this.repository.findAll();
	}
}
