import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books_list = new ArrayList<Book>();

    private final boolean AVAILABLE = true;
    private final boolean NOT_AVAILABLE = false;

    public void addBook(String title, String author, String genre, int isbn, boolean isAvailable){
        boolean flag = true;

        for (int i = 0; i < books_list.size(); i++) {
            if (books_list.get(i).getIsbn() == isbn){
                System.out.println("This isbn is already exist!");
                flag = false;
                break;
            }
        }
        if (flag) {
            books_list.add(new Book(title, author, genre, isbn, isAvailable));
            System.out.println("Book successfully added.");
        }

    }

    public void removeBook(int isbn){
        for (int i = 0; i < books_list.size(); i++) {
            if (books_list.get(i).getIsbn()==isbn){
                books_list.remove(i);
                System.out.println("Book successfully removed.");
                break;
            }
        }
    }

    public void borrowBook(int isbn){
        boolean flag = true;
        for (int i = 0; i < books_list.size(); i++) {
            if (books_list.get(i).getIsbn() == isbn){
                if (books_list.get(i).isAvailable()){
                    books_list.get(i).setAvailable(NOT_AVAILABLE);
                    System.out.println("Book successfully borrowed.");
                    flag = false;
                    break;
                }
            }
        }
        if (flag){
            System.out.println("The book is not exist or it is already borrowed.");
        }
    }
    public void returnBook(int isbn){
        boolean flag = true;
        for (int i = 0; i < books_list.size(); i++) {
            if (books_list.get(i).getIsbn() == isbn){
                if (! books_list.get(i).isAvailable()){
                    books_list.get(i).setAvailable(AVAILABLE);
                    System.out.println("Book successfully returned.");
                    flag = false;
                }
                break;
            }
        }
        if (flag){
            System.out.println("Error..");
        }
    }

    public void listBooks(){
        for (Book book : books_list) {
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Book title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthor());
            System.out.println("Genre: " + book.getGenre());
            System.out.println("Is available: " + book.isAvailable());
            System.out.println("*************");
        }
    }
}