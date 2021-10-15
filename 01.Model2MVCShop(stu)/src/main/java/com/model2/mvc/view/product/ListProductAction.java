package com.model2.mvc.view.product;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class ListProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SearchVO searchVO=new SearchVO();
		String encoding = request.getParameter("searchKeyword");

		
		//keyword1 = new String(encoding.getBytes("8859_1"),"euc-kr");
				
		//System.out.println(keyword1);
		int page=1;
		if(request.getParameter("page") != null)
			//받아온 page가 null이 아니면
			page=Integer.parseInt(request.getParameter("page"));
		//page에 담는다
		System.out.println("ListProductAction >>> "+ page+"    "+request.getParameter("searchCondition")+"    "+
				request.getParameter("searchKeyword"));
		//page에 담겨져 있는거 확인  
		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		String keyword = (request.getParameter("searchKeyword")==null)? "": request.getParameter("searchKeyword");
		searchVO.setSearchKeyword(keyword);
		
		String pageUnit=getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		
		ProductService service=new ProductServiceImpl();
		System.out.println("ListProductAction >>> searchCondition: "+searchVO.getSearchCondition()+
				" searchKeyword: "+searchVO.getSearchKeyword()+" page unit: "+searchVO.getPageUnit());
		/**
		 * 
		 */
		HashMap<String,Object> map=service.getProductList(searchVO);
		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		
		return "forward:/product/listProduct.jsp";
	}
}