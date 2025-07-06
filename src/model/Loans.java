package model;

import java.time.LocalDate;


public class Loans {
    
    private int id;
    private int bookId;
    private int readerId;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Loans() {}

    public Loans(int id, int bookId, int readerId, LocalDate loanDate, LocalDate returnDate){
        this.id = id;
        this.bookId = bookId;
        this.readerId = readerId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loans(int bookId, int readerId, LocalDate loanDate, LocalDate returnDate){
        this.bookId = bookId;
        this.readerId = readerId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public Loans(int readerId, LocalDate loanDate, LocalDate returnDate){
        this.readerId = readerId;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public int getLoanId(){ return id; }
    public int getBookLoanedId(){ return bookId; }
    public int getReaderLoanedId(){ return readerId; }
    public LocalDate getLoanDate(){ return loanDate; }
    public LocalDate getLoanReturnDate(){ return returnDate; }

    public void setLoanId(int id){ this.id = id; }
    public void setBookLoanedId(int bookId){ this.bookId = bookId; }
    public void setReaderLoanedId(int readerId){ this.readerId = readerId; }
    public void setLoanDate(LocalDate loanDate){ this.loanDate = loanDate; }
    public void setLoanReturnDate(LocalDate returnDate){ this.returnDate = returnDate; }

    @Override
    public String toString(){
        return "Loan ID: " + id + 
            " | Book ID: " + bookId + 
            " | Reader ID: " + readerId + 
            " | Loan Date: " + loanDate + 
            " | Return Date: " + returnDate;
    }

}
