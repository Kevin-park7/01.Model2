package com.model2.mvc.view.purchase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.mvc.framework.Action;
import com.model2.mvc.service.purchase.PurchaseService;
import com.model2.mvc.service.purchase.impl.PurchaseServiceImpl;
import com.model2.mvc.service.purchase.vo.PurchaseVO;

public class UpdatePurchaseViewAction extends Action {

	public UpdatePurchaseViewAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		PurchaseVO purchaseVO = new PurchaseVO();
		
		//purchaseVO.setBuyer(request.getParameter("buyerId"));
		purchaseVO.setPaymentOption(request.getParameter("paymentOption"));
		purchaseVO.setReceiverName(request.getParameter("receiverName"));
		purchaseVO.setReceiverPhone(request.getParameter("receiverPhone"));
		purchaseVO.setDivyAddr(request.getParameter("receiverAddr"));
		purchaseVO.setDivyRequest(request.getParameter("receiverRequest"));
		purchaseVO.setDivyDate(request.getParameter("divyDate"));
		PurchaseService service = new PurchaseServiceImpl();
		service.updatePurcahse(purchaseVO);
		int tranNo=Integer.parseInt(request.getParameter("tranNo"));
		
		PurchaseVO vo=service.getPurchase(tranNo);
		request.setAttribute("vo", vo);
		request.setAttribute("pvo", purchaseVO);
		
		return "forward:/purchase/updatePurchaseView.jsp";
	}

}
