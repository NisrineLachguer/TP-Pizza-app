package com.example.pizza_application;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PizzaDetailActivity extends AppCompatActivity {

    private ImageView pizzaImage;
    private ImageView shareIcon;

    private TextView pizzaTitle, pizzaDescription, pizzaIngredients, pizzaPreparation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_detail);

        shareIcon = findViewById(R.id.imageView6);
        pizzaImage = findViewById(R.id.pizzaImage);
        pizzaTitle = findViewById(R.id.pizzaTitle);
        pizzaDescription = findViewById(R.id.pizzaDescription);
        pizzaIngredients = findViewById(R.id.pizzaIngredients);
        pizzaPreparation = findViewById(R.id.pizzaPreparation);

        Intent intent = getIntent();
        if (intent != null) {
            String title = intent.getStringExtra("PRODUIT_NOM");
            String description = intent.getStringExtra("PRODUIT_DESCRIPTION");
            String ingredients = intent.getStringExtra("PRODUIT_DETAIL_INGRED");
            String preparation = intent.getStringExtra("PRODUIT_PREPARATION");
            int imageResId = intent.getIntExtra("PRODUIT_IMAGE", R.mipmap.pizza2); // Image par défaut

            pizzaImage.setImageResource(imageResId);
            pizzaTitle.setText(title);
            pizzaDescription.setText(description);
            pizzaIngredients.setText(ingredients);
            pizzaPreparation.setText(preparation);
        }

        shareIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareRecipe();
            }
        });
    }

    private void shareRecipe() {
        String shareText = "Check out this delicious pizza recipe!\n\n" +
                "Title: " + pizzaTitle.getText().toString() + "\n" +
                "Description: " + pizzaDescription.getText().toString() + "\n" +
                "Ingredients: " + pizzaIngredients.getText().toString() + "\n" +
                "Preparation: " + pizzaPreparation.getText().toString();

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
        whatsappIntent.setType("text/plain");
        whatsappIntent.setPackage("com.whatsapp"); // Package de WhatsApp
        whatsappIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        Intent facebookIntent = new Intent(Intent.ACTION_SEND);
        facebookIntent.setType("text/plain");
        facebookIntent.setPackage("com.facebook.katana"); // Package de Facebook
        facebookIntent.putExtra(Intent.EXTRA_TEXT, shareText);

        Intent chooserIntent = Intent.createChooser(shareIntent, "Share Recipe");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{whatsappIntent, facebookIntent});

        startActivity(chooserIntent);
    }
}