package swingEX01;

import java.time.LocalDateTime;

public class Test3_ThreadSleep {
	
	
	
	
	public static void main(String[] args) {
		while(true) {
			System.out.println("현재시간 : " + LocalDateTime.now());
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {}
			
		}
		
	}
}
