package com.model2.mvc.view.purchase;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.product.ProductService;
import com.model2.mvc.service.product.impl.ProductServiceImpl;
import com.model2.mvc.service.product.vo.ProductVO;

public class AddPurchaseViewAction extends Action {

	public AddPurchaseViewAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("jasdlfj"+request.getParameter("prodNo"));
int prodNo=Integer.parseInt(request.getParameter("prodNo"));
		
		ProductService service=new ProductServiceImpl();
		ProductVO vo=service.getProduct(prodNo);
		System.out.println("purchase ��getprodNo>>>>>:"+prodNo);
		System.out.println("purchase ��getprodNo�� vo>>>>>:"+vo);
		request.setAttribute("vo", vo);
		
		
		return "forward:/purchase/addpurchaseView.jsp";
	}

}
