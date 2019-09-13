import java.lang.*;

public class BookCopy
{
	int ebid;
	String copyid;
	boolean status;
	float price;
	public BookCopy(){}
	public BookCopy(int ebid, String copyid)
	{
		this.ebid = ebid;
		this.copyid = copyid;
		this.status = true;
	}
    public void setId(int ebid)
    {
        this.ebid = ebid;
    }
	public int getId()
	{
		return this.ebid;
	}
	public void setCopyId(int totalcount)
	{
		this.copyid = Integer.toString(this.ebid)+"-"+Integer.toString(totalcount);
	}
	public String getCopyId()
	{
		return this.copyid;
	}
	public void setStatus(boolean status)
	{
		this.status = status;
	}
	public boolean getStatus()
	{
		return this.status;
	}
}