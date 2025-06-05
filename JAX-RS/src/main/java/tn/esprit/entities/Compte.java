package tn.esprit.entities;

public class Compte {

    private int id;
    private String prop;
    private double solde;

    public Compte () {}
    public Compte (int id, String prop, double solde) {
        this.id = id;
        this.prop = prop;
        this.solde = solde;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getProprietaire() { return prop; }
    public void setProprietaire (String prop) { this.prop = prop ; }
    public double getSolde() { return solde; }
    public void setSolde (double solde) { this.solde = solde; }

}