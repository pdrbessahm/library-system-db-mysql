package dao;

import model.Loans;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.ResultSet;



public class LoansDAO {

    public void createLoan(Loans loan) {
        String sql = "INSERT INTO loans (book_id, reader_id, loan_date, return_date) VALUES (?, ?, ?, ?)";

        try(Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setInt(1, loan.getBookLoanedId());
            stmt.setInt(2, loan.getReaderLoanedId());
            stmt.setDate(3, java.sql.Date.valueOf(loan.getLoanDate()));
            stmt.setDate(4, java.sql.Date.valueOf(loan.getLoanReturnDate()));

            stmt.executeUpdate();
            System.out.println("EMRPESTIMO CRIADO COM SUCESSO");

        } catch(SQLException e) {
            System.out.println("DEU ERRADO CRIAR O EMPRESTIMO");
            e.printStackTrace();
        }
    }

    public List<Loans> getAllLoans(Loans loan) {
        List loansList = new ArrayList<>();
        String sql = "SELECT * FROM loans";
        
        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()){
                Loans l = new Loans(                
                    rs.getInt("id"),
                    rs.getInt("book_id"),
                    rs.getInt("reader_id"),
                    rs.getDate("loan_date").toLocalDate(),
                    rs.getDate("return_date").toLocalDate()
                );
                
                loansList.add(l);
            }

        } catch (SQLException e) {
            System.err.println("DEU RUIM NA HORA DE LISTAR TODOS OS EMPRESTIMOS");
            e.printStackTrace();
        }
        return loansList;
    }

    public void updateLoan(Loans loan) {
        String sql = "UPDATE loans SET loan_date = ?, return_date = ?";


        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, java.sql.Date.valueOf(loan.getLoanDate()));
            stmt.setDate(2, java.sql.Date.valueOf(loan.getLoanReturnDate()));

            stmt.executeUpdate();
            System.out.println("DATAS ATUALIZADAS COM SUCESSO");
            
        } catch (SQLException e) {
            System.out.println("DEU ERRO NA HORA DE ATUALIZAR A DATA");
            e.printStackTrace();
        }


    }

    public void deleteLoan(int id) {
        String sql = "DELETE FROM loans WHERE id = ?";

        try (Connection conn = Database.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("DELETADO COM SUCESSO O EMPRESTIMO PAE");

        } catch (SQLException e) {
            System.out.println("DEU PRA DELETAR O EMPRESTIMO NAO");
            e.printStackTrace();
        }
    }
}
