package com.model2.mvc.view.purchase;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;
import com.model2.mvc.service.user.vo.UserVO;

public class UpdatePurchaseAction extends Action {

	public UpdatePurchaseAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PurchaseVO purchaseVO = new PurchaseVO();
		UserVO userVO = new UserVO();
		userVO.setUserId(request.getParameter("buyerId"));
		//String date = request.getParameter("divyDate");
		//java.util.Date u = new java.util.Date();
		//java.sql.Date s = new java.sql.Date(u.getDate());
		//System.out.println("sqldate typeº¯È¯"+s);
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(request.getParameter("divyDate"));
		purchaseVO.setTranNo(Integer.parseInt(request.getParameter("tranNo")));
		purchaseVO.setBuyer(userVO);
		PurchaseService service = new PurchaseServiceImpl();
		service.updatePurcahse(purchaseVO);
		int tranNo=Integer.parseInt(request.getParameter("tranNo"));
		
		//PurchaseVO vo=service.getPurchase(tranNo);
		request.setAttribute("purch", purchaseVO);
		return "forward:/purchase/getpurchase.jsp";
		
	}

}