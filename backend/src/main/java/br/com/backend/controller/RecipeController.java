package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.controller.dto.RecipeDto;
import br.com.backend.model.Recipe;
import br.com.backend.service.RecipeService;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	RecipeService service;

	@GetMapping
	public List<RecipeDto> list() {
		List<Recipe> recipes = this.service.list();
		return RecipeDto.convert(recipes);
	}

}
