package net.product.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.product.db.ProductDAO;
import net.product.action.Action;
import net.product.action.ActionForward;

public class productListaction implements net.product.action.Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 	HttpSession session=request.getSession();
				 	ProductDAO productdao=new ProductDAO();
			   		
			   		List productlist=new ArrayList();
			   		productlist=productdao.getProductList(request.getParameter("pid"),request.getParameter("s_category"));
			   		request.setAttribute("productlist",productlist);
			   	
			   		
			   		
			   		
			   		ActionForward forward = new ActionForward();
			   		forward.setRedirect(false);
					forward.setPath("product/list.jsp"); 	
					System.out.println("productListaction 정상작동");
			   		return forward;
			}
}
