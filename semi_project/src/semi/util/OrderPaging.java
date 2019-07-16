package semi.util;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import semi.bean.OrdersDao;
import semi.bean.OrdersDto;

public class OrderPaging
{
  private String type;
  private String keyword;
  private String pstr;
  private int psize = 10;
  private int bsize = 10;
  private boolean search;
  private int pno;
  
  public OrderPaging(HttpServletRequest request) { type = request.getParameter("type");
    keyword = request.getParameter("keyword");
    pstr = request.getParameter("pno");
  }
  

  private int start;
  
  private int end;
  private int count;
  private int pageCount;
  private int startBlock;
  private int endBlock;
  private List<OrdersDto> list;
  private String query;
  public void calculate()
    throws Exception
  {
    search = ((type != null) && (keyword != null));
    
    try
    {
      pno = Integer.parseInt(pstr);
      if (pno <= 0) throw new Exception();
    } catch (Exception e) {
      pno = 1;
      

      end = (pno * psize);
      start = (end - (psize - 1));
      


      OrdersDao odao = new OrdersDao();
      count = odao.getCount(type, keyword);
      pageCount = ((count + psize - 1) / psize);
      
      startBlock = ((pno - 1) / bsize * bsize + 1);
      endBlock = (startBlock + (bsize - 1));
      
      if (endBlock > pageCount) {
        endBlock = pageCount;
      }
      
      if (search) {
        list = odao.search(type, keyword, start, end);
      }
      else {
        list = odao.list(start, end);
      }
      



      if (search) {
        String tmp = URLEncoder.encode(type, "UTF-8");
        query = ("&type=" + tmp + "&keyword=" + keyword);
      } else {
        query = "";
      }
    }
  }
  
  public List<OrdersDto> getList() {
    return list;
  }
  
  public boolean isFirstBlock() {
    return startBlock == 1;
  }
  
  public boolean isFirstPage() {
    return pno == 1;
  }
  
  public boolean isLastBlock() {
    return endBlock == pageCount;
  }
  
  public boolean isLastPage() {
    return pno == pageCount;
  }
  
  public String getNextBlock() {
    return "pno=" + (endBlock + 1) + query;
  }
  
  public String getNextPage() {
    return "pno=" + (pno + 1) + query;
  }
  
  public String getPrevPage() {
    return "pno=" + (pno - 1) + query;
  }
  
  public String getPrevBlock() {
    return "pno=" + (startBlock - 1) + query;
  }
  
  public String getPage(int i)
  {
    return "pno=" + i + query;
  }
  
  public boolean isCurrentPage(int i)
  {
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
  
  public String toString()
  {
    return 
    
      "Paging [type=" + type + ", keyword=" + keyword + ", pstr=" + pstr + ", psize=" + psize + ", bsize=" + bsize + ", search=" + search + ", pno=" + pno + ", start=" + start + ", end=" + end + ", count=" + count + ", pageCount=" + pageCount + ", startBlock=" + startBlock + ", endBlock=" + endBlock + "]";
  }
}