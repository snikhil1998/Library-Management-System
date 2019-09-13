import java.lang.*;

public class Member
{
	int mid;
	String fname;
	char minit;
	String lname;
	String memberType;
	String addr;
	String phoneno;
	int noofbooksissued;
	int maxissued;
	public Member(){}
	public Member(int mid, String fname, char minit, String lname, String memberType, String addr, String phoneno)
	{
		this.mid = mid;
		this.fname = fname;
		this.minit = minit;
		this.lname = lname;
		this.memberType = memberType;
		this.addr = addr;
		this.phoneno = phoneno;
		this.noofbooksissued = 0;
		this.maxissued = 2;
	}
    public void setId(int mid)
    {
        this.mid = mid;
    }
	public int getId()
	{
		return this.mid;
	}
	public void setFname(String fname)
	{
		this.fname = fname;
	}
	public String getFname()
	{
		return this.fname;
	}
    public void setMInit(char minit)
    {
        this.minit = minit;
    }
    public char getMInit()
    {
        return this.minit;
    }
	public void setLname(String lname)
	{
		this.lname = lname;
	}
	public String getLname()
	{
		return this.lname;
	}
    public void setMemberType(String memberType)
    {
        this.memberType = memberType;
    }
    public String getMemberType()
    {
        return this.memberType;
    }
	public void setAddr(String addr)
	{
		this.addr = addr;
	}
	public String getAddr()
	{
		return this.addr;
	}
	public void setPhoneNo(String phoneno)
	{
		this.phoneno = phoneno;
	}
	public String getPhoneNo()
	{
		return this.phoneno;
	}
	public void setBooksIssuedCount(int noofbooksissued)
	{
		this.noofbooksissued = noofbooksissued;
	}
	public int getBooksIssuedCount()
	{
		return this.noofbooksissued;
	}
	public void setMaxIssuedCount()
	{
		if(this.getMemberType().equals("Student"))
		{
			this.maxissued = 3;
		}
		else if(this.getMemberType().equals("Lecturer") || this.getMemberType().equals("Professor"))
		{
			this.maxissued = 4;
		}
		else
		{
			this.maxissued = 2;
		}
	}
	public int getMaxIssuedCount()
	{
		return this.maxissued;
	}
}