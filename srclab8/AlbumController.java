<<<<<<< HEAD
import java.sql.*;

public class AlbumController {
    Connection conn;
    Statement stmt=null;

    AlbumController(Connection con) {
        this.conn = con;
    }

    public void create(String name, int artistId, int releaseYear)throws SQLException{
        try {

            Statement stmt = conn.createStatement();
            String sql = "insert into `albums` (name, artist_id, release_year)\n" +
                    "values (\"" + name + "\"," + artistId + "," + releaseYear + ")";
            stmt.executeUpdate(sql);

        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }

    public ResultSet findByArtist(int artistId)throws SQLException{
        ResultSet rs = null;

        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from `albums` where `artist_id` = " + artistId;
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            System.err.println("Cannot connect to DB: " + e);
        }
        return rs;

    }

}
=======
import java.sql.*;

public class AlbumController {
    Connection conn;
    Statement stmt=null;

    AlbumController(Connection con) {
        this.conn = con;
    }

    public void create(String name, int artistId, int releaseYear)throws SQLException{
        try {

            Statement stmt = conn.createStatement();
            String sql = "insert into `albums` (name, artist_id, release_year)\n" +
                    "values (\"" + name + "\"," + artistId + "," + releaseYear + ")";
            stmt.executeUpdate(sql);

        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
    }

    public ResultSet findByArtist(int artistId)throws SQLException{
        ResultSet rs = null;

        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from `albums` where `artist_id` = " + artistId;
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            System.err.println("Cannot connect to DB: " + e);
        }
        return rs;

    }

}
>>>>>>> b54b5b1fc6bfcd0e721363e6b4b00d52ad1d36f9
