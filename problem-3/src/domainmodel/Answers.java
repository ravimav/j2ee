package domainmodel;

import java.util.Date;

public class Answers{
	private int id;
	private Users user;
	private Questions ques;
	private String text;
	private Date createdAt;
	
	/*public Answers(int id,Users user,Questions ques,String text,Date createdAt)
	{
		setId(id);
		setUser(user);
		setQues(ques);
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
	public void setQues(Questions ques)
	{
		this.ques=ques;
	}
	public Questions getQues()
	{
		return ques;
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

}