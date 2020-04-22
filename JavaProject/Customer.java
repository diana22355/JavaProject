
public class Customer 
{
	private String user;
	private String phone;
	private String email;
	private String licenseNumber;
	private String formatPhone;
	
public Customer(String name)
{
	user = name;
}
public void setPhone(String phoneNumber)
{
	phone = phoneNumber;
	StringBuilder phoneformat = new StringBuilder(phone);
	phoneformat.insert(0, "(");
	phoneformat.insert(4, ")");
	phoneformat.insert(8, "-");
	formatPhone = phoneformat.toString();
}
public void setEmail(String e)
{
 email = e;	
}

public String sendName()
{
	return user;
}

public String getPhone()
{
	return formatPhone;
}
public void setLicenseNumber(String ln)
{
	licenseNumber=ln;
}
public String getLicenseNumber()
{
	return licenseNumber;
}
public String getEmail()
{
	return email;
}

}
