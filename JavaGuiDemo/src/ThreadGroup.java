
public class ThreadGroup {
	public String ThreadGroupName;
	public int Vusers;
	public int RampUpTime;
	public int Duration;
	public int RampDownTime;
	
	ThreadGroup(String threadGroupName,int vusers,int rampUpTime,int duration,int rampDownTime)
	{
		this.ThreadGroupName=threadGroupName;
		this.Vusers=vusers;
		this.RampUpTime=rampUpTime;
		this.Duration=duration;
		this.RampDownTime=rampDownTime;
	}

}
