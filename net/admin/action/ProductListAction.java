package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.*;
import net.product.db.ProductDAO;

public class ProductListAction implements Action {
		 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
		 	throws Exception{
			 	ActionForward forward = new ActionForward();
			 	
			 	HttpSession session=request.getSession();
				ProductDAO productdao=new ProductDAO();

			 	request.setCharacterEncoding("UTF-8");
		   		List productlist=new ArrayList();
		   		productlist=productdao.getProductList2();

		   		
		   		request.setAttribute("productlist", productlist);
		   		forward.setRedirect(false);
		   		forward.setPath("admin/product_list.jsp");
		   		return forward;
		}
	}