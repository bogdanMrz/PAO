package com.database;

import com.Angajat;
import com.Incasari;

import java.sql.*;

public class RepositoryIncasari {

    public static void insertIncasari(Incasari incasari, String titluFilm) {
        String preparedSql = "INSERT INTO incasari(cinema, stream, drepturi_autor, publicitate, id) " +
                "VALUES(?,?,?,?,?);";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(5, titluFilm);

            cstmt.setInt(1, incasari.getCinema());
            cstmt.setInt(2, incasari.getStream());
            cstmt.setInt(3, incasari.getDrepturiAutor());
            cstmt.setInt(4, incasari.getPulicitate());

            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static Incasari getIncasariById(String id) {
        String selectSql = "SELECT * FROM incasari WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToIncasari(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Incasari mapToIncasari(ResultSet resultSet) throws SQLException {

        if (resultSet.next()){
            return new Incasari( resultSet.getInt(2), resultSet.getInt(3),
                    resultSet.getInt(4),resultSet.getInt(5));
        }
        return null;
    }


    public static void updateCinema(int cinema, String id) {
        String updateNameSql = "UPDATE incasari SET cinema=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, cinema);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void updateStream(int stream, String id) {
        String updateNameSql = "UPDATE incasari SET stream=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, stream);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void updateDrepturiAutor(int drepturiAutor, String id) {
        String updateNameSql = "UPDATE incasari SET drepturi_autor=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, drepturiAutor);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void updatePublicitate(int publicitate, String id) {
        String updateNameSql = "UPDATE incasari SET publicitate=? WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, publicitate);
            preparedStatement.setString(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public static void deleteById(int id){
        String deleteSql = "DELETE FROM incasari WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(deleteSql);
            cstmt.setInt(1,id);

            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}




