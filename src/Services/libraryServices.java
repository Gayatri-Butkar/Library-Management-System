package Services;

import model.Book;
import model.Member;
import java.util.List;
import java.util.ArrayList;

public class libraryServices {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private int bookIdCounter = 1;
    private int memberIdCounter = 1;




//Books 
public void addBook(String title, String author)
{
    books.add(new Book(bookIdCounter++,title,author));
    System.out.println("Books added successfully");
}

public void viewAllBooks()
{
    if(books.isEmpty())
    {
        System.out.println("No Books Available");
        return;
    }
    books.forEach(System.out::println);
}

// Members 
public void addMember(String name)
{
    members.add(new Member(memberIdCounter++ , name));
    System.out.println("Member Registered");
}

public void viewAllMembers()
 {
    if(members.isEmpty())
    {
        System.out.println("No Members Registered");
        return;
    }
        members.forEach(System.out::println);
 }

    //--Borrow/Return

    public void borrowBook(int memberId,int bookId)
    {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

        if (member == null)
        {
            System.out.println("Member not found");
            return;
        }
        if(book == null)
        {
            System.out.println("Book not found");
            return;
        }
        if(!book.isAvailable())
        {
            System.out.println("Book is already Borrowed");
        }

        book.setAvailable(false);
        member.borrowBook(book);
        System.out.println(member.getName() +"borrowed "+book.getTitle());

    }


    public void returnBook(int memberId,int bookId)
    {
        Member member = findMember(memberId);
        Book book = findBook(bookId);

       if (member == null)
        {
            System.out.println("Member not found");
            return;
        }
        if(book == null)
        {
            System.out.println("Book not found");
            return;
        }

        book.setAvailable(true);
        member.returnBook(book);
        System.out.println(member.getName()+"returned" +book.getTitle());

    }

    private Book findBook(int id)
    {
       return books.stream().filter(b -> b.getId() == id).findFirst().orElse(null);
    }
  private Member findMember(int id)
    {
       return members.stream().filter(m -> m.getId() == id).findFirst().orElse(null);
    }
}