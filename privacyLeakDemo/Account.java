package privacyLeakDemo;

public class Account {
	
	private Long dollars;
	private Long cents;
	private Person owner;
	
	public Long getDollars()
	{
		return dollars;
	}

	public Account(long dollars, long cents, Person owner)
	{
		this.dollars = new Long(dollars);
		this.cents = new Long(cents);
		this.owner = owner;
	}
	
	public Person getOwner()
	{
		return owner;
	}
}
