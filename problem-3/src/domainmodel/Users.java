package domainmodel;

import java.util.Date;

public class Users{
	private int id;
	private String username;
	private String password;

/*	public Users(int id,String username,String password)
	{
		setId(id);
		setUsername(username);
		setPassword(password);
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
	
	public void setUsername(String username)
	{
		this.username=username;
	}
	public String getUsername()
	{
		return username;
	}
	public void setPassword(String password)
	{
		this.password=password;
	}
	public String getPassword()
	{
		return password;
	}

}