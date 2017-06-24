package privacyLeakDemo;

public class Main {
	public static void main(String args[])
	{
		Account account = new Account(50, 40, new Person("John","Smith"));
		Person shouldNotHave = account.getOwner();
		System.out.println(shouldNotHave.getFullName()); //!!! should not have this.
		shouldNotHave.setName("Max", "Munstermann"); //!!! definitely shouldn't be able to do this!
		System.out.println(shouldNotHave.getFullName());
	}

}
