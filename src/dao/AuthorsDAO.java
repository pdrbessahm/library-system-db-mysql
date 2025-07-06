package dao;

import model.Authors;
import java.sql.*;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



/*
 * just so in case i forget, i have to create CRUD system for every single feature within my app.
 * this happens bc every operation related to the DB can return a SQLException so we need to implement EVERY single thing 
 */

public class AuthorsDAO {
    
    public void createAuthor(Authors author) {
        String sql = "INSERT INTO authors (name, nationality) VALUES (?, ?)";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, author.getName());
            stmt.setString(2, author.getNationality());

            stmt.executeUpdate();
            System.out.println("CREATE DEU CERTO PAE");

        } catch (SQLException e) {
            System.out.println("CREATE DEU RUIM MENOR");
            e.printStackTrace();
        }
    }

    public List<Authors> getAllAuthors() {
        List authorList = new ArrayList<>();
        String sql = "SELECT * FROM authors";
        
        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                Authors a = new Authors(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("nationality")
                );
                authorList.add(a);
            }
        } catch (SQLException e) {
            System.out.println("BUSCAR OS AUTORES TUDO DEU ERRO PAE");
            e.printStackTrace();
        }
        return authorList;
    }

    public void updateAuthors(Authors author) {
        String sql = "UPDATE authors SET name = ?, nationality = ? WHERE id = ?";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, author.getName());
            stmt.setString(2, author.getNationality());
            stmt.setInt(3, author.getId());

            stmt.executeUpdate();

            System.out.println("DEU CERTO ATUALIZAR SIM");

        } catch(SQLException e) {
            System.out.println("DEU CERTO ATUALIZAR NAO PATRAO");
            e.printStackTrace();
        }
    }

    public void deleteAuthor(int id) {
        String sql = "DELETE FROM authors WHERE id = ?";
        
        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("DELETADO COM SUCESSO PAE");

        } catch(SQLException e) {   
            System.out.println("DELETAR DEU RUIM");
            e.printStackTrace();
        }
    }
}
