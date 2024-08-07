package com.viniciussantos.controller;


import com.viniciussantos.model.Recipe;
import com.viniciussantos.model.User;
import com.viniciussantos.service.RecipeService;
import com.viniciussantos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public Recipe createRecipe(@RequestBody Recipe recipe,
                               @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserByJwt(jwt);

        Recipe createdRecipe = recipeService.createRecipe(recipe, user);

        return createdRecipe;
    }

    @PutMapping("/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {

        Recipe updatedRecipe = recipeService.updateRecipe(recipe, id);
        return updatedRecipe;
    }

    @GetMapping
    public List<Recipe> getAllRecipe() {
        return  recipeService.findAllRecipe();
    }


    @DeleteMapping("/{recipeId}")
    public String deleteRecipe( @PathVariable Long recipeId) throws Exception {
        recipeService.deleteRecipe(recipeId);
        return "Recipe deleted successfully";
    }

    @PutMapping("/{id}/like")
    public Recipe likeRecipe(@RequestHeader("Authorization") String jwt,
                             @PathVariable Long id) throws Exception {
        User user = userService.findUserByJwt(jwt);


        Recipe updatedRecipe = recipeService.likeRecipe(id, user);
        return updatedRecipe;
    }
}
