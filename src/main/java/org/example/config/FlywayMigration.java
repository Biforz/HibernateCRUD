package org.example.config;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "user";
    private static final String PASSWORD = "123";

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource(URL, USER, PASSWORD)
                .locations("classpath:db/migration")
                .load();
        flyway.migrate();
    }
}
