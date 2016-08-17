package board;

public class Paging {
	private int nowPage;
	
	private static final int CONTENT_NUMBER_PER_PAGE=10; 
	/**
	 * ���������� ������ ������ �׷� ��
	 */
	private static final int PAGEGROUP_NUMBER_PER_PAGE=10; 
	
	private int numberOfContentsPerPage=CONTENT_NUMBER_PER_PAGE;
	
	private int numberOfPageGroup=PAGEGROUP_NUMBER_PER_PAGE;
	/**
	 * ���� db�� ������� �Խù� �� ==>select�ؼ� ã�ƿ;���
	 * ���� �������� web���κ��� �޾� ����
	 */
	private int totalContent;
	public Paging(int totalContent, int nowPage){
			this.totalContent=totalContent;
			this.nowPage=nowPage;
	}
	
	
	

	/**
	 * �� ������ ���� return�Ѵ�.
		1. ��ü ������(�Խù�) % �� �������� ������ ������ ���� 
		=> 0 �̸� ���� / ���� �� ������ �� 
		2. ��ü ������(�Խù�) % �� �������� ������ ������ ���� 
		=> 0���� ũ�� ���� / ���� +1�� �� ���� �� ������ �� 
		�Խù� �� 1 2 3 4 5 6 7 8 9 10 11
		1page 1~5
		2page 6~10
		3page 11
		ex) �Խù� 32��, �������� �Խù� �� 5��
			  -> 7������
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
	 * �� ������ �׷��� ���� return�Ѵ�.
		1. �� �������� % Page Group �� Page ��. 
		=> 0 �̸� ���� / ���� �� ������ ��
		2. �� �������� % Page Group �� Page ��.
	 	=> 0���� ũ�� ���� / ���� +1�� �� ���� �� ������ ��
	 	ex)�� �Խù� �� 23�� 
	 	 	�� ������ ? �� ������ �׷��?
	 	 	������ 1 2 3 4 5
	 	 	������ �׷� 4 1234(1�׷�) 5(2�׷�)
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
	 * ���� �������� ���� ������ �׷� ��ȣ(�� ��° ������ �׷�����) �� 
	 * return �ϴ� �޼ҵ� 
	 * 1. ���� ������ % Page Group �� Page �� 
	 * => 0 �̸� ���� / ���� ���� ������ �׷�. 
	 * 2. ���� ������ % Page Group �� Page �� 
	 * => 0 ũ�� ���� / ���� +1�� �� ���� ���� ������ �׷� 
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
	 * ���� �������� ���� ������ �׷��� ���� ������ ��ȣ�� return �Ѵ�.
	1. Page Group �� Page ��*(���� ������ �׷� -1) + 1�� �� ���� ù �������̴�.
			(������ �׷�*������ �׷� ���� �� �� �׷��� ������ ��ȣ�̹Ƿ�) 
	2. ���� ��� ����� 0�� ���� ù������ �̹Ƿ� 1�� return �Ѵ�. 
	������ �׷�
	1 2 3 4 -> 5 6 7 8 -> 9 10
	�� �Խù� 50��
	�������׷� 3��
	������ 10��
	�׷�� 3��
	 */
	public int getStartPageOfPageGroup(){
		int getStartPageOfPageGroup=1;
		if((numberOfPageGroup*(getNowPageGroup()-1)+1)!=0){
			getStartPageOfPageGroup=numberOfPageGroup*(getNowPageGroup()-1)+1;
		}
		return getStartPageOfPageGroup;	
	}
	/**
	 *���� �������� ���� ������ �׷��� ������ ������ ��ȣ�� return �Ѵ�.
		1. ���� ������ �׷� * ������ �׷� ���� �� ������ ��ȣ�̴�. 
		2. �� �׷��� ������ ������ ��ȣ�� ��ü �������� ������ ������ ��ȣ���� ū ���� 
			��ü �������� ������ ��ȣ�� return �Ѵ�. 
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
	 * ���� ������ �׷��� �ִ��� üũ ���� �������� ���� 
	 * ������ �׷��� 1���� ũ�� true 
	 * ex) ������
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
	 * ���� ������ �׷��� �ִ��� üũ�ϴ� �޼���
	 * ���� ������ �׷��� ������ ������ �׷� (������ ������ �׷� == �� ������ �׷� ��) 
	 *���� ������ true 
	 *	  ex) ������
	 * 		 	1 2 3 4 / 5 6 7 8 / 9 10
	 * 				1		    	2				3(group) == �������� �׷�� ������ false ������ true
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
