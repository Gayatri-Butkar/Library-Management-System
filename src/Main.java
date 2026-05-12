import Services.libraryServices;
import java.util.Scanner;
public class Main {
    static Scanner sc = new Scanner(System.in);
    static libraryServices library = new libraryServices();

    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("\n =======Library Menu===========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Book");
            System.out.println("3. Register Member");
            System.out.println("4. View All Members");
            System.out.println("5. Borrow Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.println("Choice: ");
          
         int choice = sc.nextInt();
         sc.nextLine();

         switch(choice)
         {
            case 1:
            {
             System.out.println("Title");
             String title = sc.nextLine();
             System.out.println("Author :");
             String author = sc.nextLine();
             library.addBook(title,author);


            }
            case 2:
                {
                    library.viewAllBooks();
                }
            case 3:
            {
                System.out.println("Add member Name :");
                library.addMember(sc.nextLine());

            }   
            case 4:
                {
                    library.viewAllMembers();
                
                }
                
           case 5 :
            {
                System.out.println("Member Id :");
                int mid = sc.nextInt();
                System.out.println("BookId :");
                int bid = sc.nextInt();

            }     

            case 6:
                {
                    System.out.println("Member Id: ");
                    int mid = sc.nextInt();
                    System.out.println("Book Id: ");
                    int bid = sc.nextInt();
                    library.returnBook(mid,bid);

                }

            case 0:
                {
                    System.out.println("Goodbye!");

                }   
            default:
                {
                    System.out.println("Invalid Choice");
                }     
         }
        }
    }
}
