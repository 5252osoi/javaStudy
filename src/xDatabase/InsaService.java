package xDatabase;

import java.util.Calendar;

public class InsaService {
	InsaVO vo=null;
	
	//오늘날짜 구하기
	public InsaVO getDefaultDate() {
		vo=new InsaVO();
		Calendar cal=Calendar.getInstance();

		vo.setStryy(cal.get(Calendar.YEAR)+"");
		vo.setStrmm(cal.get(Calendar.MONTH)+1+"");
		vo.setStrdd(cal.get(Calendar.DATE)+"");
		
		return vo;
	}
}
