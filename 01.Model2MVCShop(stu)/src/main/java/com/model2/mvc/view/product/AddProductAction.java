package com.model2.mvc.view.product;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;


public class AddProductAction extends Action {

	@Override
	public String execute(	HttpServletRequest request,
												HttpServletResponse response) throws Exception {
		ProductVO productVO=new ProductVO();
		System.out.println(">>>> "+request.getParameter("manuDate"));
		String manuDate = request.getParameter("manuDate").replace("-", "");
		System.out.println(">>>> "+manuDate);
		productVO.setProdName(request.getParameter("prodName"));
		productVO.setManuDate(manuDate);	// YYmmdd
		productVO.setPrice(Integer.parseInt(request.getParameter("price")));
		productVO.setFileName(request.getParameter("fileName"));
		productVO.setProdDetail(request.getParameter("prodDetail"));
//		Calendar cal = Calendar.getInstance();
//		Date date = new Date();
//		SimpleDateFormat sdformat = new SimpleDateFormat("yy/M/dd");
//		String ss=sdformat.format(new java.util.Date());
//		
//		productVO.setRegDate(cal);
//		
//		System.out.println("Addproduct"+productVO);
//		
		ProductService service=new ProductServiceImpl();
		service.addProduct(productVO);
		HashMap<String,Object> map = new HashMap ();
		map.put("prodName", request.getParameter("prodName"));
		map.put("manuDate", request.getParameter("manuDate"));
		map.put("price", request.getParameter("price"));
		map.put("fileName", request.getParameter("fileName"));
		map.put("prodDetail", request.getParameter("prodDetail"));
		
		HttpSession session=request.getSession();
		map.get("prodName");
		System.out.println("session >>"+map);
		session.setAttribute("productVO", map);
		
		return "redirect:/product/addProduct.jsp";
	}
}