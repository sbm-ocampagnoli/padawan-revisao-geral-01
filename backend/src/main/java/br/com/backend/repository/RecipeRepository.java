package br.com.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.backend.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	@Query(value = "SELECT * FROM recipe WHERE name LIKE %:name%", nativeQuery = true)
	List<Recipe> findAllByName(@Param("name") String name);
}
