package br.com.backend.controller.form;

import java.time.LocalDateTime;

import org.hibernate.validator.constraints.Length;

import br.com.backend.model.Recipe;
import jakarta.validation.constraints.NotNull;

public class RecipeForm {

	@NotNull
	@Length(min = 2, max = 255)
	private String name;

	@NotNull
	@Length(min = 10)
	private String description;

	@NotNull
	@Length(min = 2)
	private String instructions;

	public RecipeForm() {
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

	public Recipe convert(RecipeForm form) {
		return new Recipe 
				(
				form.getName(), 
				form.getDescription(), 
				form.getInstructions(),
				LocalDateTime.now(),
				LocalDateTime.now()
				);
	}
}
