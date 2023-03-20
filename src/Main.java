import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library manger = new Library();
        Scanner input = new Scanner(System.in);

        int isbn, choice;
        String title, genre, author;

        out:
        while (true) {
            System.out.println("** Choose");
            System.out.println("1- Add a book");
            System.out.println("2- Remove a book");
            System.out.println("3- Borrow a book");
            System.out.println("4- Return a book");
            System.out.println("5- Print the books");
            System.out.println("6- Exit");
            choice = input.nextInt();
            input.nextLine();
            switch (choice)
            {
                case 1:
                    System.out.print("Book title: ");
                    title = input.nextLine();
                    System.out.print("Author: ");
                    author = input.nextLine();
                    System.out.print("Genre: ");
                    genre = input.nextLine();
                    System.out.print("ISBN: ");
                    isbn = input.nextInt();
                    manger.addBook(title,author,genre,isbn,true);
                    break;
                case 2:
                    System.out.println("ISBN: ");
                    isbn = input.nextInt();
                    manger.removeBook(isbn);
                    break;
                case 3:
                    System.out.println("ISBN: ");
                    isbn = input.nextInt();
                    manger.borrowBook(isbn);
                    break;
                case 4:
                    System.out.println("ISBN: ");
                    isbn = input.nextInt();
                    manger.returnBook(isbn);
                    break;
                case 5:
                    manger.listBooks();
                    break;
                case 6:
                    break out;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}