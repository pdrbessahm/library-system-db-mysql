

import java.util.Scanner;
import model.Readers;
import dao.ReadersDAO;
import model.Authors;
import model.Loans;
import model.Books;
import dao.AuthorsDAO;
import dao.BooksDAO;
import dao.LoansDAO;


public class App {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while(isRunning){
            System.out.println("===============================");
            System.out.println("== LIBRARY MANAGEMENT SYSTEM ==");
            System.out.println("===============================");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Exit");
            System.out.println("===============================");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            boolean isLogged = false;

            if(option == 1) {

                System.out.print("Enter your full name: ");
                String name = scanner.nextLine();

                System.out.print("Enter you password (Letters Only): ");
                String password = scanner.nextLine();

                System.out.print("Confirm your password (Letters Only): ");
                String passwordConfirmation = scanner.nextLine();

                if(!password.equals(passwordConfirmation)){
                    System.out.println("Passwords do not match! Try again.");

                    //here im going to use continue because i want to keep the menu options running after the message
                    continue;
                } else {

                    //if passwords actually match we need to create a new object in order to storage this user information within the DB 
                    //a variable working as a drawer-like vessel
                    //here we are creating an object which we defined its methods previously 
                    Readers reader = new Readers(name, password);

                    //now we need to create an object responsible for communicating with DB
                    //its useful to take this as a warehouse manager
                    ReadersDAO readersDAO = new ReadersDAO();

                    //at this point we are in fact creating the data register information in the database
                    readersDAO.createReaders(reader);
                    System.out.println("User registered successfully!");
                    
                    //here im going to use continue because i want to keep the menu options running after register section is over
                    continue;

                }
              
            } else if(option == 2) {
                System.out.println("===============================");
                System.out.println("LOG IN WITH YOUR ACCOUNT");
                System.out.println("===============================");

                System.out.print("Enter your full name: ");
                String nameLogin = scanner.nextLine();

                System.out.print("Enter your password (Letters Only): ");
                String passwordLogin = scanner.nextLine();

                ReadersDAO readersDAO = new ReadersDAO();

                Readers readerLogin = readersDAO.validateLogin(nameLogin, passwordLogin);
            
                if (readerLogin != null) {
                    System.out.println("===================================");
                    System.out.println("Login process finished successfully");
                    isLogged = true;

                    while (isLogged) {
                        System.out.println("===============================");
                        System.out.println("== LIBRARY MANAGEMENT SYSTEM ==");
                        System.out.println("===============================");
                        System.out.println("1. Get a Loan");
                        System.out.println("2. View all Loans");
                        System.out.println("3. Update a Loan");
                        System.out.println("4. Delete a Loan");
                        System.out.println("5. Log out");
                        System.out.println("===============================");
                        System.out.print("Which option would you like to choose? ");
                        int optionTwo = scanner.nextInt();
                        scanner.nextLine();

                        switch(optionTwo) {
                            case 1 -> System.out.println("You got a loan!");
                            case 2 -> System.out.println("You viewed all loans");
                            case 3-> System.out.println("You viewed all loans");
                            case 4 -> System.out.println("You viewed all loans");
                            case 5 -> isLogged = false;
                            default -> System.out.println("Invalid option.");
                        }
                    }
                    
                } else {
                    System.out.println("User or passwords dont match.");
                    continue;
                }
            
            

            } else if(option == 3) {
                isRunning = false;
                System.out.println("See ya!");
            } else {
                System.out.println("Invalid option! Try again.");
                return;
            }
        }
//CRIAR UM IF CASE PARA SABER SE: O AUTOR EXISTE, SE ESTÁ VINCULADO A ALGUM LIVRO, IMPLEMENTAR UM SOFT DELETE = COLOCAR INATIVO
    }
}
