package chapter19projects;

public class NineteenTest {

	private static TestImplements test; 
	public static void main(String args[])
	{
		NineteenTest damnitJava = new NineteenTest();
		test = damnitJava.new TestImplements();
		TimerAlarm ta = new TimerAlarm(1000);
		ta.registerListener(test);
		ta.run();
	}
	
	//this is such a shit name for a class
	public class TestImplements implements AlarmListener
	{
		private int sum = 0;

		@Override
		public void alarmAction() {
			System.out.println(sum);
			sum++;
		}
		
	}
}
