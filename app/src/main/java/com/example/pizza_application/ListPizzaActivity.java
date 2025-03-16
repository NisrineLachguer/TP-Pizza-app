package com.example.pizza_application;

import android.os.Bundle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import adapter.PizzaAdapter;
import classes.Produit;
import service.ProduitService;


public class ListPizzaActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView liste;
    private ProduitService fs = ProduitService.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_pizza);

        liste = findViewById(R.id.liste);
        fs.create(new Produit("Pizza pesto  burrata.",5,R.mipmap.pizza1,"25 min","- 2 boneless skinless chicken breast halves (6 ounces each)\\n- 1/4\n" +
                "teaspoon pepper\n- 1 cup barbecue sauce, divided\n- 1 tube (13.8 ounces)\n" +
                "refrigerated pizza crust\n- 2 teaspoons olive oil\n-2 cups shredded Gouda\n" +
                "cheese\n-1 small red onion, halved and thinly sliced\n-1/4 cup minced fresh\n" +
                "cilantro","So fast and so easy with refrigerated pizza crust, these saucy,\n" +
                "smoky pizzas make quick fans with their hot-off-the-grill, rustic flavor.\n" +
                "They're perfect for spur-of-the-moment cookouts and summer dinners on the\n" +
                "patio. —Alicia Trevithick, Temecula, California ","STEP 1:\n\n Sprinkle\n" +
                "chicken with pepper; place on an oiled grill rack over medium heat. Grill,\n" +
                "covered, until a thermometer reads 165°, 5-7 minutes per side, basting\n" +
                "frequently with 1/2 cup barbecue sauce during the last 4 minutes. Cool\n" +
                "slightly. Cut into cubes.\n\nSTEP 2:\n\n Divide dough in half. On a wellgreased large sheet of heavy-duty foil, press each portion of dough into a\n" +
                "10x8-in. rectangle; brush lightly with oil. Invert dough onto grill rack;\n" +
                "peel off foil. Grill, covered, over medium heat until bottom is lightly\n" +
                "browned, 1-2 minutes.\n\nSTEP 3:\n\n Remove from grill. Spread grilled\n" +
                "sides with remaining barbecue sauce. Top with cheese, chicken and onion.\n" +
                "Grill, covered, until bottom is lightly browned and cheese is melted, 2-3\n" +
                "minutes. Sprinkle with cilantro. Yield: 2 pizzas (4 pieces each)."));
        fs.create(new Produit("PIZZA MARGHERITA",7,R.mipmap.pizza2,"33 min","- 1 package (1/4 ounce) active dry\n" +
                "yeast\n- 1-1/4 cups warm water (110° to 115°)\n- 2 tablespoons olive oil\n1-1/2 teaspoons salt\n- 1 teaspoon sugar\n- 3-1/2 to 4 cups all-purpose\n" +
                "flour ","For 30 years, friends have been telling me to open a pizzeria using\n" +
                "this recipe. It even freezes well. —Elizabeth Wolff, Carmel, Indiana","STEP 1:\n" +
                "\n In a small bowl, dissolve yeast in warm water. In a large bowl,\n" +
                "combine oil, salt, sugar, yeast mixture and 1 cup flour; beat on medium\n" +
                "speed until smooth. Stir in enough remaining flour to form a stiff\n" +
                "dough.\n\nSTEP 2:\n\\n Turn dough onto a floured surface; knead until\n" +
                "smooth and elastic, about 6-8 minutes. Place in a greased bowl, turning\n" +
                "once to grease the top. Cover with plastic wrap and let rise in a warm\n" +
                "place until doubled, about 1 hour.\n\nSTEP 3:\n\n Preheat oven to 425°.\n" +
                "Grease a 13x9-in. baking pan. Punch down dough; divide into three portions.\n" +
                "On a lightly floured surface, combine two portions of dough and roll into a\n" +
                "15x11-in. rectangle. Transfer to prepared pan, pressing onto bottom and up\n" +
                "sides of pan. Top with 2 cups mozzarella cheese and 2 cups cheddar cheese.\n" +
                "Sprinkle with flour, seasonings, cooked sausage, mushrooms and\n" +
                "pepperoni.\n\nSTEP 4:\n\n Roll out remaining dough into a 13x9-in.\n" +
                "rectangle. Place dough over filling, crimping edges to seal; prick top with\n" +
                "a fork. Sprinkle with remaining cheeses. Bake on a lower oven rack 10\n" +
                "minutes.\n\nSTEP 5:\n\n Reduce oven setting to 375°. Spread pizza sauce\n" +
                "over cheese. Bake 30-35 minutes longer or until edges are lightly browned.\n" +
                "Let stand 10 minutes before cutting. If desired, sprinkle with Parmesan\n" +
                "cheese. Yield: 12 servings."));
        fs.create(new Produit("PIZZA BRUSCHETTA",3,R.mipmap.pizza3,"10 min","blalalalalalal","desc","kkjhk"));
        fs.create(new Produit("  BACON CHEESEBURGER",2,R.mipmap.pizza4,"40 min","azertyuiop","desc","kkjhk"));
        fs.create(new Produit("    PIZZA TOMATE FROMAGE.",5,R.mipmap.pizza5,"22 min","ljhkjhjk","desc","kkjhk"));
        fs.create(new Produit("PIZZA BRUSCHETTA ",4,R.mipmap.pizza6,"33 min","ljhkjhjk","desc","kkjhk"));
        fs.create(new Produit("PIZZA MARGHERITA",8,R.mipmap.pizza7,"1 h","ljhkjhjk","desc","kkjhk"));
        fs.create(new Produit(" PEPPERONI PIZZA "
                ,5,R.mipmap.pizza9,"33","ljhkjhjk","desc","kkjhk"));
        fs.create(new Produit(" MEXICAN PIZZA",5,R.mipmap.pizza8,"33","ljhkjhjk","desc","kkjhk"));

        liste.setAdapter(new PizzaAdapter(this, fs.findAll()));
        liste.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Produit produit = (Produit) parent.getItemAtPosition(position);

        Intent intent = new Intent(ListPizzaActivity.this, PizzaDetailActivity.class);
        intent.putExtra("PIZZA_ID", produit.getId());
        startActivity(intent);
    }
}