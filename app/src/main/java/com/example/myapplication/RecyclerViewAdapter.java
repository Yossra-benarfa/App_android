package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyHolder> {

    private final Context mContext;
    private List<Recipes> mData;

    public RecyclerViewAdapter(Context mContext, List<Recipes> mData){
        this.mContext = mContext;
        this.mData = mData;
    }



    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view ;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.cardview_recipe,viewGroup,false);
        return  new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyHolder myHolder,  final int i) {

        myHolder.recipeTitle.setText(mData.get(i).getRecipeName());
        myHolder.img_recipe_thumbnail.setImageResource(mData.get(i).getThumbnail());
        myHolder.cardView.setOnClickListener(v -> {

            Intent intent = new Intent(mContext,RecipeActivity.class);
           intent.putExtra("RecipeName" ,mData.get(i).getRecipeName());
            intent.putExtra("RecipeIngredients",mData.get(i).getRecipeIngredients());
            intent.putExtra("RecipeTitle1",mData.get(i).getRecipeTitle1());
            intent.putExtra("RecipeTitle1Detail",mData.get(i).getRecipeTitle1Detail());
            intent.putExtra("RecipeTitle2",mData.get(i).getRecipeTitle2());
            intent.putExtra("RecipeTitle2Detail",mData.get(i).getRecipeTitle2Detail());
//            intent.putExtra("Recipe",mData.get(i).getRecipe());
            intent.putExtra("Thumbnail",mData.get(i).getThumbnail());

            mContext.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        TextView recipeTitle;
        CardView cardView;
        ImageView img_recipe_thumbnail;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            recipeTitle = (TextView)itemView.findViewById(R.id.recipe_text);
            img_recipe_thumbnail = (ImageView)itemView.findViewById(R.id.recipe_img_id);
            cardView = itemView.findViewById(R.id.cardview_id);


        }
    }
}