import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.SQLException;

public class Users {

    private String url = "jdbc:mysql://localhost:3306/mabase"; // base "mabase"
    private String user = "root"; // ton utilisateur MySQL
    private String password = "10ficila2vin&"; // ton mot de passe

    Scanner scanner = new Scanner(System.in);

    // recup info nouvel utilisateur pour insert dans la table
    public void RecupInsert(String nom, String email, String hachoir) {

        // requêtes sql
        String sql = "insert into julien (nom, email, pass) values (?, ?, ?)";

        try

        (Connection conn = DriverManager.getConnection(url, user, password);
                // anti injection sql (précompilation part le moteur sql)
                PreparedStatement stmt = conn.prepareStatement(sql);) {

            stmt.setString(1, nom);
            stmt.setString(2, email);
            stmt.setString(3, hachoir);

            int row = stmt.executeUpdate();
            System.out.println(row + "Utilisateur ajouté avec success a la table de donnée");

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
            e.printStackTrace();
        }

    }

    // supression colonne de la table
    public void suppressionCiblee() {

        System.out.print("Entrez l'ID à supprimer : ");
        int IdSupp = scanner.nextInt();

        // requêtes sql
        String sqlSupp = "delete from julien where id = ?;";

        try (Connection conn = DriverManager.getConnection(url, user, password);
                PreparedStatement stmt = conn.prepareStatement(sqlSupp)) {

            stmt.setInt(1, IdSupp);

            int IdAffected = stmt.executeUpdate();
            if (IdAffected > 0) {
                System.out.println("✅ L'utilisateur avec l'id " + IdSupp + " a été supprimé.");
            } else {
                System.out.println(" Il n'y as aucun utilisateur avec l'id  " + IdSupp);
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // affiche les tables des users
    public void DisplayTable() {

        try {

            Connection conn2 = DriverManager.getConnection(url, user, password);

            Statement stmtCreate = conn2.createStatement();
            ResultSet rs = stmtCreate.executeQuery("select * from julien");

            while (rs.next()) {
                System.out.println("ID : " + rs.getInt("ID"));
                System.out.println("nom : " + rs.getString("nom"));
                System.out.println("mail : " + rs.getString("email"));
                System.out.println("mot de passe : " + rs.getString("pass"));
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        // affichage du contenue de la table julien

    }

    // supprimme toutes les tables
    public void suppTotal() {

        // requêtes sql
        String sqlSuppAll = "delete from julien ;";

        try (Connection connSupAll = DriverManager.getConnection(url, user, password);
                Statement stmtSuppAll = connSupAll.createStatement()) {

            stmtSuppAll.executeUpdate(sqlSuppAll);
            System.out.println("Les tables ont été vidées ");

        } catch (Exception e) {
            System.out.println(" Rien à supprimmer ...");
        }

    }

    // Compare email pour identifiant de connection du LoggIn
    public User compareMail(String email) {

        try (
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mabase", "root",
                        "10ficila2vin&");
                PreparedStatement stmt = conn.prepareStatement("select * from julien where email = ?")) {

            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String nom = rs.getString("nom");
                String mail = rs.getString("email");
                String hachoir = rs.getString("pass");
                return new User(nom, mail, hachoir);
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void main(String[] args) {

    }

}
