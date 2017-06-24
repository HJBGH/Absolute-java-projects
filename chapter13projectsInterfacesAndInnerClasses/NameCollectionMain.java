package chapter13projectsInterfacesAndInnerClasses;

import chapter13projectsInterfacesAndInnerClasses.NameCollection;

/**
 * "test" cases for the NameCollection class and its anonymous Enumeration implementing inner class.
 * @author hb
 *
 */
public class NameCollectionMain {
	public static void main(String[] FUCK)
	{
		String[] names = {"Billy","Bob","Bo","Jim","James"};
		NameCollection namenVersammlung = new NameCollection(names);
		Enumeration namenVersammlungEnumerator = namenVersammlung.getEnumeration();
		while(namenVersammlungEnumerator.hasNext())
		{
			System.out.println(namenVersammlungEnumerator.getNext());
		}
		System.out.println("------");
		String[] moreNames = {"Jill","Molly","Mary-Jane","Candy","Agatha", "Ingrid"};
		NameCollection nochEinNamenVersammlung = new NameCollection(moreNames);
		Enumeration nochEinVersammlungEnumerator = nochEinNamenVersammlung.getEnumeration();
		while(nochEinVersammlungEnumerator.hasNext())
		{
			System.out.println(nochEinVersammlungEnumerator.getNext());
		}
	}
}
