package com.database;

import com.Actor;
import com.Personaj;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryPersonaj {

    public static void insertPersonaj(Personaj personaj) {
        String preparedSql = "INSERT INTO personaje(nume,prenume,varsta)" +
                "VALUES(?,?,?);";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, personaj.getNume());
            cstmt.setString(2, personaj.getPrenume());
            cstmt.setShort(3, personaj.getVarsta());


            cstmt.execute();
            //System.out.println("Added user with id:" + cstmt.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Personaj getPersonajById(int id) {
        String selectSql = "SELECT * FROM personaje WHERE id=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToPersonaj(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }





    public static ArrayList<Personaj> getPersonajeByName(String nume) {
        String selectSql = "SELECT * FROM personaje WHERE nume=?";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, nume);

            ArrayList<Personaj> personaje = new ArrayList<Personaj>();

            ResultSet resultSet = preparedStatement.executeQuery();

            Personaj personaj;

            while (true)
            {
                personaj = mapToPersonaj(resultSet);
                if (personaj != null) {
                    personaje.add(personaj);
                }
                else {
                    break;
                }
            }
            return personaje;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Personaj>();
    }



    public static ArrayList<Personaj> getPersonaje() {
        String selectSql = "SELECT * FROM personaje;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            ArrayList<Personaj> personaje = new ArrayList<Personaj>();
            ResultSet resultSet = preparedStatement.executeQuery();

            Personaj personaj;

            while (true)
            {
                personaj = mapToPersonaj(resultSet);
                if (personaj != null) {
                    personaje.add(personaj);
                }
                else {
                    break;
                }
            }
            return personaje;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Personaj>();
    }



    public static void deleteById(int id){
        String deleteSql = "DELETE FROM personaje WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(deleteSql);
            cstmt.setInt(1,id);

            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void updatePersonajPrenume(String prenume, int id) {
        String updateNameSql = "UPDATE personaje SET prenume=? WHERE id=?";

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

    private static Personaj mapToPersonaj(ResultSet resultSet) throws SQLException {

        if (resultSet.next()){
            return new Personaj( resultSet.getString(2), resultSet.getString(3), resultSet.getShort(4));
        }
        return null;
    }


}
