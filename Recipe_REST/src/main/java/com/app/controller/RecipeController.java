package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Recipe;
import com.app.service.RecipeService;

@RestController
@RequestMapping("/addrecipe")
public class RecipeController {
	@Autowired
	RecipeService recipeService;
	@PostMapping
	public ResponseEntity<?>createRecipe(@RequestBody Recipe recipe){
		return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.createRecipe(recipe));
		
	}
	
	@GetMapping("/{id}")
	
	public ResponseEntity<?>getRecipeById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.getRecipeById(id));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteRecipe(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.deleteRecipe(id));
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?>updateRecipe(@PathVariable Long id ,@RequestBody Recipe recipe ){
		return ResponseEntity.status(HttpStatus.OK).body(recipeService.updateRecipe(id, recipe));
		
	}
	
    

}
