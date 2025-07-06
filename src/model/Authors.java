package model;

public class Authors {
    
    //creating private class
    private int id;
    private String name;
    private String nationality;


    public Authors() {}

    public Authors(int id, String name, String nationality){
        this.id = id;
        this.name = name;
        this.nationality = nationality;
    }

    //stabilishing methods
    public Authors(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
    }
    
    public int getId(){ return id; }
    public String getName(){ return name; }
    public String getNationality(){ return nationality; }

    public void setId(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setNationality(String nationality){ this.nationality = nationality; }

    //override
    @Override
    public String toString(){
        return "ID: " + id + 
            " | Name: " + name + 
            " | Nationality: " + nationality;
    }

}

