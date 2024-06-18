package com.app.service;

import javax.transaction.Transactional;

import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.custom_exc.ResourceNotFound;
import com.app.dto.Apiresponse;
import com.app.entities.Recipe;
import com.app.entities.User;
import com.app.repository.RecipeRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class RecipeService {
	@Autowired 
	RecipeRepository recipeRepo;
	@Autowired
	UserRepository userRepo;
	
	public Apiresponse createRecipe(Recipe recipe) {
		User author=userRepo.getByName(recipe.getAuthor().getName());
		recipe.setAuthor(author);
		recipeRepo.save(recipe);
		return new Apiresponse("receipe added" +recipe.getId());
		}
	
	public Recipe getRecipeById(Long Id) {
		Recipe recipe=recipeRepo.findById(Id).orElse(null);
		if(recipe!=null) {
			return recipe;
			
			
		}
		else
			throw new ResourceNotFound("invalid id");
		
		
	}
	
	public Apiresponse deleteRecipe(Long id) {
		Recipe recipe=recipeRepo.findById(id).orElse(null);
		if(recipe!=null) {
			recipeRepo.deleteById(id);
			return new Apiresponse("recipe deleted");
		}
		else 
			throw new ResourceNotFound("wrong id");
		
	}
	
	public Apiresponse updateRecipe(Long id,Recipe recipe) {
		String msg="invalid id!!!";
		Recipe recipe1=recipeRepo.findById(id).orElse(null);
		if(recipe !=null) {
			recipe1.setTitle(recipe.getTitle());
			recipe1.setIngredients(recipe.getIngredients());
			recipe1.setCuisninType(recipe.getCuisninType());
			recipe1.setDescription(recipe.getCuisninType());
			recipe1.setDate(recipe.getDate());
			recipe1.setInstructions(recipe.getInstructions());
			recipe1.setDifficultyLevel(recipe.getDifficultyLevel());
			recipeRepo.save(recipe1);
			msg="upsated successfully!!!";
		}else
		{
			throw new ResourceNotFound("msg");
		}
		return new Apiresponse(msg);
		
	}

}
