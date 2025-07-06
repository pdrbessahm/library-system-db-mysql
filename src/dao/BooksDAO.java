package dao;

import model.Books;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class BooksDAO {
    public void createBooks(Books book) {
        String sql = "INSERT INTO books (title, author_id, available) VALUES (?, ?, ?)";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getBookTitle());
            stmt.setInt(2, book.getBookAuthor());
            stmt.setBoolean(3, book.getBookAvailable());

            stmt.executeUpdate();
            System.out.println("CREATE BOOK DEU CERTO");

        } catch(SQLException e) {
            System.out.println("CREATE BOOK NAO DEU CERTO");
            e.printStackTrace();
        }
    }

    public List<Books> getAllBooks(Books book){
        List booksList = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while(rs.next()) {
                Books b = new Books( 
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getInt("author_id"),
                    rs.getBoolean("available")
                );    

                booksList.add(b);
            }

        } catch(SQLException e) {
            System.out.println("DEU ERRO NA LISTAGEM DOS LIVROS PAE");
            e.printStackTrace();
        }
        return booksList;
    }

    public void updateBooks(Books book){
        String sql = "UPDATE books SET title = ?, author_id = ?, available = ? WHERE id = ?";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, book.getBookTitle());
            stmt.setInt(2, book.getBookAuthor());
            stmt.setBoolean(3, book.getBookAvailable());
            stmt.setInt(4, book.getBookId());

            stmt.executeUpdate();
            System.out.println("OS LIVRO FORAM ATUALIZADO COM SUCESSO PAE");

        } catch(SQLException e) {
            System.out.println("DEU RUIM NA HORA DE ATUALIZAR OS LIVRO");
            e.printStackTrace();
        }
    }
    
    public void deleteBooks(int id){
        String sql = "DELETE FROM books WHERE id = ?";
        
        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("LIVRO DELETADO COM SUCESSO PAE");

        } catch (Exception e) {
            System.out.println("DEU PRA DELETAR O LIVRO NAO");
            e.printStackTrace();
        }
    }
    
}
