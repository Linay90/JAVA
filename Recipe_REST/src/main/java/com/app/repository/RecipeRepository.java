package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
