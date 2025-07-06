package model;

public class Books {
    
    //atributes representing data to store in the system
    private int id;
    private String title;
    private int author;
    private boolean available;


    //constructors (overloaded)
    public Books() {}

    public Books(int id, String title, int author, boolean available){
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public Books(String title, int author, boolean available){
        this.title = title;
        this.author = author;
        this.available = available;
    }

    public Books(int author, boolean available){
        this.author = author;
        this.available = available;
    }

    public int getBookId(){ return id; }
    public int getBookAuthor(){ return author; }
    public String getBookTitle(){ return title; }
    public boolean getBookAvailable(){ return available; }

    public void setBookId(int id){ this.id = id; }
    public void setBookAuthor(int author){ this.author = author; }
    public void setBookTitle(String title){ this.title = title; }
    public void setBookAvailable(boolean available){ this.available = available; }

    @Override

    public String toString(){
        return "Book ID: " + id + 
            " | Author: " + author + 
            " | Title: " + title + 
            " | Available: " + available;
    }

}
