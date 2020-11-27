package br.edu.ifsp.arq.dsi.goliveiracod.factory;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private static ConnectionFactory connectionFactory;
    private final MariaDbDataSource mariaDbDataSource;

    private ConnectionFactory() {
        mariaDbDataSource =
                new MariaDbDataSource("jdbc:mariadb://localhost:3106/dsi_exape?user=root&password=123mudar");
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }

        return connectionFactory;
    }

    public Connection getConnection() {
        try {
            return mariaDbDataSource.getConnection();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
    }
}
