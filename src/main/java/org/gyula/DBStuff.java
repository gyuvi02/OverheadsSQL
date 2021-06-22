package org.gyula;

import java.sql.*;
import java.util.ArrayList;

public class DBStuff {

    private static Statement createStatement() {
        Statement statement = null;
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL + "user=" + Constants.DB_USERNAME + "&password=" + Constants.DB_PASSWORD);
//            Connection conn = DriverManager.getConnection("jdbc:mysql://overheads-aws2.chrz0ukqk6rw.eu-central-1.rds.amazonaws.com/Overheads?user=admin&password=Gyulus_72");
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Something went wrong, quitting");
        }
        return statement;
    }



    public static ArrayList<String> getFlatList() throws SQLException{
        ArrayList<String> flatList = new ArrayList<>();
//        ResultSet results = createStatement().executeQuery("select Cim from " + Constants.TABLE_LAKAS);
        ResultSet results = createStatement().executeQuery("SELECT * FROM " + Constants.TABLE_LAKAS);
        while (results.next()) {
            flatList.add(results.getString("Cim"));
        }
        createStatement().close();
        return flatList;
    }

    public static MonthlyData getDataForInvoice(String address) throws SQLException {
        ResultSet resultsLakas = createStatement().executeQuery(
                "SELECT DISTINCT l.Lako, l.LAKBER, l.KOZOSKOLTSEG, l.GAZALAPDIJ, l.VILLANYALAPDIJ, " +
                        "(SELECT s.DATUM FROM (SELECT Datum FROM A_Gazora ORDER BY datum DESC) as s limit 1) as GORAALLAS_DATUM," +
                        "(SELECT s.ORAALLAS FROM (SELECT ORAALLAS FROM A_Gazora ORDER BY datum DESC) as s limit 1) as REGI_GORAALLAS," +
                        "(SELECT s.datum FROM (SELECT DATUM FROM A_Villanyora ORDER BY datum DESC) as s limit 1) as VORAALLAS_DATUM," +
                        "(SELECT s.ORAALLAS FROM (SELECT oraallas FROM A_Villanyora ORDER BY datum DESC) as s limit 1) as REGI_VILLANYORAALLAS," +
                        "e.gaz_ar, e.villany_ar" +
                " FROM (SELECT * FROM " + Constants.TABLE_LAKAS + " WHERE CIM ='" + address + "'" + ")" + " l " +
                " JOIN " + Constants.TABLE_EGYSEGARAK + " e ON e.LAKASID = l.ID " +
                " JOIN " + Constants.TABLE_GAZORA + " g ON g.LAKASID = l.ID " +
                " JOIN " + Constants.TABLE_VILLANYORA + " v ON v.LAKASID = l.ID ");

        resultsLakas.next();

        MonthlyData md = new MonthlyData(address, resultsLakas.getString("LAKO"), resultsLakas.getDouble("LAKBER"),
                resultsLakas.getDouble("KOZOSKOLTSEG"), resultsLakas.getDouble("GAZALAPDIJ"),
                resultsLakas.getDouble("VILLANYALAPDIJ"), resultsLakas.getDouble("REGI_GORAALLAS"),
                resultsLakas.getDate("GORAALLAS_DATUM") ,
                resultsLakas.getDouble("REGI_VILLANYORAALLAS"),
                resultsLakas.getDate("VORAALLAS_DATUM"),
                resultsLakas.getDouble("GAZ_AR"),
                resultsLakas.getDouble("VILLANY_AR"));
        createStatement().close();
        return md;
    }
}
