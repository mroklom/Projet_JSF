package fr.blois.bdma.jee.projet.inscription.beans;

import fr.blois.bdma.jee.projet.inscription.dto.User;
import fr.blois.bdma.jee.projet.inscription.services.UserService;
import fr.blois.bdma.jee.projet.inscription.services.UserServiceBean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    
    @Pattern(regexp = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})")
    private String email;
    
    @Size(min = 8, max = 32, message = "Le mot de passe doit être entre {min} et {max} caractères")
    private String password;
    
    @Size(min = 2, max = 32, message = "Le nom doit être entre {min} et {max} caractères" )
    private String name;
    
    @Size(min = 8, max = 32, message = "Le mot de passe doit être entre {min} et {max} caractères")
    private String newPassword;
    
    @Size(min = 8, max = 32, message = "Le mot de passe doit être entre {min} et {max} caractères")
    private String newPasswordConfirmation;
    
    private User user;
    
    private static final long serialVersionUID = 1L;
    
    private int currentSorting = UserServiceBean.NOSORTING;
    
    @EJB
    UserService userService;

    public UserBean() {
    }
    
    public List<User> getUsers() {
        return userService.listAll(currentSorting);
    }
    
    public String getUsersIDSorting() {
        switch (currentSorting) {
            case UserServiceBean.IDASCSORT:
                currentSorting = UserServiceBean.IDDESCSORT;
                break;
            case UserServiceBean.IDDESCSORT:
                currentSorting = UserServiceBean.IDASCSORT;
                break;
            default:
                currentSorting = UserServiceBean.IDASCSORT;
                break;
        }
        return "index";
    }
    
    public String getUsersNameSorting() {
        switch (currentSorting) {
            case UserServiceBean.NAMEASCSORT:
                currentSorting = UserServiceBean.NAMEDESCSORT;
                break;
            case UserServiceBean.NAMEDESCSORT:
                currentSorting = UserServiceBean.NAMEASCSORT;
                break;
            default:
                currentSorting = UserServiceBean.NAMEASCSORT;
                break;
        }
        return "index";
    }
    
    public String getUsersEmailSorting() {
        switch (currentSorting) {
            case UserServiceBean.EMAILASCSORT:
                currentSorting = UserServiceBean.EMAILDESCSORT;
                break;
            case UserServiceBean.EMAILDESCSORT:
                currentSorting = UserServiceBean.EMAILASCSORT;
                break;
            default:
                currentSorting = UserServiceBean.EMAILASCSORT;
                break;
        }
        return "index";
    }
    
    public String checkAddUser() {
        //Validation
        FacesContext context = FacesContext.getCurrentInstance();
        if (email == null || email.isEmpty()) {
            context.addMessage(null, new FacesMessage("Email obligatoire"));
        }
        if (password == null || password.isEmpty()) {
            context.addMessage(null, new FacesMessage("MDP obligatoire"));
        }
        if (name == null || name.isEmpty()) {
            context.addMessage(null, new FacesMessage("Nom obligatoire"));
        }
        if (!context.getMessageList().isEmpty()) {
            return null;
        }
        
        // check if a user with the same name or email already exists
        List<User> utilisateurs = userService.listAll(currentSorting);
        
        for (User u : utilisateurs) {
            if(u.getEmail().equals(email)) {
                context.addMessage(null, new FacesMessage("Un utilisateur avec ce mail existe déjà"));
                return null;
            }
            if(u.getName().equals(name)) {
                context.addMessage(null, new FacesMessage("Un utilisateur avec ce nom existe déjà"));
                return null;
            }            
        }
        
        // if everything is ok
        userService.add(new User(null, email, password, name, new Date(), false));
        
        // reset these values so they not persit the next time a user is to be created
        name = null;
        email = null;
        password = null;
        
        return "index";
    }
    
    public String initChangePassword(User u) {
        //store the valu of the user who wants to change its password
        user = u;
        
        return "changePassword";
    }
    
    public String checkChangePassword() {
        // Validation
        FacesContext context = FacesContext.getCurrentInstance();
        if (newPassword == null || newPassword.isEmpty()) {
            context.addMessage(null, new FacesMessage("Nouveau mot de passe obligatoire"));
        }
        else if (newPasswordConfirmation == null || newPasswordConfirmation.isEmpty()) {
            context.addMessage(null, new FacesMessage("Confimation obligatoire"));
        }
        else if(!newPasswordConfirmation.equals(newPassword)) {
           context.addMessage(null, new FacesMessage("Les mots de passes sont différents !"));
        }
        if (!context.getMessageList().isEmpty()) {
            return null;
        }
        
        // if everything is ok
        userService.changePassword(user.getId(), newPassword);
        
        // reset these value so they not persit the next time a user wants to be change its password
        newPassword = null;
        newPasswordConfirmation = null;
        
        return "index";
    }
    
    public String removeUser(Integer id) {
        userService.remove(id);
        return "index";
    }
    
    public String lockUser(Integer id) {
        userService.lock(id);
        return "index";
    }
    
    public String unlockUser(Integer id) {
        userService.unlock(id);
        return "index";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getNewPasswordConfirmation() {
        return newPasswordConfirmation;
    }

    public void setNewPasswordConfirmation(String newPasswordConfirmation) {
        this.newPasswordConfirmation = newPasswordConfirmation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCurrentSorting() {
        return currentSorting;
    }

    public void setCurrentSorting(int currentSorting) {
        this.currentSorting = currentSorting;
    }
}
