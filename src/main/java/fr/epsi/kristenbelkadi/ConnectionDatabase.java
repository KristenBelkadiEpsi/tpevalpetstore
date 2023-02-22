package fr.epsi.kristenbelkadi;

import org.h2.tools.Server;

import java.sql.SQLException;

public class ConnectionDatabase {
    public static void main(String[] args) {
        try {
            Server.createWebServer("-web", "-webAllowOthers", "-webPort", "9090")
                    .start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
