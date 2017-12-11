package chapter19projects;


//used with TimerAlarm, allows a class to register itself with a timer
public interface AlarmListener {
	
	public void alarmAction();
		//The alarm timer calls this method on the registered listener when it's time to do whatever
}
