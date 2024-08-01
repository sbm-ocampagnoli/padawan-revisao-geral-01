package br.com.backend.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.backend.model.Ingredient;

public class IngredientDto {

	private String name;

	public IngredientDto() {
	}

	public IngredientDto(Ingredient ingredient) {
		this.name = ingredient.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<IngredientDto> convert(List<Ingredient> ingredients) {
		return ingredients.stream().map(IngredientDto::new).collect(Collectors.toList());
	}
}
