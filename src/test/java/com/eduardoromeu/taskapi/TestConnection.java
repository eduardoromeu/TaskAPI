package com.eduardoromeu.taskapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bd_mvc?createDatabaseIfNotExist=true";
        String user = "root";
        String password = "root";

        System.out.println("Tentando conectar ao banco de dados...");

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            if (conn != null) {
                System.out.println("✅ Conexão estabelecida com sucesso!");
            } else {
                System.out.println("⚠️ Conexão retornou nula.");
            }
        } catch (SQLException e) {
            System.out.println("❌ Falha na conexão:");
            e.printStackTrace();
        }
    }
}
