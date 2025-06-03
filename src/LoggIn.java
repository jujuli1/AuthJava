import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import org.mindrot.jbcrypt.BCrypt;

public class LoggIn extends JFrame {

    Users users = new Users();
    

    public LoggIn() {

        setTitle("Se connecter ");
        setSize(350, 300);

        // comportement clic sur croix rouge
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // centre la fenêtre
        setLocationRelativeTo(null);
        setLayout(null);

        // Label et champ de saisie nom, mail et password
        // setBounds(x, y, width, height)
        // comparer dans compareMail() avec rs.getString()
        JLabel nom = new JLabel("Nom : ");// label
        nom.setBounds(30, 20, 80, 25);
        add(nom);

        JTextField nomField = new JTextField();// champ de saisie
        nomField.setBounds(120, 20, 180, 25);
        add(nomField);

        JLabel email = new JLabel(" Mail : ");
        email.setBounds(30, 60, 80, 25);
        add(email);

        JTextField emailField = new JTextField();
        emailField.setBounds(120, 60, 180, 25);
        add(emailField);

        JLabel pass = new JLabel(" Mot de passe : ");
        pass.setBounds(30, 100, 100, 25);
        add(pass);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(120, 100, 180, 25);
        add(passField);

        JButton validated = new JButton("Se connecter");
        validated.setBounds(100, 150, 150, 30);
        add(validated);

        validated.addActionListener(e -> {
            String name = nomField.getText();// prendre le texte du champ du nom
            String imail = emailField.getText();
            String password = new String(passField.getPassword());

            Users UserBdd = new Users();
            User user = UserBdd.compareMail(imail);

            if (user != null && name.equals(user.nom) && imail != null && imail.equals(user.email)
                    && BCrypt.checkpw(password, user.hachoir)) {

                // message de validation
                JOptionPane.showMessageDialog(this,
                        "Vous voila connecté avec success ",
                        "Connecté !",
                        JOptionPane.INFORMATION_MESSAGE);
                        pageConnectee page = new pageConnectee();
                        page.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this,
                        "Email ou mot de passe incorrect",
                        "Erreur",
                        JOptionPane.ERROR_MESSAGE);
            }

        });

        setVisible(true);// Affiche la fenetre a l'écran /!\
        
    }

    // démarrage application en appelant l'instance main
    public static void main(String[] args) {
        new LoggIn();
    }

}
