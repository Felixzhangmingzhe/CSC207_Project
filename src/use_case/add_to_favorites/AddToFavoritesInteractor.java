package use_case.add_to_favorites;

import entity.Recipe;

public class AddToFavoritesInteractor implements AddToFavoritesInputBoundary {
    // Data access interface and presenter
    private final AddToFavoritesDataAccessInterface userDataAccess;
    private final AddToFavoritesOutputBoundary presenter;

    // Constructor
    public AddToFavoritesInteractor(AddToFavoritesDataAccessInterface userDataAccess, AddToFavoritesOutputBoundary presenter) {
        this.userDataAccess = userDataAccess;
        this.presenter = presenter;
    }

    // Implementation of execute method in Input Boundary
    @Override
    public void execute(AddToFavoritesInputData inputData) {
        Recipe recipe = userDataAccess.getRecipeByTitle(inputData.getTitle());
        if (recipe.getIsFavorite()) {
            boolean isFavorite = false;
            userDataAccess.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(),isFavorite , recipe.getIsCooked(), recipe.getCalories());
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("", "Recipe is deleted from favorites");
            presenter.prepareSuccessView(outputData);
        } else {
            boolean isFavorite = true;
            userDataAccess.updateRecipe(recipe.getId(), recipe.getTitle(), recipe.getContent(), recipe.getDate(), isFavorite, recipe.getIsCooked(), recipe.getCalories());
            AddToFavoritesOutputData outputData = new AddToFavoritesOutputData("Recipe is added to favorites", "" );
            presenter.prepareSuccessView(outputData);
        }
    }
}
