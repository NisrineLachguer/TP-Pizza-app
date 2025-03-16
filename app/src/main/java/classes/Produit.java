package classes;

public class Produit {
    private int id;
    private String nom;
    private int nbrIngredClients;
    private int photo;
    private String duree;
    private String detailIngred;
    private String description;
    private String preparation;
    private static int comp;

    public Produit() {
    }

    public Produit(String nom, int nbrIngredClients, int photo, String duree, String detailIngred, String description, String preparation) {
        this.id = comp++;
        this.nom = nom;
        this.nbrIngredClients = nbrIngredClients;
        this.photo = photo;
        this.duree = duree;
        this.detailIngred = detailIngred;
        this.description = description;
        this.preparation = preparation;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getNbrIngredClients() {
        return nbrIngredClients;
    }

    public int getPhoto() {
        return photo;
    }

    public String getDuree() {
        return duree;
    }

    public String getDetailIngred() {
        return detailIngred;
    }

    public String getDescription() {
        return description;
    }

    public String getPreparation() {
        return preparation;
    }

    public static int getComp() {
        return comp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNbrIngredClients(int nbrIngredClients) {
        this.nbrIngredClients = nbrIngredClients;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setDetailIngred(String detailIngred) {
        this.detailIngred = detailIngred;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public static void setComp(int comp) {
        Produit.comp = comp;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrIngredClients=" + nbrIngredClients +
                ", photo=" + photo +
                ", duree='" + duree + '\'' +
                ", detailIngred='" + detailIngred + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}