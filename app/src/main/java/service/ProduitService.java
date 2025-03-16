package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import classes.Produit;
import dao.IDao;

public class ProduitService implements IDao<Produit> {
    private List <Produit> produits;
    private static ProduitService instance;

    private ProduitService() {

        this.produits = new ArrayList<>();
    }

    public static ProduitService getInstance() {
        if(instance == null)
            instance =  new ProduitService();
        return instance;
    }

    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return  produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findById(int id) {
        for(Produit f : produits){
            if(f.getId() == id)
                return f;
        }
        return null;
    }
}
