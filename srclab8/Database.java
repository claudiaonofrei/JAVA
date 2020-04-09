import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database single_instance=null;

    private Database(){}

    public static Database Database() {
        if (single_instance == null)
        {
            single_instance = new Database();
        }
        return single_instance;
    }

    public Connection getCon() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/musicalbums" ;
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, "dba", "sql");

        } catch(
                SQLException e) {
            System.err.println("Cannot connect to DB: " + e);
        }
        return con;
    }

}
