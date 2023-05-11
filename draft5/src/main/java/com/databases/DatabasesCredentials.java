package com.databases;

/* this is the right protocol to store the connection details of db and made final to make it unchangeable form outside medium
 */

public class DatabasesCredentials {

    private static final String DB_Name = "chothings";
    private static final String DB_User = "root";
    private static final String DB_Password = "";

    public static String getDbName() {
        return DB_Name;
    }

    public static String getDbUser() {
        return DB_User;
    }

    public static String getDbPassword() {
        return DB_Password;
    }


}
