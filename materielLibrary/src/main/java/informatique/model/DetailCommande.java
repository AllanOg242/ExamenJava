package informatique.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetailCommande implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="produit_id")
    private Produit produit;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST})
    @JoinColumn(name="bon_id", nullable=false)
    private Commande commande;

    public DetailCommande() {
    }

    public DetailCommande(int qte, Produit produit, Commande bon) {
        this.produit = produit;
        this.commande = bon;
    }

    public void setState(DetailCommande d) {
        this.produit = d.produit;
        this.commande = d.commande;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getBon() {
        return commande;
    }

    public void setBon(Commande bon) {
        this.commande = bon;
    }
}
