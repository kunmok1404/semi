package home.util;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import home.beans.BoardDao;
import home.beans.BoardDto;

/**
 * �� Ŭ������ ����¡ ó���� �����ϴ� Ŭ�����Դϴ�.
 * ��û����(�˻��з�, �˻���, ��������ȣ, ������ũ��, ���ũ��)�� ���޹޾�
 * ���� ������ ����մϴ�
 * [1] ����/���� ��Ϲ�ȣ
 * [2] ����/���� �Խñۼ���
 * [3] ������ �̵��� �ʿ��� �Ķ���� ���ڿ�
 * [4] ���/�˻� �� �Խñ� ����
 */
public class Paging {
	private String type;
	private String keyword;
	private String pstr;
	private int psize = 10;//������ ǥ�ñ� ����
	private int bsize = 10;//������ ǥ�ù�ȣ ����
	
	//������
	public Paging(HttpServletRequest request) {
		this.type = request.getParameter("type");
		this.keyword = request.getParameter("keyword");
		this.pstr = request.getParameter("pno");
	}
	
	private boolean search;//�˻�����
	private int pno;//����������
	
	private int start, end;//���۱ۼ���, ����ۼ���
	private int count, pageCount;//��ü�Խñ� ��, ��ü������ ��
	private int startBlock, endBlock;//���ۺ�Ϲ�ȣ, �����Ϲ�ȣ
	
	private List<BoardDto> list;//�����Ͱ� ����� ���
	private String query;//�˻� ���ڿ�
	
	//��� �޼ҵ�
	public void calculate() throws Exception{
		//type, keyword ��� null�� �ƴϸ� �˻�, �ƴϸ� ���
		this.search = type != null && keyword != null; 
		
		//������ ��ȣ�� ���� start, end�� ����ϸ� ����¡ ������ ����
		try{
			pno = Integer.parseInt(pstr);
			if(pno <= 0) throw new Exception();
		}catch(Exception e){
			pno = 1;
		}
		
		this.end = pno * psize;
		this.start = end - (psize-1);
		
		//�ϴ� �׺���̼� �κ��� ���(�� �Խñ� ���� �̿��� ������ �� ���)
		//���� : �������� = (�Խñۼ� + ������ũ�� - 1) / ������ũ��
		BoardDao bdao = new BoardDao();
		this.count = bdao.getCount(type, keyword); 
		this.pageCount = (count + psize - 1) / psize;
		
		this.startBlock = (pno - 1) / bsize * bsize + 1;
		this.endBlock = startBlock + (bsize - 1);
		//��ȣ �Ѿ ���� ���� ó��
		if(endBlock > pageCount){
			endBlock = pageCount;
		}
		
		if(search){
			list = bdao.search(type, keyword, start, end); 
		}
		else{
			list = bdao.list(start, end);		
		}
		
		//�˻��� ������ ���� �˻��� ���� �ƴ� ���� ÷�εǴ� �Ķ���� ó��
		//��� : �˻��� ó�� x
		//�˻� : &type=ooo&keyword=ooo ������ �Ķ���͸� ����
		if(search) {
			String tmp = URLEncoder.encode(type, "UTF-8");
			this.query = "&type="+tmp+"&keyword="+keyword;
		}else {
			this.query="";
		}
	}

	//getter �޼ҵ带 ���ϴ� ��ŭ ����
	public List<BoardDto> getList() {
		return list;
	}
	//ù������� Ȯ���� �� �ִ� getter
	public boolean isFirstBlock() {
		return this.startBlock == 1;
	}
	//ù���������� Ȯ���� �� �ִ� getter
	public boolean isFirstPage() {
		return this.pno == 1;
	}
	//������������� Ȯ���� �� �ִ� getter
	public boolean isLastBlock() {
		return this.endBlock == this.pageCount;
	}
	//���������������� Ȯ���� �� �ִ� getter
	public boolean isLastPage() {
		return this.pno == this.pageCount;
	}
	//���� ������� �̵��ϱ� ���� �Ķ���� getter
	public String getNextBlock() {
		return "pno="+(endBlock+1)+query;
	}
	//���� �������� �̵��ϱ� ���� �Ķ���� getter
	public String getNextPage() {
		return "pno="+(pno+1)+query;
	}
	//���� �������� �̵��ϱ� ���� �Ķ���� getter
	public String getPrevPage() {
		return "pno="+(pno-1)+query;
	}
	//���� ������� �̵��ϱ� ���� �Ķ���� getter
	public String getPrevBlock() {
		return "pno="+(startBlock-1)+query;
	}
	
	//i�������� �̵��ϱ� ���� �Ķ���� getter
	public String getPage(int i) {
		return "pno="+i+query;
	}
	
	//���� ������ ��ȯ�ϴ� �޼ҵ�
	public boolean isCurrentPage(int i) {
		return pno == i;
	}

	public String getType() {
		return type;
	}

	public String getKeyword() {
		return keyword;
	}

	public String getPstr() {
		return pstr;
	}

	public int getPsize() {
		return psize;
	}

	public int getBsize() {
		return bsize;
	}

	public boolean isSearch() {
		return search;
	}

	public int getPno() {
		return pno;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getCount() {
		return count;
	}

	public int getPageCount() {
		return pageCount;
	}

	public int getStartBlock() {
		return startBlock;
	}

	public int getEndBlock() {
		return endBlock;
	}

	public String getQuery() {
		return query;
	}

	@Override
	public String toString() {
		return "Paging [type=" + type + ", keyword=" + keyword + ", pstr=" + pstr + ", psize=" + psize + ", bsize="
				+ bsize + ", search=" + search + ", pno=" + pno + ", start=" + start + ", end=" + end + ", count="
				+ count + ", pageCount=" + pageCount + ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
	}
	
}








