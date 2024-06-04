package com.example.multi_pageapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat

class ForLater : AppCompatActivity() {
    private val favoritesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forlater)

        loadFavoritesList()
        refreshFavoritesList()

        val backToMainButton = findViewById<Button>(R.id.backbutton3)
        backToMainButton.setOnClickListener {
            finish()
        }
    }

    private fun refreshFavoritesList() {
        val forLaterContainer = findViewById<LinearLayout>(R.id.forLaterContainer)
        forLaterContainer.removeAllViews() // Clear the container first

        // Checks if the favorites list is not null and not empty
        if (favoritesList.isNotEmpty()) {
            for (favorite in favoritesList) {
                // Create a new Button for each favorite item
                val button = Button(this).apply {
                    text = favorite
                    textSize = 16f
                    setTextColor(Color.BLACK)  // Text color set to black
                    typeface = ResourcesCompat.getFont(context, R.font.helveticaneuebold)
                    setBackgroundColor(ContextCompat.getColor(context, R.color.edc49e))
                    setPadding(16, 8, 16, 8)
                    setOnClickListener {
                        showFoodDialog(favorite)
                    }
                }
                forLaterContainer.addView(button)
            }
        }
    }

    private fun showFoodDialog(foodName: String) {
        val foodDescription = getFoodDescription(foodName)
        val imageResId = getImageResId(foodName)

        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup, null)
        val foodImage = dialogView.findViewById<ImageView>(R.id.mlklogo)
        val foodNameTextView = dialogView.findViewById<TextView>(R.id.food_name)
        val foodDescriptionTextView = dialogView.findViewById<TextView>(R.id.food_description)
        val removeButton = dialogView.findViewById<Button>(R.id.buttonForLater)

        foodImage.setImageResource(imageResId)
        foodNameTextView.text = foodName
        foodDescriptionTextView.text = foodDescription
        removeButton.text = "Remove?"

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .create()

        removeButton.setOnClickListener {
            removeFromFavorites(foodName)
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun getFoodDescription(foodName: String): String {
        return when (foodName) {
            "Beef Pares" -> "Beef Pares is a popular Filipino dish made from tender beef cubes braised in a sweet-salty sauce, typically served with garlic fried rice and beef soup.\n" +
                    "Recipe:\n" +
                    "Ingredients: Beef brisket, soy sauce, star anise, garlic, onion, sugar, pepper, bay leaf, beef broth.\n" +
                    "Instructions:\n" +
                    "1: In a pot, sauté garlic and onions until fragrant.\n" +
                    "2: Add beef and brown on all sides.\n" +
                    "3: Pour in soy sauce, beef broth, sugar, star anise, bay leaf, and pepper.\n" +
                    "4: Simmer until beef is tender and sauce thickens.\n" +
                    "5: Serve with garlic fried rice and a side of beef broth."

            "Biko" -> "Biko is a traditional Filipino sticky rice cake made with glutinous rice, coconut milk, and brown sugar, often topped with latik (coconut curds).\n" +
                    "Recipe:\n" +
                    "Ingredients: Glutinous rice, coconut milk, brown sugar, salt.\n" +
                    "Instructions:\n" +
                    "1: Cook glutinous rice with water until done.\n" +
                    "2: In a separate pot, combine coconut milk, brown sugar, and salt. Cook until thick.\n" +
                    "3: Mix the cooked rice into the coconut milk mixture.\n" +
                    "4: Transfer to a serving tray and top with latik.\n" +
                    "5: Let it cool before slicing."

            "Chopsuey" -> "Chopsuey is a stir-fried vegetable dish commonly found in Filipino cuisine, often including meat like chicken, pork, or shrimp, and flavored with soy sauce and oyster sauce.\n" +
                    "Recipe:\n" +
                    "Ingredients: Mixed vegetables (carrots, cabbage, bell peppers, etc.), chicken or shrimp, soy sauce, oyster sauce, garlic, onion, cornstarch.\n" +
                    "Instructions:\n" +
                    "1: Sauté garlic and onions in a pan.\n" +
                    "2: Add chicken or shrimp and cook until done.\n" +
                    "3: Add vegetables and stir-fry until tender.\n" +
                    "4: Pour in soy sauce and oyster sauce.\n" +
                    "5: Thicken with a cornstarch slurry if needed."

            "Kare-kare" -> "Kare-kare is a rich and savory Filipino stew made with oxtail, tripes, and vegetables, simmered in a peanut sauce and traditionally served with bagoong (fermented shrimp paste).\n" +
                    "Recipe:\n" +
                    "Ingredients: Oxtail, tripe, eggplant, string beans, banana heart, peanut butter, garlic, onion, annatto powder.\n" +
                    "Instructions:\n" +
                    "1: Boil oxtail and tripe until tender.\n" +
                    "2: Sauté garlic and onions, then add peanut butter and annatto powder.\n" +
                    "3: Mix in the boiled meat and vegetables.\n" +
                    "4: Simmer until vegetables are tender.\n" +
                    "5: Serve with bagoong on the side."

            "Korean Cheese Bread" -> "A soft, sweet bun filled with creamy cheese and topped with a slightly crispy, cheesy exterior, popular in Korean bakeries.\n" +
                    "Recipe:\n" +
                    "Ingredients: Bread dough, cream cheese, sugar, butter, eggs, cheese slices.\n" +
                    "Instructions:\n" +
                    "1: Prepare the bread dough and let it rise.\n" +
                    "2: Mix cream cheese with sugar and fill the dough balls.\n" +
                    "3: Top with a mixture of butter, eggs, and cheese slices.\n" +
                    "4: Bake until golden brown."

            "Macaroni Salad" -> "Filipino-style macaroni salad is a creamy and slightly sweet pasta dish mixed with mayonnaise, condensed milk, cheese, and various fruits and vegetables.\n" +
                    "Recipe:\n" +
                    "Ingredients: Macaroni, mayonnaise, condensed milk, cheese, carrots, pineapple tidbits, raisins.\n" +
                    "Instructions:\n" +
                    "1: Cook macaroni according to package instructions.\n" +
                    "2: Mix with mayonnaise, condensed milk, and cheese.\n" +
                    "3: Add in diced carrots, pineapple tidbits, and raisins.\n" +
                    "4: Chill before serving."

            "Palabok" -> "Palabok is a popular Filipino noodle dish topped with a savory orange sauce, shrimp, hard-boiled eggs, chicharrón, and green onions.\n" +
                    "Recipe:\n" +
                    "Ingredients: Rice noodles, shrimp, pork, garlic, onion, annatto powder, cornstarch, hard-boiled eggs, chicharrón, green onions.\n" +
                    "Instructions:\n" +
                    "1: Cook the rice noodles according to package instructions.\n" +
                    "2: Sauté garlic and onions, then add shrimp and pork.\n" +
                    "3: Add water and annatto powder to create a sauce.\n" +
                    "4: Thicken the sauce with cornstarch slurry.\n" +
                    "5: Top noodles with sauce, hard-boiled eggs, chicharrón, and green onions."

            "Pancit Bihon" -> "Pancit Bihon is a traditional Filipino noodle dish made with rice noodles stir-fried with chicken, shrimp, and mixed vegetables.\n" +
                    "Recipe:\n" +
                    "Ingredients: Bihon (rice noodles), chicken, shrimp, soy sauce, garlic, onion, mixed vegetables.\n" +
                    "Instructions:\n" +
                    "1: Sauté garlic and onions in a pan.\n" +
                    "2: Add chicken and shrimp and cook until done.\n" +
                    "3: Add mixed vegetables and cook until tender.\n" +
                    "4: Stir in soaked bihon noodles and soy sauce.\n" +
                    "5: Mix until noodles are well coated."

            "Pandesal" -> "Pandesal is a popular Filipino bread roll that is soft, slightly sweet, and often enjoyed for breakfast.\n" +
                    "Recipe:\n" +
                    "Ingredients: Flour, yeast, sugar, salt, butter, eggs.\n" +
                    "Instructions:\n" +
                    "1: Mix flour, yeast, sugar, and salt in a bowl.\n" +
                    "2: Add butter and eggs, then knead until smooth.\n" +
                    "3: Let the dough rise, then shape into rolls.\n" +
                    "4: Bake until golden brown."

            "Pinakbet" -> "Pinakbet is a savory Filipino vegetable dish made with mixed vegetables, pork, and flavored with shrimp paste.\n" +
                    "Recipe:\n" +
                    "Ingredients: Mixed vegetables (eggplant, bitter melon, squash, etc.), pork, shrimp paste, garlic, onion, tomatoes.\n" +
                    "Instructions:\n" +
                    "1: Sauté garlic, onions, and tomatoes.\n" +
                    "2: Add pork and cook until browned.\n" +
                    "3: Add mixed vegetables and shrimp paste.\n" +
                    "4: Simmer until vegetables are tender."

            "Siopao" -> "Siopao is a Filipino steamed bun filled with savory meats like pork or chicken, often flavored with a sweet and salty sauce.\n" +
                    "Recipe:\n" +
                    "Ingredients: Flour, yeast, sugar, salt, pork or chicken, soy sauce, hoisin sauce, cornstarch.\n" +
                    "Instructions:\n" +
                    "1: Prepare dough with flour, yeast, sugar, and salt.\n" +
                    "2: Cook the filling with pork or chicken, soy sauce, and hoisin sauce.\n" +
                    "3: Fill dough with the cooked meat mixture.\n" +
                    "4: Steam until buns are puffy and cooked through.\n"

            "Spaghetti" -> "Filipino-style spaghetti is a sweet and savory pasta dish with a sauce made from ground meat, hotdogs, and a sweet tomato sauce.\n" +
                    "Recipe:\n" +
                    "Ingredients: Spaghetti noodles, ground beef, hotdogs, tomato sauce, banana ketchup, garlic, onion, sugar.\n" +
                    "Instructions:\n" +
                    "1: Cook spaghetti noodles according to package instructions.\n" +
                    "2: Sauté garlic and onions, then add ground beef and cook until browned.\n" +
                    "3: Add sliced hotdogs, tomato sauce, and banana ketchup.\n" +
                    "4: Simmer and add sugar to taste.\n" +
                    "5: Serve sauce over cooked spaghetti."

            "Spring Rolls" -> "Filipino spring rolls, or lumpia, are made with a mixture of ground meat and vegetables wrapped in a thin pastry and fried until crispy.\n" +
                    "Recipe:\n" +
                    "Ingredients: Spring roll wrappers, ground pork, carrots, onions, garlic, soy sauce, pepper.\n" +
                    "Instructions:\n" +
                    "1: Mix ground pork with finely chopped carrots, onions, and garlic.\n" +
                    "2: Season with soy sauce and pepper.\n" +
                    "3: Wrap mixture in spring roll wrappers.\n" +
                    "4: Fry until golden brown and crispy."

            "Ube Pandesal" -> "Ube Pandesal is a modern twist on the classic Filipino bread roll, filled with a sweet purple yam (ube) filling.\n" +
                    "Recipe:\n" +
                    "Ingredients: Flour, yeast, sugar, salt, ube jam, butter, eggs.\n" +
                    "Instructions:\n" +
                    "1: Prepare dough with flour, yeast, sugar, and salt.\n" +
                    "2: Fill with ube jam.\n" +
                    "3: Let the dough rise, then shape into rolls.\n" +
                    "4: Bake until golden brown."

            else -> ""
        }
    }

    private fun getImageResId(foodName: String): Int {
        return when (foodName) {
            "Beef Pares" -> R.drawable.beefpares
            "Biko" -> R.drawable.biko
            "Chopsuey" -> R.drawable.chopsuey
            "Kare-kare" -> R.drawable.karekare
            "Korean Cheese Bread" -> R.drawable.koreancheesebread
            "Macaroni Salad" -> R.drawable.macaronisalad
            "Palabok" -> R.drawable.palabok
            "Pancit Bihon" -> R.drawable.pancitbihon
            "Pandesal" -> R.drawable.pandesal
            "Pinakbet" -> R.drawable.pinakbet
            "Siopao" -> R.drawable.siopao
            "Spaghetti" -> R.drawable.spaghetti
            "Spring Rolls" -> R.drawable.springrolls
            "Ube Pandesal" -> R.drawable.ubepandesal
            else -> 0
        }
    }

    private fun removeFromFavorites(foodName: String) {
        favoritesList.remove(foodName)
        saveFavoritesList()
        refreshFavoritesList()
        Toast.makeText(this, "$foodName has been removed from the list.", Toast.LENGTH_SHORT).show()
    }

    private fun loadFavoritesList() {
        val sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE)
        val favoritesSet = sharedPreferences.getStringSet("favoritesList", setOf())
        favoritesList.clear()
        favoritesList.addAll(favoritesSet?.toList() ?: emptyList())
    }

    private fun saveFavoritesList() {
        val sharedPreferences = getSharedPreferences("favorites", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putStringSet("favoritesList", favoritesList.toSet())
        editor.apply()
    }
}