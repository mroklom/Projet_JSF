/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.blois.siad.jee.tp2.beans;

import fr.blois.siad.jee.tp2.dto.Utilisateur;
import fr.blois.siad.jee.tp2.services.UtilisateurService;
import java.util.Calendar;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author valentin
 */
@Singleton
@Startup
public class RemplissageBDDBean {
    
    /*@EJB
    UtilisateurService utilisateurService;
    
    @PostConstruct
    public void init() {
        System.out.println("hello");
        
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        
        // add all the user in db
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "dylan.fleury@example.com", 
                "samuel1", 
                "Dylan Fleury", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "charline.nicolas@example.com", 
                "moon", 
                "Charline Nicolas", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "charlotte.caron@example.com", 
                "lance", 
                "Charotte Caron", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "leandro.phillipe@example.com", 
                "gobears", 
                "Léandro Phillipe", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "clara.Richard@example.com", 
                "eastern", 
                "Clara Richard", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "elena.garcia@example.com", 
                "magicman", 
                "Éléna Garcia", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "timothee.dasilva@example.com", 
                "456654", 
                "Timothée Da Silva", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "romane.roger@example.com", 
                "telephon", 
                "Romane Roger", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "sara.simon@example.com", 
                "1950", 
                "Sara Simon", 
                c.getTime()));
        
        c.add(Calendar.DATE, (int) (Math.random()*100 -50));
        utilisateurService.ajouter(new Utilisateur(
                null, 
                "ava.menard@example.com", 
                "chocolate", 
                "Ava Menard", 
                c.getTime()));        
    }*/
}
