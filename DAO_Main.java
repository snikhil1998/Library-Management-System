import java.sql.*;
import java.util.Scanner;

public class DAO_Main {
	public static void main(String[] args)
	{
		try
		{
			DAO_Factory daoFactory = new DAO_Factory();

			daoFactory.activateConnection();
			
			Scanner sc = new Scanner(System.in);
			
			while(true)
			{
				System.out.print("1) Add books to database.\n2) Add members to database.\n3) Exit.\nSelect an option: ");
				int option = sc.nextInt();
				
				if(option==1)
				{
					System.out.print("Enter the number of books to add: ");
					int num = sc.nextInt();
					BookDAO bdao = daoFactory.getBookDAO();
					for(int i=0;i<num;i++)
					{
						System.out.print("Book Id: ");
						int bid = sc.nextInt();
						System.out.print("Book Name: ");
						sc.nextLine();
						String name = sc.nextLine();
						System.out.print("Author: ");
		                String author = sc.nextLine();
						System.out.print("Publisher: ");
		                String publisher = sc.nextLine();
						System.out.print("Book Price: ");
		                float price = sc.nextFloat();
						System.out.print("Edition: ");
						sc.nextLine();
		                String edition = sc.nextLine();
						System.out.print("Total Book Count: ");
						int totalcount = sc.nextInt();
						
						//Book b = new Book(123456, "Fundamentals of Database Systems", "Ramez Elmasri", "Pearson", (float)171.84, "7th Edition", 24);
						Book b = new Book(bid, name, author, publisher, price, edition, totalcount);
						bdao.addBook(b);
						b = bdao.getBookById(b.getId());
						
						BookCopyDAO bcdao = daoFactory.getBookCopyDAO();
						bcdao.addBookCopy(b);
					}
				}
				else if(option==2)
				{
					System.out.print("Enter the number of members to add: ");
					int num = sc.nextInt();
					MemberDAO mdao = daoFactory.getMemberDAO();
					for(int i=0;i<num;i++)
					{
						System.out.print("Member Id: ");
						int mid = sc.nextInt();
						System.out.print("First Name: ");
						String fname = sc.next();
						System.out.print("Middle Name: ");
						char minit = sc.next().charAt(0);
						System.out.print("Last Name: ");
						String lname = sc.next();
						System.out.print("Member Type: ");
						String memberType = sc.next();
						System.out.print("Address: ");
						sc.nextLine();
						String addr = sc.nextLine();
						System.out.print("Pnone Number: ");
						String phoneno = sc.nextLine();
						
						//mdao.addMember(new Member(987123, "Nikhil", 'S', "Sairam", "Student", "Electronics City", "9876543210", 0, 3));
						Member m = new Member(mid, fname, minit, lname, memberType, addr, phoneno);
						m.setMaxIssuedCount();
						mdao.addMember(m);
					}
				}
				else if(option==3)
				{
					break;
				}
				else
				{
					System.out.println("Invalid input.");
				}
			}

			daoFactory.deactivateConnection();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}