package com.viniciussantos.repository;

import com.viniciussantos.model.Recipe;
import com.viniciussantos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
