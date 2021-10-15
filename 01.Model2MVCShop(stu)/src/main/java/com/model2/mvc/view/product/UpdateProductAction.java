package com.model2.mvc.view.product;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		
		ProductVO productVO=new ProductVO();
		System.out.println("date확인>>>> "+request.getParameter("manuDate"));
		String manuDate = request.getParameter("manuDate").replace("-", "");
		System.out.println(">>>> "+manuDate);
		int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		System.out.println(prodNo);
		
		
		
		productVO.setProdNo(prodNo);
		
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
		productVO.setManuDate(manuDate);
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		System.out.println("update수정한정보"+productVO);
		
		ProductService service=new ProductServiceImpl();
		service.updateProduct(productVO);
		
		//HttpSession session=request.getSession();
	//	String sessionId=((UserVO)session.getAttribute("prodVO")).getUserId();
		//ProductVO session1=((ProductVO)session1.getAttribute("prodVO"));
		
		HashMap<String,Object> map = new HashMap ();
		map.put("prodName", request.getParameter("prodName"));
		map.put("manuDate", request.getParameter("manuDate"));
		map.put("price", request.getParameter("price"));
		map.put("fileName", request.getParameter("fileName"));
		map.put("prodDetail", request.getParameter("prodDetail"));
		
		HttpSession session=request.getSession();
		map.get("prodName");
		System.out.println("session >>"+map);
		session.setAttribute("prodVO", map);
		
		
		
	
//		if(sessionId.equals(userId)){
//			session.setAttribute("user", productVO);
//		}
		
		return "redirect:/getProduct.do?prodNo="+prodNo;
	}
}