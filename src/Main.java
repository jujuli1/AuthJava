import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Users users = new Users();

        while (true) {

            // trykatch menu
            try {

                System.out.println(" Connexion réussie à la base de données !");
                System.out.println(" ========== Menu ========== ");
                System.out.println(" 1 - Supression d'un compte utilisateur en particulier ");
                System.out.println(" 2 - Création d'un compte utilisateur");
                System.out.println(" 3 - Voir tout les comptes utilisateur crée ");
                System.out.println(" 4 - Supression de tout les comptes utilisateurs ");
                int menu = scanner.nextInt();
                scanner.nextLine();// vide buffer

                switch (menu) {
                    case 1:

                        // Supprimme en fonction de l'Id
                        users.suppressionCiblee();

                        break;

                    case 2:

                        // inserer nouvel utilisateur dans la table

                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();

                        System.out.print("email : ");
                        String email = scanner.nextLine();

                        System.out.print("Mot de passe : ");
                        String pass = scanner.nextLine();

                        users.RecupInsert(nom, email, pass);

                        break;

                    case 3:

                        // afficher les tables enregistrée
                        users.DisplayTable();
                        break;

                    case 4:

                        // supression totale
                        System.out.print("Voulez vous supprimmer toute les tables ? (Y/N)");

                        String confirm = scanner.nextLine();

                        if (confirm.equalsIgnoreCase("Y") || confirm.equalsIgnoreCase("y")) {
                            users.suppTotal();

                        }

                        break;

                    default:
                        System.out.println("Choix invalide, essaie encore.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Erreur : " + e.getMessage());
                scanner.nextLine();
            }

        }

    }
}
