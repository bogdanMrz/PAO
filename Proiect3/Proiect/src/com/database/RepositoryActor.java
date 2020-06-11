package com.database;

import com.Actor;
import com.Angajat;

import java.sql.*;
import java.util.ArrayList;

public class RepositoryActor {

    public static void insertActor(Actor actor) {
        String preparedSql = "INSERT INTO actori(nume,prenume,salariu,importanta)" +
                "VALUES(?,?,?,?);";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(preparedSql);
            cstmt.setString(1, actor.getNume());
            cstmt.setString(2, actor.getPrenume());
            cstmt.setInt(3, actor.getSalariu());
            cstmt.setByte(4, actor.getImportanta());


            cstmt.execute();
            //System.out.println("Added user with id:" + cstmt.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Actor getActorById(int id) {
        String selectSql = "SELECT * FROM actori WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            return mapToActor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteById(int id){
        String deleteSql = "DELETE FROM actori WHERE id=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            CallableStatement cstmt = databaseConnection.prepareCall(deleteSql);
            cstmt.setInt(1,id);

            cstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Actor> getActorByNume(String nume) {
        String selectSql = "SELECT * FROM actori WHERE nume=?;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);
            preparedStatement.setString(1, nume);

            ArrayList<Actor> actori = new ArrayList<Actor>();

            ResultSet resultSet = preparedStatement.executeQuery();

            Actor actor;

            while (true)
            {
                actor = mapToActor(resultSet);
                if (actor != null) {
                    actori.add(actor);
                }
                else {
                    break;
                }
            }
            return actori;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Actor>();
    }



    public static ArrayList<Actor> getActori() {
        String selectSql = "SELECT * FROM actori;";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        try {
            PreparedStatement preparedStatement = databaseConnection.prepareStatement(selectSql);

            ArrayList<Actor> actori = new ArrayList<Actor>();

            ResultSet resultSet = preparedStatement.executeQuery();

            Actor actor;

            while (true)
            {
                actor = mapToActor(resultSet);
                if (actor != null) {
                    actori.add(actor);
                }
                else {
                    break;
                }
            }
            return actori;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<Actor>();
    }


    public static void updateActorSalariu(int salariu, int id) {
        String updateNameSql = "UPDATE actori SET salariu=? WHERE id=?;";

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

    private static Actor mapToActor(ResultSet resultSet) throws SQLException {

        if (resultSet.next()){
            return new Actor( resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(4), resultSet.getByte(5));
        }
        return null;
    }
}
