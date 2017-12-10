package fr.blois.siad.jee.tp2.dto;

import java.io.Serializable;
import java.util.Date;

public class Utilisateur implements Serializable {

    private Integer id;
    private String email;
    private String motDePasse;
    private String nom;
    private Date dateInscription;
    private boolean bloque;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String email, String motDePasse, String nom, Date dateInscription) {
        this.id = id;
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
        this.dateInscription = dateInscription;
        this.bloque = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", email=" + email + ", motDePasse=" + motDePasse + ", nom=" + nom + ", dateInscription=" + dateInscription + ", bloque=" + bloque + '}';
    }
}
