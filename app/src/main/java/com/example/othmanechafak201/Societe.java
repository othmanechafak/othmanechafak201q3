package com.example.othmanechafak201;

public class Societe {
    int Id;
    String Nom;
    String Secteur;
    int Nbemploye;
    String raison_sociale;

    public Societe() {

    }

    public Societe(int id, String nom, String secteur, int nbemploye, String raison_sociale) {
        Id = id;
        Nom = nom;
        Secteur = secteur;
        Nbemploye = nbemploye;
        this.raison_sociale = raison_sociale;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getSecteur() {
        return Secteur;
    }

    public void setSecteur(String secteur) {
        Secteur = secteur;
    }

    public int getNbemploye() {
        return Nbemploye;
    }

    public void setNbemploye(int nbemploye) {
        Nbemploye = nbemploye;
    }

    public String getRaison_sociale() {
        return raison_sociale;
    }

    public void setRaison_sociale(String raison_sociale) {
        this.raison_sociale = raison_sociale;
    }
}
