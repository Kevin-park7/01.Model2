package com.model2.mvc.view.purchase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.common.SearchVO;
import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class ListPurchaseAction extends Action {

	public ListPurchaseAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		SearchVO searchVO=new SearchVO();
		PurchaseVO purchaseVO= new PurchaseVO();
		HttpSession session = request.getSession();
		UserVO buyerVO = (UserVO) session.getAttribute("user");
//		UserVO buyerVO = new UserVO();
//		buyerVO.setUserId(userId);
//		purchaseVO.setBuyer(buyerVO);

	
		int page=1;
		if(request.getParameter("page") != null)
			page=Integer.parseInt(request.getParameter("page"));
		System.out.println("ListPurchaseAction >>> "+ page+"    "+request.getParameter("searchCondition")+"    "+
				request.getParameter("searchKeyword"));
		searchVO.setPage(page);
		searchVO.setSearchCondition(request.getParameter("searchCondition"));
		String keyword = (request.getParameter("searchKeyword")==null)? "": request.getParameter("searchKeyword");
		searchVO.setSearchKeyword(keyword);
		
		String pageUnit=getServletContext().getInitParameter("pageSize");
		searchVO.setPageUnit(Integer.parseInt(pageUnit));
		
		PurchaseService service=new PurchaseServiceImpl();
		System.out.println("ListProductAction >>> searchCondition: "+searchVO.getSearchCondition()+
				" searchKeyword: "+searchVO.getSearchKeyword()+" page unit: "+searchVO.getPageUnit());
		HashMap<String,Object> map = service.getPurchaseList(searchVO, buyerVO.getUserId());
		System.out.println("map에 저장된 결과"+map);
		request.setAttribute("map", map);
		request.setAttribute("searchVO", searchVO);
		request.setAttribute("pageUnit", pageUnit);
		
		
		return "forward:/purchase/listPurchase.jsp";
	}

}
