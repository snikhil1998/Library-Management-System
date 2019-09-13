import java.lang.*;
import java.util.List;

public interface BookDAO
{
	public Book getBookById(int id);
	public void addBook(Book book);
}