package adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza_application.PizzaDetailActivity;
import com.example.pizza_application.R;

import java.util.List;

import classes.Produit;

public class PizzaAdapter extends BaseAdapter {
    private List<Produit> produits;
    private LayoutInflater inflater;
    private Context context; // Contexte de l'activité

    public PizzaAdapter(Activity activity, List<Produit> produits) {
        this.produits = produits;
        this.context = activity; // Initialiser le contexte
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return produits.size();
    }

    @Override
    public Object getItem(int position) {
        return produits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position + 1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = inflater.inflate(R.layout.item, null);

        TextView idf = convertView.findViewById(R.id.id);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView nbrIngredients = convertView.findViewById(R.id.nbrIngredients);
        ImageView photo = convertView.findViewById(R.id.image);
        ImageView detailsIcon = convertView.findViewById(R.id.imageDatails); // Image "details"

        Produit produit = produits.get(position);

        idf.setText(String.valueOf(produit.getId()));
        nom.setText(produit.getNom());
        duree.setText(produit.getDuree());
        nbrIngredients.setText(String.valueOf(produit.getNbrIngredClients()));
        photo.setImageResource(produit.getPhoto());

        // Gérer le clic sur l'image "details"
        detailsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Créer un Intent pour rediriger vers PizzaDetailActivity
                Intent intent = new Intent(context, PizzaDetailActivity.class);

                // Passer les données du produit à PizzaDetailActivity
                intent.putExtra("PRODUIT_NOM", produit.getNom());
                intent.putExtra("PRODUIT_DESCRIPTION", produit.getDescription());
                intent.putExtra("PRODUIT_DETAIL_INGRED", produit.getDetailIngred());
                intent.putExtra("PRODUIT_PREPARATION", produit.getPreparation());
                intent.putExtra("PRODUIT_IMAGE", produit.getPhoto()); // Passer l'ID de l'image

                // Démarrer l'activité
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}