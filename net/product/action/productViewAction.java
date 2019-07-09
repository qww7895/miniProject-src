package net.product.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.product.db.ProductBean;
import net.product.db.ProductDAO;
import net.product.action.Action;
import net.product.action.ActionForward;
public class productViewAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	HttpSession session=request.getSession();
		 	ProductDAO productdao=new ProductDAO();
		 	ProductBean bean = productdao.getProductView(Integer.parseInt(request.getParameter("id")));
		 	request.setAttribute("PINDEX",bean.getPINDEX());
		 	request.setAttribute("PBCLASS",bean.getPBCLASS());
		 	request.setAttribute("PSCLASS",bean.getPSCLASS());
		 	request.setAttribute("PINTRO",bean.getPINTRO());
		 	request.setAttribute("PPICTURE",bean.getPPICTURE());
		 	request.setAttribute("PALLERGY",bean.getPALLERGY());
		 	request.setAttribute("PNUTRO",bean.getPNUTRO());
		 	request.setAttribute("PNAME",bean.getPNAME());
		 	request.setAttribute("PLIKE",bean.getPLIKE());
	   		ActionForward forward = new ActionForward();
	   		forward.setRedirect(false);
			forward.setPath("product/view.jsp"); 	
			System.out.println("productViewAction 정상작동");
	   		return forward;		 	
	 }
}
