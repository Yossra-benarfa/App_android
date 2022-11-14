package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;

import android.os.Bundle;

import android.content.Intent;


import android.widget.TextView;
public class RecipeActivity extends AppCompatActivity {

    private TextView mRecipeName;
    private TextView mRecipeIngredients;
    private TextView RecipeTitle1;
    private TextView RecipeTitle1Detail;
    private TextView RecipeTitle2;
    private TextView RecipeTitle2Detail;
    //private TextView mRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        mRecipeName = findViewById(R.id.text_recipe);
        mRecipeIngredients = findViewById(R.id.ingredients);
        RecipeTitle1 = findViewById(R.id.title1);
        RecipeTitle1Detail = findViewById(R.id.title1_detail);
        RecipeTitle2 = findViewById(R.id.title2);
        RecipeTitle2Detail = findViewById(R.id.title2_detail);

        Intent intent = getIntent();
        String Title = intent.getExtras().getString("RecipeName");
        String Ingredients = intent.getExtras().getString("RecipeIngredients");
        String title1 = intent.getExtras().getString("RecipeTitle1");
        String title1Detail = intent.getExtras().getString("RecipeTitle1Detail");
        String title2 = intent.getExtras().getString("RecipeTitle2");
        String title2Detail = intent.getExtras().getString("RecipeTitle2Detail");

        String Recipe = intent.getExtras().getString("Recipe");

        mRecipeName.setText(Title);
        mRecipeIngredients.setText(Ingredients);
        RecipeTitle1.setText(title1);
        RecipeTitle1Detail.setText(title1Detail);
        RecipeTitle2.setText(title2);
        RecipeTitle2Detail.setText(title2Detail);
    }
}