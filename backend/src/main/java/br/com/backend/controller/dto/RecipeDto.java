package br.com.backend.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.backend.controller.form.RecipeForm;
import br.com.backend.model.Recipe;

public class RecipeDto {
	private String name;
	private String description;
	private String instructions;

	public RecipeDto() {
	}

	public RecipeDto(Recipe recipe) {
		this.name = recipe.getName();
		this.description = recipe.getDescription();
		this.instructions = recipe.getInstructions();
	}
	
	public RecipeDto(RecipeForm form) {
		this.name = form.getName();
		this.description = form.getDescription();
		this.instructions = form.getInstructions();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public static List<RecipeDto> convert(List<Recipe> recipes) {
		return recipes.stream().map(RecipeDto::new).collect(Collectors.toList());
	}

}
