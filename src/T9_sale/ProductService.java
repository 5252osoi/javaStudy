package T9_sale;

import java.util.List;
import java.util.Scanner;

public class ProductService {
	Scanner scanner =new Scanner(System.in);

	
	ProductDAO dao=new ProductDAO();
	ProductVO vo=null;
	String pName="";
	String ans="N";
	int res=0;
	

	//상품관리 주 메뉴
	public void getProductMenu() {
		boolean run=true;
		
		while(run) {
			System.out.print("\n1:상품등록  2:상품검색  3:상품리스트  4:삭제  5:종료  => ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1:
					productInput();
					break;
				case 2:
					productSearch();
					break;
				case 3:
					productList();
					break;
				case 4:
					productDelete();
					break;
				default:
					run=false;
			}
			dao.connClose();
		}
		
		
		
	}

	private void productDelete() {
		System.out.println(" * * 상품 삭제* * ");
		System.out.print(" 삭제 할 상품명을 입력 => ");
		pName=scanner.next();
		vo=dao.getNameSearch(pName);
		
		if(vo.getpName()==null) System.out.println("해당 상품 없음");
		else {
			res= dao.setProductDelete(vo.getIdx());
			if(res==0)System.out.println("상품삭제 실패");
			else System.out.println(pName+" (이)가 삭제되었습니다.");
		}
		
	}

	private void productList() {
		List<ProductVO> vos=dao.getProductList();
		System.out.println("* * *상품 리스트* * *");
		System.out.println("\n***전체상품리스트***");
		System.out.println("\t상품명 \t 상품가격");
		System.out.println(" * ".repeat(10));
		for(int i=0; i<vos.size(); i++) {
			vo=vos.get(i);
			System.out.print(vo.getIdx()+"\t");
			System.out.print(vo.getpName()+"\t");
			System.out.print(vo.getPrice()+"\n");
		}
		System.out.println(" * ".repeat(10));
		System.out.println("\t총상품건수 : "+vos.size()+" 건");
	}

	private void productSearch() {
		System.out.print("검색할 상품명을 입력 => ");
		pName=scanner.next();
		vo=dao.getNameSearch(pName);
		
		if(vo.getpName()==null) System.out.println("검색한 상품 없음");
		else {
			System.out.println("상품고유번호	: "+vo.getIdx());
			System.out.println("상  품  명	: "+vo.getpName());
			System.out.println("상 품 가 격	: "+vo.getPrice());
			
		}
	}

	//상품등록처리
	private void productInput() {
		//가격,이름
		while(true) {
			System.out.print("등록할 상품명을 입력 => ");
			pName = scanner.next();
			
			//중복처리
			vo=dao.getNameSearch(pName); 
			if(vo.getpName() != null) {
				System.out.println("==> 이미 동일한 제품이 있습니다.");
			} else {
				vo.setpName(pName);
				System.out.print("상품가격 => ");
				vo.setPrice(scanner.nextInt());
				res=dao.setProductInput(vo);
				if(res==0) System.out.println("\n상품등록실패");
				System.out.println("\n상품이 등록되었습니다.");
				System.out.println(" * ".repeat(10));
				System.out.print("상품등록을 계속합니까? (y/n)");
				ans=scanner.next().toUpperCase();
				if(ans.equals("N"))break;
			}
			
		}
			
		
		
	}
	
	
	
	
}
