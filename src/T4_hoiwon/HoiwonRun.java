package T4_hoiwon;

import java.util.ArrayList;
import java.util.Scanner;

public class HoiwonRun {
	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		HoiwonDAO dao =new HoiwonDAO();
		HoiwonVO vo = new HoiwonVO();
		boolean run=true;
		String name="";
		
		while(run) {
			System.out.print("1.전체조회 2.개별조회 3.회원가입 4.수정 5.삭제 6.종료 ==> ");
			int no = scanner.nextInt();
			
			switch(no) {
				case 1:
					ArrayList<HoiwonVO> vos = dao.getList();
					
					System.out.println("\t\t** 주 소 록 **");
					System.out.println("=".repeat(40));
					System.out.println("번호\t성명\t나이\t주소\t성별");
					System.out.println("-".repeat(40));
					for(HoiwonVO v : vos) {

						System.out.print(v.getIdx()+"\t");
						System.out.print(v.getName()+"\t");
						System.out.print(v.getAge()+"\t");
						System.out.print(v.getAddress()+"\t");
						System.out.print(v.getGender());
						System.out.println();
					}
					System.out.println("-".repeat(40));
					System.out.println("\t\t\t총 회원 : " +vos.size()+" 명");
					System.out.println("=".repeat(40));
					
					break;
				case 2:
					System.out.print("검색 할 회원명을 입력하세요 ==> ");
					name = scanner.next();
					System.out.println("-".repeat(33));
					vo=dao.getSearch(name);
					if(vo.getName()!=null) {
//						System.out.println(vo);
						System.out.println("번호 : "+vo.getIdx());
						System.out.println("이름 : "+vo.getName());
						System.out.println("나이 : "+vo.getAge());
						System.out.println("주소 : "+vo.getAddress());
						System.out.println("성별 : "+vo.getGender());
					} else {
						System.out.println(name+" 님은 회원이 아닙니다.");
					}
					break;
					
				case 3:		//회원가입
//					System.out.println("회원 이름을 입력하세요 : ");
//					name = scanner.next();
//					System.out.println("나이를 입력하세요 : ");
//					int age = scanner.nextInt();
//					System.out.println("주소를 입력하세요 : ");
//					String address = scanner.next();
//					System.out.println("성별을 입력하세요(1:남자 / 2:여자) : ");
//					int gender = scanner.nextInt();
//					dao.setHoiwonInput(name,age,address,gender);
					
					vo=new HoiwonVO();
					System.out.print("\n회원 이름을 입력하세요 ==> ");
					vo.setName(scanner.next());
					System.out.print("\n나이를 입력하세요 : ");
					vo.setAge(scanner.nextInt());
					System.out.print("\n주소를 입력하세요 : ");
					vo.setAddress(scanner.next());
					System.out.print("\n성별을 입력하세요(1:남자 / 2:여자) : ");
					int gender = scanner.nextInt();
					if(gender == 1 )vo.setGender("남자");
					else vo.setGender("여자");
					int res = dao.setHoiwonInput(vo); // 회원가입 메소드 호출
					if (res==0)System.out.println("회원가입에 성공했습니다.");
					else System.out.println("회원가입에 실패했습니다.");
					break;
					
				case 4:		//회원정보수정
					System.out.print("정보를 수정 할 회원명을 입력하세요 ==>");
					name = scanner.next();
					System.out.println("-".repeat(33));
					vo=dao.getSearch(name);
					//삭제하려면 뭘 삭제할지 먼저 찾아야함 (개별자료검색)
					if(vo.getName()==null) System.out.println(name+" 님의 자료가 없습니다. . .");
					else {
						System.out.println("~".repeat(40));
						System.out.println("수정할 항목의 번호를 입력하세요.");
						System.out.print("1>나이 2>주소 3>성별 4>종료 ==> ");
						no=scanner.nextInt();
						int age=vo.getAge();
						String address=vo.getAddress();
						String strGender=vo.getGender();
						
						switch(no) {
							case 1:
								System.out.print("수정 할 나이를 입력하세요 ==> ");
								age=scanner.nextInt();
								break;
							case 2:
								System.out.print("수정 할 주소를 입력하세요 ==> ");
								address=scanner.next();
								break;
							case 3:
								System.out.print("수정 할 성별을 입력하세요( 1>남 2>여 ) ==> ");
								gender=scanner.nextInt();
								if(gender==1)strGender ="남자";
								else strGender="여자";
								break;
							default:
								break;
								
						}
						
						res = dao.setHoiwonUpdate(name,age,address,strGender);
						if (res==0) System.out.println(name+"님의 정보 수정에 실패했습니다.");
						else System.out.println(name+" 님의 정보가 수정되었습니다**");
					}
					break;
					
				case 5:		//회원정보삭제
					System.out.print("삭제 할 회원명을 입력하세요 ==> ");
					name = scanner.next();
					System.out.println("-".repeat(33));
					
					vo=dao.getSearch(name);
					//삭제하려면 뭘 삭제할지 먼저 찾아야함 (개별자료검색)
					if(vo.getName()==null) System.out.println(name+" 님의 자료가 없습니다. . .");
					else {
						dao.setDelete(name);
						System.out.println(name+" 님의 자료가 삭제되었습니다. . .");
					}
					break;
					
				default:
					run=false;
			}
			
		}
		System.out.println("작업 끝");
		//DB conn객체 close..
		dao.connClose();
		
		scanner.close();
	}
}
