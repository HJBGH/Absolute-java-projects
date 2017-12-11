package chapter19projects;

public class TimerAlarm extends Thread{
	
	private Boolean play = true;
	private int t = 0;
	private AlarmListener obj;
	
	public TimerAlarm(int t)
	{
		this.t = t;
	}
	
	public void registerListener(AlarmListener newObj)
	{
		this.obj = newObj;
	}
	
	public void pause()
	{
		play = false;
	}

	public void play()
	{
		play = true;
	}
	
	public void run()
	{
		while(play)
		{
			try {
				this.sleep(t);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("FFFFFFFFFFFFUUUUUUUUUUCCCCCCCCCCCCKKKKKKKKK");
			}
			obj.alarmAction();
		}
	}
}
