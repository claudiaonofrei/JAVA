<<<<<<< HEAD
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.Database();
        Connection connection = database.getCon();
        System.out.println(connection);

//        ArtistController artistController = new ArtistController(connection);
//        AlbumController albumController = new AlbumController(connection);
//
//        ResultSet rs1 = artistController.findByName("asd");
//        while (rs1.next()) {
//            String name = rs1.getString("name");
//            String country = rs1.getString("country");
//
//            System.out.println(name + " " + country);
//        }
//
//        ResultSet rs2 = albumController.findByArtist(1);
//        while (rs2.next()) {
//            String name = rs2.getString("name");
//            Integer rl_yr = rs2.getInt("release_year");
//
//            System.out.println(name + " " + rl_yr);
//        }
//
//        albumController.create("Blackbear", 1, 1923);
//        artistController.create("Russ", "America");
        ChartController chartController = new ChartController(connection);
        chartController.getRanked();

    }
=======
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database database = Database.Database();
        Connection connection = database.getCon();
        System.out.println(connection);

        ArtistController artistController = new ArtistController(connection);
        AlbumController albumController = new AlbumController(connection);

        ResultSet rs1 = artistController.findByName("asd");
        while (rs1.next()) {
            String name = rs1.getString("name");
            String country = rs1.getString("country");

            System.out.println(name + " " + country);
        }

        ResultSet rs2 = albumController.findByArtist(1);
        while (rs2.next()) {
            String name = rs2.getString("name");
            Integer rl_yr = rs2.getInt("release_year");

            System.out.println(name + " " + rl_yr);
        }

        albumController.create("Blackbear", 1, 1923);
        artistController.create("Russ", "America");

    }
>>>>>>> b54b5b1fc6bfcd0e721363e6b4b00d52ad1d36f9
}