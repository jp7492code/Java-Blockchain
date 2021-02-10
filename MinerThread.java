public class MinerThread implements Runnable{
	
	public String threadName;
	
	public void run(){
		
		System.out.println(threadName + " has started!");
		
		Util oUtil = new Util();
		
		while(true){
			oUtil.sleepRandomTime(threadName);
			
			System.out.println(threadName + "just woke up.");
		}
	}
}
