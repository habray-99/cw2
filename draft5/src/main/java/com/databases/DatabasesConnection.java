/**
 * The DatabasesConnection class establishes a connection to a MySQL database using credentials
 * provided in the DatabasesCredentials class.
 */
package com.databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * this call the credentials and puts them in respective values
 * passes the credentials
 * it failed to make connection then shows error
 * returns the val of con
 */

public class DatabasesConnection {

    public Connection getConnection() {
        Connection con = null;
        try {
            /*
             * DriverManager.getConnection( port on which it is open,
             * 								username,
             * 								password )
             */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DatabasesCredentials.getDbName(), DatabasesCredentials.getDbUser(), DatabasesCredentials.getDbPassword());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return con;
    }

}
