package br.com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.controller.dto.IngredientDto;
import br.com.backend.model.Ingredient;
import br.com.backend.service.IngredientService;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

	@Autowired
	private IngredientService service;

	@GetMapping
	public List<IngredientDto> list() {
		List<Ingredient> ingredients = this.service.list();
		return IngredientDto.convert(ingredients);
	}

}
