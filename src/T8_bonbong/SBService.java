package T8_bonbong;

import java.util.ArrayList;
import java.util.Scanner;

/*
▶ 본봉테이블(bonbong)을 만든다. 필요한 필드로는, 직급(jikkub)필드와 본봉(bonbong)필드이다.
- 본봉테이블에 직급과 본봉을 '입력/수정/전체조회/삭제'할수있도록 만들어준다.
 */
public class SBService {
	Scanner scanner =new Scanner(System.in);
	SBDAO dao = new SBDAO();
	BonbongVO voB=null;
	SawonVO voS=null;
	
	int no;
	int res;
	
	public void BonbongService() {
		
		System.out.println("\n\t* * * 급 여 관 리 자 * * *");
		System.out.println("=".repeat(43));
		System.out.print("1> 입력  2> 수정  3> 전체조회  4> 삭제  0> 나가기 => ");
		no=scanner.nextInt();
		String jikkub="";
		
		switch (no) {
			case 1:
				System.out.println("** 직급,급여 입력 처리 **");
				
				//같은 직급 추가 불가처리 해야함
				System.out.print("직급 (직급의 이니셜 1단어) : " );
				jikkub=scanner.next().toUpperCase();
				
				///같은 이름의 직급있으면 걸러내기
				voB=dao.getSearchB(jikkub);
				if(voB.getJikkub()!=null) {
					System.out.println("이미 존재하는 직급입니다. \n* * 등록 실패 * *");
					return;
				}
				
				voB.setJikkub(jikkub);
				
				System.out.print("해당 직급( "+jikkub+" )의 급여 : "); voB.setBonbong(scanner.nextInt());
				res=dao.setInputB(voB);
				if(res==0)System.out.println("등록에 실패했습니다.");
				else System.out.println("정상적으로 등록을 완료했습니다.");
				
				break;
			case 2:
				//수정하려면 먼저 찾아야함
				System.out.print("수정하고자 하는 직급을 입력하세요 : ");
				jikkub=scanner.next().toUpperCase();
				voB=dao.getSearchB(jikkub);
				if(voB.getJikkub()==null) {
					System.out.println("\n "+jikkub+" 는 잘못된 직급 입니다. . .");
					break;
				} else {
					System.out.println("해당직급의 새 직급명 > ");
					String newJikkub=scanner.next();
					System.out.println(newJikkub+" 의 본봉 입력 > ");
					int bonbong=scanner.nextInt();
					
					res=dao.setUpdateB(jikkub,newJikkub,bonbong);
					if(res==0)System.out.println("직급의 수정에 실패했습니다.");
					else System.out.println("작업이 완료되었습니다.");
				}
				
				
				break;
			case 3:
				//직급표일람
				ArrayList<BonbongVO> vos = dao.getListB();
				System.out.println("\n\t * * 직 급 표 일 람 * * ");
				System.out.println("=".repeat(43));
				System.out.println("\t직급명\t\t   본봉");
				System.out.println("=".repeat(43));
				
				for(int i=0; i<vos.size(); i++){
					voB=vos.get(i);
					System.out.print("\t  "+voB.getJikkub()+"\t");
					System.out.print("\t"+voB.getBonbong()+"\n");
				}
				System.out.println("-".repeat(43));
				System.out.println("\t\t총 "+vos.size()+" 개의 직급이 있습니다.\n");

				break;
			case 4:
				//삭제
				System.out.println("삭제하고자 하는 직급을 입력하세요 : ");
				jikkub=scanner.next().toUpperCase();
				voB=dao.getSearchB(jikkub);
				if(voB.getJikkub()==null) {
					System.out.println("\n "+jikkub+" 는 잘못된 직급 입니다. . .");
					break;
				} else {
					res=dao.setDeleteB(jikkub);
					System.out.println("해당 직급을 삭제했습니다.");
				}
				
				break;

			default:
				//나가기
				break;
		}
		
		
		
	}
/*
 ▶ 사원테이블(sawon)을 만든다.  필요한 필드로는, 사번(sabun), 성명(name), 직급(jikkub), 야근시간(night) 필드이다.
사원테이블에 자료를 '입력/수정/삭제/전체조회/개별조회' 할 수 있도록 프로그래밍하시오.
자료 입력시는 직급코드를 '숫자 or 문자'로 받아서 DB에는 한글로 입력처리하시오.(예:S 는 '사원', D는 '대리', 'K'는 '과장', 'B'는 부장...등.... 직급은 더 넣어도 상관없음. 단 동일 직급은 있을수 없다. 또한 야근 시간을 입력받는다.
  :  야근수당은 야근시간당 25000원으로 한다.
  :  공제액 = (본봉 + 수당)의 10%로 한다.
  :  실수령액 = (본봉 + 수당 ) - 공제액
  
 출력내용중, '전체조회/개별조회'시, 각 사원의 '수당'과 '공제액'과 '실수령액'을 함께 출력하시오.
 */
	public void SawonService() {
		System.out.println("\n\t* * * 사 원 관 리 자 * * *");
		System.out.println("=".repeat(43));
		System.out.print("1>입력  2>수정  3>삭제  4>전체조회  5>개별조회  0>나가기 => ");
		no=scanner.nextInt();
		
		switch (no) {
			case 1://입력

				break;
			case 2://수정
				
				break;
			case 3://삭제
				
				break;
			case 4://전체조회
				ArrayList<SawonVO> vos = dao.getListS();
				System.out.println("\n\t * * 사 원 명 단 * * ");
				System.out.println("=".repeat(43));
				System.out.println("사번\t 이름\t 직급명\t 본봉\t 추가수당\t 공제액\t 실수령액");
				System.out.println("=".repeat(43));
				calc(voS);
				for(int i=0; i<vos.size(); i++){
					voS=vos.get(i);
					System.out.print(voS.getSabun()+"\n");
					System.out.print(voS.getName()+"\n");
					System.out.print(voS.getJikkub()+"\n");
					System.out.print(voS.getBonbong()+"\n");
					System.out.print(voS.getNight()+"\n");
					System.out.print(voS.getTax()+"\n");
					System.out.print(voS.getSalary()+"\n");
				}
				
				
				
				break;
			case 5://개별조회
				
				break;

			default:
				break;
		}
		
	}
	private void calc(SawonVO voS) {
		
	}

}
