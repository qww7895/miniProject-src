package net.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.product.db.ProductBean;
import net.product.db.ProductDAO;
import net.admin.action.Action;
import net.admin.action.ActionForward;

public class pdsearchAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 	HttpSession session=request.getSession();
				 	ProductDAO productdao=new ProductDAO();
				 	request.setCharacterEncoding("UTF-8");
				 	System.out.println(request.getParameter("id"));
				 	ProductBean bean = productdao.getProductView2(request.getParameter("id"));
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
					forward.setPath("ProductViewAction.ad"); 	
					System.out.println("seach 정상작동");
			   		return forward;
			}
}
