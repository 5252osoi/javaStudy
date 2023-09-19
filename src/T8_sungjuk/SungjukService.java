package T8_sungjuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungjukService {
	Scanner scanner = new Scanner(System.in);
	SungjukDAO dao = new SungjukDAO();
	SungjukVO vo = null;
	
	String ans="N";
	String name="";
	int no=0;
	//성적입력하기
	public void setInput() {
		vo = new SungjukVO();
		
		re:while(true) {
			System.out.println("\n**성적 입력처리 **");
			//동명이인 입력 안받을것임
			System.out.print("성명 : ");
			name=scanner.next();
			
			///////////////////동명의가 있는지 확인/////////////////////////
			vo=dao.getSearch(name);
			if(vo.getName()!=null) {
				System.out.println("같은 이름이 존재합니다. 다시 입력해주세요.");
				continue re;
			} 
			
			//////////////////////////////////////////////////////
			vo.setName(name);
			System.out.print("국어 : "); 	vo.setKor(scanner.nextInt());
			System.out.print("영어 : "); 	vo.setEng(scanner.nextInt());
			System.out.print("수학 : "); 	vo.setMat(scanner.nextInt());
			
//			동명이인 처리 (같은 성명자료는 입력하지 않는다.)
			int res=dao.setInput(vo);
			if(res==0)System.out.println("성적등록실패");
			else System.out.println("성적이 등록되었습니다.");
			System.out.print("한번 더 입력하시겠습니까? (y/n) => ");
			ans=scanner.next();
			if(ans.toUpperCase().equals("N"))break;
		}
	}
	
	// 전체목록 조회하기
	public void setList() {
		ArrayList<SungjukVO> vos = dao.getList();
		//전체목록 조회시 총점과 학점도 출력해야함**
		System.out.println("\n\t*** 성 적 리 스 트 ***");
		System.out.println("=".repeat(60));
		System.out.println("번호\t성명\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-".repeat(60));
		
		for(int i=0; i<vos.size(); i++) {
			vo=vos.get(i);
			calculator(vo);
			System.out.print(vo.getIdx() +"\t");
			System.out.print(vo.getName() +"\t");
			System.out.print(vo.getKor() +"\t");
			System.out.print(vo.getEng() +"\t");
			System.out.print(vo.getMat() +"\t");
			System.out.print(vo.getTot() +"\t");
			System.out.print(vo.getAvg() +"\t");
			System.out.print(vo.getGrade() +"\n");
		}
		
		System.out.println("-".repeat(60));
		System.out.println("\t\t\t\t\t총 인원수 : "+vos.size()+"명");
		System.out.println("=".repeat(60));
		
	}

	private void calculator(SungjukVO vo) {
		vo.setTot(vo.getKor()+vo.getEng()+vo.getMat());
		vo.setAvg((vo.getTot()/3.0));
		if(vo.getAvg()>=90) vo.setGrade('A');
		else if(vo.getAvg()>=80) vo.setGrade('B');
		else if(vo.getAvg()>=70) vo.setGrade('C');
		else if(vo.getAvg()>=60) vo.setGrade('D');
		else vo.setGrade('F');
	}

	public void setSearch() {
		while(true) {
			System.out.print("\n조회할 성명을 입력하세요 => ");
			name=scanner.next();
			
			vo=dao.getSearch(name);
			if(vo!=null) {
				calculator(vo);
				System.out.println("\n번호 : "+vo.getIdx());
				System.out.println("성명 : "+vo.getName());
				System.out.println("국어 : "+vo.getKor());
				System.out.println("영어 : "+vo.getEng());
				System.out.println("수학 : "+vo.getMat());
				System.out.println("총점 : "+vo.getTot());
				System.out.println("평균 : "+vo.getAvg());
				System.out.println("학점 : "+vo.getGrade());
			}
			else System.out.println("검색하신 "+name+" 님의 자료가 없습니다.");
			System.out.print("계속 검색하시겠습니까? (y/n) => ");
			ans=scanner.next();
			if(ans.toUpperCase().equals("N"))break;
		}
	}

	public void setUpdate() {
		System.out.print("\n점수를 수정할 학생의 성명을 입력하세요 => ");
		name=scanner.next();
		boolean run=true;
		while(run) {
			vo=dao.getSearch(name);
			if(vo.getName()==null) {
				System.out.println("\n"+name+"님은 학생이 아닙니다. . .");
				run=false;
			} else {
				System.out.println("-".repeat(40));
				System.out.println("이름 : " +vo.getName());
				System.out.println("국어 : " +vo.getKor());
				System.out.println("영어 : " +vo.getEng());
				System.out.println("수학 : " +vo.getMat());
				System.out.println("-".repeat(40));
			}
			System.out.println("점수를 수정 할 과목을 선택하세요");
			System.out.print("1>국어 2>영어 3>수학 4>나가기  => ");
			no=scanner.nextInt();
			
			int kor=vo.getKor(),eng=vo.getEng(),mat=vo.getMat();
			switch (no) {
				case 1:
					System.out.print("국어 점수 다시 입력 =>");
					kor=scanner.nextInt();
					break;
				case 2:
					System.out.print("영어 점수 다시 입력 =>");
					eng=scanner.nextInt();
					break;
				case 3:
					System.out.print("수학 점수 다시 입력 =>");
					mat=scanner.nextInt();
					break;
				default:
					run=false;
			}
			//점수수정메소드 불러오기
			int res=dao.setUpdate(name,kor,eng,mat);
			if(res==0)System.out.println("점수 수정에 실패했습니다.");
			else System.out.println("작업이 완료되었습니다.");
		}
	}

	public void setDelete() {
		System.out.print("자료를 삭제할 학생의 이름을 입력하세요 =>");
		name=scanner.next();
		
		//이름있는지 검색
		vo=dao.getSearch(name);
		if(vo.getName()==null) {
			System.out.println("\n"+name+"님은 학생이 아닙니다. . .");
		} else {
			//있는지 확인 후 삭제
			System.out.print("학생명 "+name+"님의 자료를 정말 삭제하시겠습니까? (y/n)");
			String yn=scanner.next();
			if(yn.toUpperCase().equals("Y")) {
				System.out.println(name+" 님의 자료가 삭제되었습니다.");
				dao.setDelete(name);
			}else {
				System.out.println("자료를 삭제 하지않고 작업 완료. . .");
			}
		}
	}
	
	
	
}
