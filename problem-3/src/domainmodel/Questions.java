package domainmodel;

import java.util.Date;

public class Questions{
	private int id;
	private Users user;
	private String text;
	private Date createdAt;

	/*public Questions(int id,Users user,String text,Date createdAt)
	{
		setId(id);
		setUser(user);
		setText(text);
		setCreatedAt(new Date());
	}
	*/
	
	public void setId(int id)
	{
		this.id=id;
	}
	public int getId()
	{
		return id;
	}
	public void setUser(Users user)
	{
		this.user=user;
	}
	public Users getUser()
	{
		return user;
	}
	public void setText(String text)
	{
		this.text=text;
	}
	public String getText()
	{
		return text;
	}
	public void setCreatedAt(Date createdAt)
	{
		this.createdAt=createdAt;
	}
	public Date getCreatedAt()
	{
		return createdAt;
	}
	public String toString()
	{
		return this.getUser().getUsername();
	}	
}