package fr.blois.siad.jee.tp2.beans;

import fr.blois.siad.jee.tp2.dto.Utilisateur;
import fr.blois.siad.jee.tp2.services.UtilisateurService;
import fr.blois.siad.jee.tp2.services.UtilisateurServiceBean;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class UtilisateursBean {
       
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})")
    private String email;
    
    @Size(min = 8, max = 32, message = "Le mot de passe doit être entre {min} et {max} caractères")
    private String motDePasse;
    
    @Size(min = 2, max = 32, message = "Le nom doit être entre {min} et {max} caractères" )
    private String nom;
    
    private static final long serialVersionUID = 1L;
    
    private int triCourant = 0;
    
    @EJB
    UtilisateurService utilisateurService;
    
    public UtilisateursBean() {
    }

    public List<Utilisateur> getUtilisateurs() {
        return utilisateurService.listerTous(triCourant);
    }
    
    public String getUtilisateursTrieID() {
        switch (triCourant) {
            case UtilisateurServiceBean.TRIIDASC:
                triCourant = UtilisateurServiceBean.TRIIDDESC;
                break;
            case UtilisateurServiceBean.TRIIDDESC:
                triCourant = UtilisateurServiceBean.TRIIDASC;
                break;
            default:
                triCourant = UtilisateurServiceBean.TRIIDASC;
                break;
        }
        return "index";
    }
    
    public String getUtilisateursTrieNom() {
        switch (triCourant) {
            case UtilisateurServiceBean.TRINOMASC:
                triCourant = UtilisateurServiceBean.TRINOMDESC;
                break;
            case UtilisateurServiceBean.TRINOMDESC:
                triCourant = UtilisateurServiceBean.TRINOMASC;
                break;
            default:
                triCourant = UtilisateurServiceBean.TRINOMASC;
                break;
        }
        return "index";
    }
    
    public String getUtilisateursTrieEmail() {
        switch (triCourant) {
            case UtilisateurServiceBean.TRIEMAILASC:
                triCourant = UtilisateurServiceBean.TRIEMAILDESC;
                break;
            case UtilisateurServiceBean.TRIEMAILDESC:
                triCourant = UtilisateurServiceBean.TRIEMAILASC;
                break;
            default:
                triCourant = UtilisateurServiceBean.TRIEMAILASC;
                break;
        }
        return "index";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {

    }

    public String checkAddUser() {

        // Validation
        FacesContext context = FacesContext.getCurrentInstance();
        if (email == null || email.isEmpty()) {
            context.addMessage(null, new FacesMessage("Email obligatoire"));
        }
        if (motDePasse == null || motDePasse.isEmpty()) {
            context.addMessage(null, new FacesMessage("MDP obligatoire"));
        }
        if (nom == null || nom.isEmpty()) {
            context.addMessage(null, new FacesMessage("Nom obligatoire"));
        }
        if (!context.getMessageList().isEmpty()) {
            return null;
        }

        // Cas nominal
        utilisateurService.ajouter(new Utilisateur(null, email, motDePasse, nom, new Date(), false));
        return "index";
    }
    
    public String supprimer(Integer id) {
        utilisateurService.supprimer(id);
        return "index";
    }
    
    public String bloquer(Integer id) {
        utilisateurService.bloquer(id);
        return "index";
    }
    
    public String debloquer(Integer id) {
        utilisateurService.debloquer(id);
        return "index";
    }
    
}
