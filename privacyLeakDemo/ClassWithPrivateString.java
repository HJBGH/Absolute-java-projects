package privacyLeakDemo;

public class ClassWithPrivateString {
	private String myString;
	
	ClassWithPrivateString(String string)
	{
		myString = string;
	}
	
	public String getMyString()
	{
		return myString;
	}
}
