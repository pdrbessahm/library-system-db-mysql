package dao;

import model.Readers;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class ReadersDAO {

    public void createReaders(Readers reader){
        String sql = "INSERT INTO readers (name, password) VALUES (?, ?)";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, reader.getName());
            stmt.setString(2, reader.getPassword());

            stmt.executeUpdate();

            System.out.println("USER CADASTRADO COM SUCESSO PAE");

        } catch (SQLException e) {
            System.out.println("DEU RUIM PRA CADASTRAR ELE");
            e.printStackTrace();
        }
    }

    public List<Readers> getAllReaders(Readers reader){
        List<Readers> readerList = new ArrayList<>();
        String sql = "SELECT * FROM readers";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()) {
                Readers r = new Readers(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("password")
                );
                readerList.add(r);
            }

        } catch (SQLException e) {
            System.out.println("DEU CERTO MOSTRAR GERAL NAO");
            e.printStackTrace();
        }
        return readerList;
    }

    //after running some tests, i noticed that would be better if were created a method just to validate login and password

    public Readers validateLogin(String name, String password) {
        String sql = "SELECT * FROM readers WHERE name = ? AND password = ?";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, name);
            stmt.setString(2, password);
            
            //this needs to be declared outside try-with-resources parenthesis because otherwise the stmt parameters wont be settled up before its execution
            //thus returning a parameterIndex error
            //actually we are probably going to use this AFTER stmt parameters most of the time
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Readers(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password")
                );
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateReaders(Readers reader){
        String sql = "UPDATE readers SET name = ?, password = ? WHERE id = ? ";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, reader.getName());
            stmt.setString(2, reader.getPassword());

            stmt.executeUpdate();
            System.out.println("ATUALIZOU D BOA VEY");


        } catch (SQLException e) {
            System.out.println("DEU ERRADO ATUALIZAR VEY");
            e.printStackTrace();
        }
    }

    public void deleteReaders(int id){
        String sql = "DELETE FROM readers WHERE id = ?";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("DELETADO COM SUCESSOOOOOOOOOO");

        } catch (SQLException e) {
            System.out.println("DEU RUIM DELETAR PAE");
            e.printStackTrace();
        }

    }

}
