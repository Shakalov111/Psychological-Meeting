package com.di;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class PsychologistModule extends AbstractModule {
    @Inject
    protected void configure() {
        // Прив'язка іменованої константи без власних залежностей
        bindConstant()
        .annotatedWith(Names.named("Name"))
        .to("Polina");


        // альтернативний варіант прив'язки іменованої константи
        bindConstant()
            .annotatedWith(Names.named("Cost"))
            .to(2000.00);

        bind(String.class)
        .annotatedWith(Names.named("JDBC URL"))
        .toInstance("jdbc:sqlite:target/payroll.db");
    }
    // @Override
    // // protected void configure(){   bind(String.class)
    // //     .annotatedWith(Names.named("JDBC URL"))
    // //     .toInstance("jdbc:sqlite:target/payroll.db");}
 

    @Provides
    @Singleton
    Connection provideConnection(@Named("JDBC URL") String url) {
        try {
            Connection connection = DriverManager.getConnection(url);
            createTableIfNotExists(connection);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create database connection", e);
        }
    }

    /**
     * Створює таблицю "paychecks" у базі даних, якщо вона ще не існує.
     * Таблиця містить такі колонки:
     * - amount: значення типу REAL, яке не може бути null, що представляє суму виплати.
     * - pay_date: значення типу TEXT, яке не може бути null, що представляє дату виплати.
     *
     * @param connection з'єднання з базою даних, яке використовується для створення таблиці
     * @throws RuntimeException у разі виникнення помилки під час створення таблиці
     */
    private void createTableIfNotExists(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS paychecks (" +
                                "amount REAL NOT NULL, " +
                                "pay_date TEXT NOT NULL)";

        try (Statement statement = connection.createStatement()) {
            statement.execute(createTableSQL);
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create table", e);
        }
    }

}