package org.gyula;

import java.sql.*;
import java.util.ArrayList;

public class DBStuff {

    private static Statement createStatement() {
        Statement statement = null;
        try {
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Something went wrong, quitting");
        }
        return statement;
    }

    public static ArrayList<String> getFlatList() throws SQLException{
        ArrayList<String> flatList = new ArrayList<>();
        ResultSet results = createStatement().executeQuery("select CIM from " + Constants.TABLE_LAKAS);
        while (results.next()) {
            flatList.add(results.getString("CIM"));
        }
        createStatement().close();
        return flatList;
    }

    public static MonthlyData getDataForInvoice(String address) throws SQLException {
        ResultSet resultsLakas = createStatement().executeQuery(
                "SELECT DISTINCT l.LAKO, l.LAKBER, l.KOZOSKOLTSEG, l.GAZALAPDIJ, l.VILLANYALAPDIJ, " +
                        "(SELECT DATUM FROM (SELECT g.DATUM FROM A_GAZORA g ORDER BY g.datum DESC) WHERE ROWNUM <= 1) AS \"GORAALLAS_DATUM\", " +
                        "(SELECT ORAALLAS FROM (SELECT g.ORAALLAS FROM A_GAZORA g ORDER BY g.datum DESC) WHERE ROWNUM <= 1) AS \"REGI_GORAALLAS\", " +
                        "(SELECT datum FROM (SELECT v.DATUM FROM A_VILLANYORA v ORDER BY v.datum DESC) WHERE ROWNUM <= 1) AS \"VORAALLAS_DATUM\"," +
                        "(SELECT ORAALLAS FROM (SELECT v.oraallas FROM A_VILLANYORA v ORDER BY v.datum DESC) WHERE ROWNUM <= 1) AS \"REGI_VILLANYORAALLAS\", " +
                        "e.GAZ_AR, e.VILLANY_AR" +
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
