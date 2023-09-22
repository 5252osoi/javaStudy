package swingEX01;

import java.time.LocalDateTime;

public class Test3_ThreadSleep2 {
	
	
	
	
	public static void main(String[] args) {
		System.out.println("현재시간 : " + LocalDateTime.now());
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		System.out.println("3 초 딜레이 : "+LocalDateTime.now());
		
	}
}
