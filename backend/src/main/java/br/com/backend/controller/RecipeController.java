package br.com.backend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.backend.controller.dto.RecipeDto;
import br.com.backend.controller.form.RecipeForm;
import br.com.backend.model.Recipe;
import br.com.backend.service.RecipeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

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

	@PostMapping
	@Transactional
	public ResponseEntity<Recipe> add(@RequestBody RecipeForm form, UriComponentsBuilder uriBuilder) {
		Recipe recipe = form.convert(form);
		service.add(recipe);

		URI uri = uriBuilder.path("/recipes/{id}").buildAndExpand(recipe.getId()).toUri();

		return ResponseEntity.created(uri).body(new Recipe(recipe));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<RecipeDto> update(@PathVariable Long id, @RequestBody @Valid RecipeForm form) {
		Recipe recipe = service.update(id, form);
		return ResponseEntity.ok((new RecipeDto(recipe)));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
