package informatique.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 30)
    private String libelle;

    @Column(length = 50)
    private Double prix;

    @OneToMany(mappedBy = "produit")
    private List<DetailCommande> detailCommandes;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }


    public List<DetailCommande> getCommandes() {
        return detailCommandes;
    }

    public void setCommandes(List<DetailCommande> commandes) {
        this.detailCommandes = commandes;
    }
}
