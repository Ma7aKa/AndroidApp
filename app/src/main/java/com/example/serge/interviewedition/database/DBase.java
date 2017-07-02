package com.example.serge.interviewedition.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBase
{
    private static DBase base = null;
    private static Connection connection = null;
    private final static String DBASE_CONNECTIVITY = "jdbc:mysql://local:3306/prekes";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    private DBase()
    {
        if (!connectToDatabase())
            System.out.println("faaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaalse");
    }

    public static DBase getInstance()
    {
        if (base == null)
            base = new DBase();
        return base;
    }

    private boolean connectToDatabase()
    {
        boolean isSuccess = true;

        connection = null;
        try
        {
            Class.forName( "com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DBASE_CONNECTIVITY,USERNAME,PASSWORD);
        } catch (SQLException e)
        {
            isSuccess = false;
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    public Statement createStatement()
    {
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    public Connection getConnection()
    {
        return connection;
    }
}
