package me.playernguyen.opteco.sql;

import me.playernguyen.opteco.configuration.OptEcoConfiguration;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class SQLiteEstablish extends SQLEstablish {


    public SQLiteEstablish(String tableName, ArrayList<String> init) {
        super(tableName, init);
    }

    @Override
    public Connection openConnect() throws SQLException, ClassNotFoundException {
        setURL("jdbc:sqlite:" + buildUrl());
        // If null
        if (getURL() == null) {
            throw new NullPointerException("The url mustn't be null");
        }
        // Import class
        Class.forName("org.sqlite.JDBC");
        // Open connect
        getDebugger().info("['Connection::SQLite] Create the connection of SQLite");
        return DriverManager.getConnection(getURL());
    }

    /**
     * Get the table list
     *
     * @return table list
     */
    @Override
    public ArrayList<String> getTables() {
        ArrayList<String> temp = new ArrayList<>();
        try (Connection connection = this.openConnect()) {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("SELECT * FROM sqlite_master WHERE type='table' AND name not like 'sqlite_%'");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                temp.add(resultSet.getString("name"));
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return temp;
    }

    /**
     * Build the url for SQLite
     *
     * @return the url path
     */
    private String buildUrl() {

        return getPlugin().getDataFolder()
                + File.separator
                + getConfigurationLoader().getString(OptEcoConfiguration.SQLITE_FILE);
    }

}
