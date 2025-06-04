import java.util.Scanner;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;
import javax.swing.*;
import java.util.Arrays;


public class SignIn extends JFrame {

    Users users = new Users();

    public SignIn() {

        setTitle("Créer son compte ");
        setSize(350, 300);
        // comportement clic sur croix rouge
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ///
        setLocationRelativeTo(null);// centre la fenetre
        setLayout(null);

        // Label et champ de saisie nom, mail et password
        // setBounds(x, y, width, height)
        JLabel nom = new JLabel("Nom : ");
        nom.setBounds(30, 20, 80, 25);
        add(nom);

        JTextField nomField = new JTextField();
        nomField.setBounds(120, 20, 180, 25);
        add(nomField);

        JLabel email = new JLabel("Email : ");
        email.setBounds(30, 60, 80, 25);
        add(email);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 60, 180, 25);
        add(emailField);

        JLabel pass = new JLabel("Mot de passe : ");
        pass.setBounds(30, 100, 100, 25);
        add(pass);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 100, 180, 25);
        add(passField);

        JButton validated = new JButton("Creer mon compte");
        validated.setBounds(100, 150, 150, 30);
        add(validated);

        // convertion du mot de passe haché pour comparaison avec > 8
       

        //condition de validation
        

            // ecouteur bouton valider
        validated.addActionListener(e -> {
            String name = nomField.getText(); // prend texte nom
            String imail = emailField.getText();// prend texte mail
            String password = new String(passField.getPassword());// prend texte password
            String hachoir = BCrypt.hashpw(password, BCrypt.gensalt()); // hash du mot de passe

            // convertion du mot de passe haché pour comparaison avec > 8
            char[] passChars = passField.getPassword();

            //Convertion char[] en string avant validation
            String psswd = new String(passChars);

            String regex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$";

            //Verif match entre regex et psswd
            Boolean validPass = Pattern.matches(regex, psswd);

            
    
        

        //condition de validation
        if(nom != null && email != null && pass != null && nomField.getText().length() >= 8
        && emailField.getText().length() >= 8 
        && passChars.length >= 8 &&  validPass ){

            
            users.RecupInsert(name, imail, hachoir);


            
                
                
            
            LoggIn login = new LoggIn();
                        login.setVisible(true);

            // message de validation
            JOptionPane.showMessageDialog(this,
            "Compte créer avec succes ! \n\n\n" +
                    "Nom : " + nom + "\nEmail : " + email + "\n Hachoir : " + hachoir,
                    "Informations saisies",
                    JOptionPane.INFORMATION_MESSAGE);

                    //Eviter de garder le pass en clair /1
       Arrays.fill(passChars, ' ');
                    

        }else {

            
                
            if(!pass.getText().matches(regex)){
                JOptionPane.showMessageDialog(this,
            "Probleme d'authentification. Mot de passe invalide \n\n\n" +
                    "Nom : " + nom + "\nEmail : " + email + "\n pass : " + pass,
                    "Informations saisies",
                    JOptionPane.INFORMATION_MESSAGE);
            }

            JOptionPane.showMessageDialog(this,
            "Probleme d'authentification. Minimum 8 characteres \n\n\n" +
                    "Nom : " + nom + "\nEmail : " + email + "\n pass : " + pass,
                    "Informations saisies",
                    JOptionPane.INFORMATION_MESSAGE);

            System.out.println("probleme d'authentification. \n\n");

              //Eviter de garder le pass en clair /2
                Arrays.fill(passChars, ' ');
        }


        

        
        
    });

       
       

        

        

        setVisible(true);// Affiche la fenetre a l'écran /!\

    }

    // démarrage application en appelant l'instance main
    public static void main(String[] args) {
        new SignIn();
    }
}
