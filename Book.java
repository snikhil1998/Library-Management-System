import java.lang.*;

public class Book
{
	int bid;
	String name;
	String author;
	String publisher;
	float price;
	String edition;
	int totalcount;
	int availablecount;
	public Book(){}
	public Book(int bid, String name, String author, String publisher, float price, String edition, int totalcount)
	{
		this.bid = bid;
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.edition = edition;
		this.totalcount = totalcount;
		this.availablecount = totalcount;
	}
    public void setId(int bid)
    {
        this.bid = bid;
    }
	public int getId()
	{
		return this.bid;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
    public void setAuthor(String author)
    {
        this.author = author;
    }
    public String getAuthor()
    {
        return this.author;
    }
    public void setPublisher(String publisher)
    {
        this.publisher = publisher;
    }
    public String getPublisher()
    {
        return this.publisher;
    }
    public void setPrice(float price)
    {
        this.price = price;
    }
    public float getPrice()
    {
        return this.price;
    }
	public void setEdition(String edition)
	{
		this.edition = edition;
	}
	public String getEdition()
	{
		return this.edition;
	}
	public void setTotalCount(int totalcount)
	{
		this.totalcount = totalcount;
	}
	public int getTotalCount()
	{
		return this.totalcount;
	}
	public void setAvailableCount(int availablecount)
	{
		this.availablecount = availablecount;
	}
	public int getAvailableCount()
	{
		return this.availablecount;
	}
}