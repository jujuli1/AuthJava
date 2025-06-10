import javax.swing.JFrame;
import javax.swing.JButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class pageConnectee extends JFrame{

    

    //Page de connection reussit 
    public pageConnectee() {

        setTitle(" Vous etes connectée");
        setSize(700, 600);
        

        //Comportement clic fermeture croix
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //centre la fenetre
        setLocationRelativeTo(null);
        setLayout(null);


        //label et champ de saisie
        //setBounds(x, y, width, height)
        JLabel nom = new JLabel("Vous etes connectée ! Bravo !");

        setVisible(true);// Affiche la fenetre a l'écran /!\
       
    }

     // démarrage application en appelant l'instance main
     public static void main(String[] args) {
        new pageConnectee();
    }
}
