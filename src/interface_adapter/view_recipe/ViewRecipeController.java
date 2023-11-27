package interface_adapter.view_recipe;

import use_case.view_recipe.ViewRecipeInputBoundary;
import use_case.view_recipe.ViewRecipeInputData;

public class ViewRecipeController {
    private final ViewRecipeInputBoundary inputBoundary;

    public ViewRecipeController(ViewRecipeInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    public void execute(int recipeId) {
        ViewRecipeInputData inputData = new ViewRecipeInputData(recipeId);
        inputBoundary.viewRecipe(inputData);
    }


}
