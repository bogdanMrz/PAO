package com.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class initData {
    public static void initAngajati(){
    String createTableSql = "CREATE TABLE IF NOT EXISTS angajati" +
            "(id INT PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
            "prenume varchar(30), salariu INT UNSIGNED)";

    Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
    RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
        repositoryHelper.executeSql(databaseConnection, createTableSql);
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

    public static void addAngajati() {


        String insertPersonSql = "INSERT INTO angajati (nume, prenume, salariu) VALUES "; //VALUES('', 20)";


        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        String selectSql = "SELECT * FROM angajati";

        try {

            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);

            if(resultSet.next() == false) {
                List<String> values = List.of("('Quentin', 'Tarantino', 70000)", "('Jeff', 'Richard', 200)",
                        "('Jones', 'Andrew', 500)", "('Henderson', 'Liam', 0)", "('LaRoche', 'Xavier', 0)");
                for (String value : values) {
                    try {
                        repositoryHelper.executeUpdateSql(databaseConnection, insertPersonSql + value + ";");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void displayAngajati() {
        String selectSql = "SELECT * FROM angajati";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            ResultSet resultSet = repositoryHelper.executeQuerySql(databaseConnection, selectSql);
            while (resultSet.next()) {
                System.out.println("Id:" + resultSet.getString(1));
                System.out.println("Nume:" + resultSet.getString(2));
                System.out.println("Prenume:" + resultSet.getString(3));
                System.out.println("Salariu:" + resultSet.getInt(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void initActori(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS actori" +
                "(id INT PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                "prenume varchar(30), salariu INT UNSIGNED, " +
                "importanta TINYINT)";

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void initIncasari(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS incasari" +
                "( id VARCHAR(30) PRIMARY KEY, cinema INT, stream INT, drepturi_autor INT, publicitate INT)";
        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void initPersonaje(){
        String createTableSql = "CREATE TABLE IF NOT EXISTS personaje" +
                "(id INT PRIMARY KEY AUTO_INCREMENT, nume varchar(30)," +
                "prenume varchar(30), varsta SMALLINT)" ;

        Connection databaseConnection = DatabaseConfiguration.getDatabaseConnection();
        RepositoryHelper repositoryHelper = RepositoryHelper.getRepositoryHelper();

        try {
            repositoryHelper.executeSql(databaseConnection, createTableSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void dropTables(){
        RepositoryHelper r = RepositoryHelper.getRepositoryHelper();

        for (String table: new String[]{"incasari", "actori", "personaje", "angajati"}) {
            String preparedSql = "DROP TABLE ";
            try {
                r.executeSql(DatabaseConfiguration.getDatabaseConnection(), "DROP TABLE "+table+";");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }

}
