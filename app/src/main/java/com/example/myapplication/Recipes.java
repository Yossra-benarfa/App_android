package com.example.myapplication;

public class Recipes {

    private String RecipeName;
    private String RecipeIngredients;
    private String RecipeTitle1;

    public String getRecipeTitle1() {
        return RecipeTitle1;
    }

    public void setRecipeTitle1(String recipeTitle1) {
        RecipeTitle1 = recipeTitle1;
    }

    public String getRecipeTitle2() {
        return RecipeTitle2;
    }

    public void setRecipeTitle2(String recipeTitle2) {
        RecipeTitle2 = recipeTitle2;
    }

    public String getRecipeTitle1Detail() {
        return RecipeTitle1Detail;
    }

    public void setRecipeTitle1Detail(String recipeTitle1Detail) {
        RecipeTitle1Detail = recipeTitle1Detail;
    }

    public String getRecipeTitle2Detail() {
        return RecipeTitle2Detail;
    }

    public void setRecipeTitle2Detail(String recipeTitle2Detail) {
        RecipeTitle2Detail = recipeTitle2Detail;
    }

    private String RecipeTitle2;
    private String RecipeTitle1Detail;
    private String RecipeTitle2Detail;
    private int Thumbnail;


    public Recipes(String name, String recipeIngredients,String recipeTitle1, String recipeTitle1Detail, String recipeTitle2, String recipeTitle2Detail, int thumbnail) {

        RecipeName = name;
        RecipeIngredients = recipeIngredients;
        RecipeTitle1 = recipeTitle1;
        RecipeTitle1Detail = recipeTitle1Detail;
        RecipeTitle2 = recipeTitle2;
        RecipeTitle2Detail = recipeTitle2Detail;
        Thumbnail = thumbnail;

    }


    public String getRecipeName() {

        return RecipeName;
    }


    public String getRecipeIngredients() {
        return RecipeIngredients;
    }




    public int getThumbnail() {
        return Thumbnail;
    }
}