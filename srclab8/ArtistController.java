<<<<<<< HEAD
import java.sql.*;

public class ArtistController {
    Connection conn;
    Statement stmt=null;

    ArtistController (Connection con) {
        this.conn = con;
    }

    public void create(String name, String country)throws SQLException{
        try {
            Statement stmt = conn.createStatement();
            String sql = "insert into `artists` (name, country)\n" +
                    "values (\"" + name + "\",\"" + country +"\")";
            stmt.executeUpdate(sql);

        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (conn != null) conn.close() ;
        }

    }
    public ResultSet findByName(String name)throws SQLException{
        ResultSet rs = null;

        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from `artists` where name = \"" + name + "\"";
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            System.err.println("Cannot connect to DB: " + e);
        }
        return rs;

    }
}
=======
import java.sql.*;

public class ArtistController {
    Connection conn;
    Statement stmt=null;

    ArtistController (Connection con) {
        this.conn = con;
    }

    public void create(String name, String country)throws SQLException{
        try {
            Statement stmt = conn.createStatement();
            String sql = "insert into `artists` (name, country)\n" +
                    "values (\"" + name + "\",\"" + country +"\")";
            stmt.executeUpdate(sql);

        } catch(SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        } finally {
            if (conn != null) conn.close() ;
        }

    }
    public ResultSet findByName(String name)throws SQLException{
        ResultSet rs = null;

        try{
            Statement stmt = conn.createStatement();
            String sql = "select * from `artists` where name = \"" + name + "\"";
            rs = stmt.executeQuery(sql);
        }catch (SQLException e){
            System.err.println("Cannot connect to DB: " + e);
        }
        return rs;

    }
}
>>>>>>> b54b5b1fc6bfcd0e721363e6b4b00d52ad1d36f9
