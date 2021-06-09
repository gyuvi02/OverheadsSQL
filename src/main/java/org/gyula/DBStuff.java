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
        ResultSet resultsLakas = createStatement().executeQuery("select * from " + Constants.TABLE_LAKAS + " WHERE CIM = " + address);
        MonthlyData md = new MonthlyData(address, resultsLakas.getString("LAKO"), resultsLakas.getString("LAKBER"), resultsLakas.getString("KOZOSKOLTSEG"),
                resultsLakas.getString("GAZALAPDIJ"), resultsLakas.getString("VILLANYALAPDIJ"), 0.1,);
        createStatement().close();
        return md;
    }
}
