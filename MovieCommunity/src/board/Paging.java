package board;

public class Paging {
	private int nowPage;
	
	private static final int CONTENT_NUMBER_PER_PAGE=10; 
	/**
	 * 한페이지에 보여질 페이지 그룹 수
	 */
	private static final int PAGEGROUP_NUMBER_PER_PAGE=10; 
	
	private int numberOfContentsPerPage=CONTENT_NUMBER_PER_PAGE;
	
	private int numberOfPageGroup=PAGEGROUP_NUMBER_PER_PAGE;
	/**
	 * 현재 db에 저장된총 게시물 수 ==>select해서 찾아와야함
	 * 현재 페이지는 web으로부터 받아 생성
	 */
	private int totalContent;
	public Paging(int totalContent, int nowPage){
			this.totalContent=totalContent;
			this.nowPage=nowPage;
	}
	
	
	

	/**
	 * 총 페이지 수를 return한다.
		1. 전체 데이터(게시물) % 한 페이지에 보여줄 데이터 개수 
		=> 0 이면 둘을 / 값이 총 페이지 수 
		2. 전체 데이터(게시물) % 한 페이지에 보여줄 데이터 개수 
		=> 0보다 크면 둘을 / 값에 +1을 한 값이 총 페이지 수 
		게시물 수 1 2 3 4 5 6 7 8 9 10 11
		1page 1~5
		2page 6~10
		3page 11
		ex) 게시물 32개, 페이지당 게시물 수 5개
			  -> 7페이지
	 */
	public int getTotalPage(){
		int totalPage=0;
		if(this.totalContent%this.numberOfContentsPerPage==0){
			totalPage=this.totalContent/this.numberOfContentsPerPage;
		}else if(this.totalContent%this.numberOfContentsPerPage>0){
			totalPage=(this.totalContent/this.numberOfContentsPerPage)+1;
		}
		return totalPage;
	}
	/**
	 * 총 페이지 그룹의 수를 return한다.
		1. 총 페이지수 % Page Group 내 Page 수. 
		=> 0 이면 둘을 / 값이 총 페이지 수
		2. 총 페이지수 % Page Group 내 Page 수.
	 	=> 0보다 크면 둘을 / 값에 +1을 한 값이 총 페이지 수
	 	ex)총 게시물 수 23개 
	 	 	총 페이지 ? 총 페이지 그룹수?
	 	 	페이지 1 2 3 4 5
	 	 	페이지 그룹 4 1234(1그룹) 5(2그룹)
	 */
	public int getTotalPageGroup(){
		int getTotalPage=0;
		if(getTotalPage()%numberOfPageGroup==0){
			getTotalPage= getTotalPage()/numberOfPageGroup;
		}else if( getTotalPage()%numberOfPageGroup>0){
			getTotalPage=(getTotalPage()/numberOfPageGroup)+1;
		}
		return getTotalPage;
		
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹 번호(몇 번째 페이지 그룹인지) 을 
	 * return 하는 메소드 
	 * 1. 현재 페이지 % Page Group 내 Page 수 
	 * => 0 이면 둘을 / 값이 현재 페이지 그룹. 
	 * 2. 현재 페이지 % Page Group 내 Page 수 
	 * => 0 크면 둘을 / 값에 +1을 한 값이 현재 페이지 그룹 
	 */
	public int getNowPageGroup(){
		int getNowPageGroup=0;
		if(this.nowPage%this.numberOfPageGroup==0){
			getNowPageGroup=this.nowPage/this.numberOfPageGroup;
		}else if(this.nowPage%this.numberOfPageGroup>0){
			getNowPageGroup=(this.nowPage/this.numberOfPageGroup)+1;
		}
		return getNowPageGroup;
	}
	/**
	 * 현재 페이지가 속한 페이지 그룹의 시작 페이지 번호를 return 한다.
	1. Page Group 내 Page 수*(현재 페이지 그룹 -1) + 1을 한 값이 첫 페이지이다.
			(페이지 그룹*페이지 그룹 개수 이 그 그룹의 마지막 번호이므로) 
	2. 위의 계산 결과가 0인 경우는 첫페이지 이므로 1을 return 한다. 
	페이지 그룹
	1 2 3 4 -> 5 6 7 8 -> 9 10
	총 게시물 50개
	페이지그룹 3개
	페이지 10개
	그룹수 3개
	 */
	public int getStartPageOfPageGroup(){
		int getStartPageOfPageGroup=1;
		if((numberOfPageGroup*(getNowPageGroup()-1)+1)!=0){
			getStartPageOfPageGroup=numberOfPageGroup*(getNowPageGroup()-1)+1;
		}
		return getStartPageOfPageGroup;	
	}
	/**
	 *현재 페이지가 속한 페이지 그룹의 마지막 페이지 번호를 return 한다.
		1. 현재 페이지 그룹 * 페이지 그룹 개수 가 마지막 번호이다. 
		2. 그 그룹의 마지막 페이지 번호가 전체 페이지의 마지막 페이지 번호보다 큰 경우는 
			전체 페이지의 마지막 번호를 return 한다. 
	 */
	public int getEndPageOfPageGroup(){
		int getEndPageOfPageGroup=0;
		getEndPageOfPageGroup=getNowPageGroup()*numberOfPageGroup;
		if(getEndPageOfPageGroup>this.getTotalPage()){
			getEndPageOfPageGroup=this.getTotalPage();
		}
		return getEndPageOfPageGroup;
	}
	/**
	 * 이전 페이지 그룹이 있는지 체크 현재 페이지가 속한 
	 * 페이지 그룹이 1보다 크면 true 
	 * ex) 페이지
	 * 		 	1 2 3 4 / 5 6 7 8 / 9 10
	 * 				1		    	2				3(group)
	 */
	public boolean isPreviousPageGroup(){
		boolean flag=false;
		if(getNowPageGroup()>1){
			flag=true;
		}
		return flag;
	}
	/**
	 * 다음 페이지 그룹이 있는지 체크하는 메서드
	 * 현재 페이지 그룹이 마지막 페이지 그룹 (마지막 페이지 그룹 == 총 페이지 그룹 수) 
	 *보다 작으면 true 
	 *	  ex) 페이지
	 * 		 	1 2 3 4 / 5 6 7 8 / 9 10
	 * 				1		    	2				3(group) == 총페이지 그룹수 같으면 false 작으면 true
	 */
	public boolean isNextPageGroup(){
		boolean flag=false;
		if(this.getNowPageGroup()<this.getTotalPageGroup()){
			flag=true;
		}
		return flag;
	}
	public int getNowPage(){
		return nowPage;
	}
}
