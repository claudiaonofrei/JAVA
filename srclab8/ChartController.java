import java.sql.*;

public class ChartController {
    Connection conn;
    Statement stmt=null;

    ChartController (Connection con) {
        this.conn = con;
    }

    public void getRanked() throws SQLException{
        ResultSet rs2 = null;

        try{
            Statement stmt = conn.createStatement();
            String sql = "SELECT c.chart_id, ar.name FROM chart c " +
                    "join chart_album_map ca on c.chart_id = ca.chart_id " +
                    "join albums a on a.id = ca.album_id " +
                    "join artists ar on ar.id = a.artist_id " +
                    "order by c.chart_id, ar.name";
            rs2 = stmt.executeQuery(sql);

            String name = null;
            Integer chartId = -1;
            int contor = 1;

            while (rs2.next()) {
                name = rs2.getString("name");


                if (chartId != rs2.getInt("chart_id")) {
                    chartId = rs2.getInt("chart_id");
                    System.out.println("Showing rank for chart: " + chartId);
                    contor = 1;
                }
                System.out.println("\t" + name + " on position " + contor);
                contor += 1;
            }
        }catch (SQLException e){
            System.err.println("Cannot connect to DB: " + e);
        }
    }
}
