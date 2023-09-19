package T9_sale;

import java.util.ArrayList;
import java.util.Scanner;

public class SaleService {
	Scanner scanner =new Scanner(System.in);
	
//	ProductDAO dao=null;
	SaleDAO dao=new SaleDAO();
	ProductVO pVO=null;
	SaleVO sVO=null;
	String pName="";
	String ans="N";
	int res=0;
	
	
	public void getSaleMenu() {
		boolean run=true;
		
		while(run) {
			System.out.print("\n1:판매내역등록  2:상품검색  3:날짜별검색  4:판매내역리스트  4:삭제  5:종료  => ");
			int no = scanner.nextInt();
			
			switch (no) {
				case 1: //판매내역등록
					saleInput();
					break;
				case 2: //판매상품검색
					saleSearch();
					break;
				case 3://날짜별검색
					saleDateSearch();
					
					break;
				case 4:
					saleList();
					break;
				case 5:
//					saleDelete();
					break;
				default:
					run=false;
			}
			
		}
		
		
		
	}

	private void saleList() {
		ArrayList<SaleVO> vos=dao.getSaleList();
		
		System.out.println("* * *상품 리스트* * *");
		System.out.println("\t상품명 \t판매갯수 \t판매액 \t판매일");
		System.out.println(" * ".repeat(20));
		for(int i=0; i<vos.size(); i++) {
			sVO=vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.println((sVO.getEa()*sVO.getSalePrice()) +"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println(" * ".repeat(20));
		System.out.println("\t총 판매건수 : "+vos.size()+" 건");
		
		
	}

	private void saleDateSearch() {
		System.out.print("검색할 판매일자를 입력 => ");
		String pDate=scanner.next();
		ArrayList<SaleVO> vos=dao.getSaleDateSearch(pName);
		
		System.out.println("* * *상품 리스트* * *");
		System.out.println("\t상품명 \t판매갯수 \t판매액 \t판매일");
		System.out.println(" * ".repeat(20));
		for(int i=0; i<vos.size(); i++) {
			sVO=vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.println((sVO.getEa()*sVO.getSalePrice()) +"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println(" * ".repeat(20));
		System.out.println("\t총 판매건수 : "+vos.size()+" 건");
	}

	private void saleSearch() {
		System.out.print("검색할 상품명을 입력 => ");
		pName=scanner.next();
		ArrayList<SaleVO> vos=dao.getSaleNameSearch(pName);
		
		System.out.println("* * *상품 리스트* * *");
		System.out.println("\t상품명 \t판매갯수 \t판매액 \t판매일");
		System.out.println(" * ".repeat(20));
		for(int i=0; i<vos.size(); i++) {
			sVO=vos.get(i);
			System.out.print(sVO.getIdx()+"\t");
			System.out.print(sVO.getpName()+"\t");
			System.out.print(sVO.getEa()+"\t");
			System.out.println((sVO.getEa()*sVO.getSalePrice()) +"\t");
			System.out.print(sVO.getpDate().substring(0,10)+"\n");
		}
		System.out.println(" * ".repeat(20));
		System.out.println("\t총 판매건수 : "+vos.size()+" 건");
			
		
	}

	private void saleInput() {
		while(true) {
			System.out.print("판매상품명을 입력 => ");
			pName = scanner.next();
			
			//판매상품이 상품테이블에 등록된 상품인지 검색해야함
			pVO = dao.getNameSearch(pName); 
			if(pVO.getpName() == null) {
				System.out.println("==> 등록된 제품이 없습니다.");
			} else {
				sVO=new SaleVO();
				sVO.setpName(pName);
				System.out.print("판매수량을 입력 => ");
				sVO.setEa(scanner.nextInt());
				System.out.print("판매날짜(yyyy-m-d)를 입력 => ");
				sVO.setpDate(scanner.next());
				res=dao.setSaleInput(sVO);
				if(res==0) System.out.println("\n상품등록실패");
				else System.out.println("\n상품이 등록되었습니다.");
				
				System.out.println(" * ".repeat(10));
				System.out.print("상품등록을 계속합니까? (y/n)");
				ans=scanner.next().toUpperCase();
				if(ans.equals("N"))break;
			}
			
		}
		
		
	}
	
	
}
