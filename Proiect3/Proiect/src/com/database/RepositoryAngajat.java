package com.database;

import com.Angajat;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryAngajat {

    public static void insertAngajat(Angajat angajat) {
        String preparedSql = "INSERT INTO angajati(nume,prenume,salariu)" +
                "VALUES(?,?,?);";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, angajat.getNume());
            cstmt.setString(2, angajat.getPrenume());
            cstmt.setInt(3, angajat.getSalariu());


            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static Angajat getAngajatById(int id) {
        String selectSql = "SELECT * FROM angajati WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToAngajat(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Angajat> getAngajati() {
        String selectSql = "SELECT * FROM angajati;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);

            ArrayList<Angajat> angajati = new ArrayList<Angajat>();

            ResultSet resultSet = preparedStatement.executeQuery();

            Angajat ang;

            while (true)
            {
                ang = mapToAngajat(resultSet);
                if (ang != null) {
                    angajati.add(ang);
                }
                else {
                    break;
                }
            }
            return angajati;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Angajat>();
    }

    public static ArrayList<Angajat> getAngajatiByName(String nume) {
        String selectSql = "SELECT * FROM angajati WHERE nume=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, nume);

            ArrayList<Angajat> angajati = new ArrayList<Angajat>();

            ResultSet resultSet = preparedStatement.executeQuery();

            Angajat ang;

            while (true)
            {
                ang = mapToAngajat(resultSet);
                if (ang != null) {
                    angajati.add(ang);
                }
                else {
                    break;
                }
            }
            return angajati;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Angajat>();
    }



    public static void deleteById(int id){
        String deleteSql = "DELETE FROM angajati WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(deleteSql);
            cstmt.setInt(1,id);

            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateAngajatNume(String nume, int id) {
        String updateNameSql = "UPDATE angajati SET nume=? WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, nume);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAngajatSalariu(int salariu, int id) {
        String updateNameSql = "UPDATE angajati SET salariu=? WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setInt(1, salariu);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public static void updateAngajatPreme(String prenume, int id) {
        String updateNameSql = "UPDATE angajati SET prenume=? WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(updateNameSql);
            preparedStatement.setString(1, prenume);
            preparedStatement.setInt(2, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


        private static Angajat mapToAngajat(ResultSet resultSet) throws SQLException {

        if (resultSet.next()){
            return new Angajat( resultSet.getString(2), resultSet.getString(3),resultSet.getInt(4));
        }
        return null;
    }

}
