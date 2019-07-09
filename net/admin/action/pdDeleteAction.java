package net.admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.product.db.ProductDAO;

public class pdDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	 	ActionForward forward = new ActionForward();
	 	HttpSession session=request.getSession();
		ProductDAO productdao=new ProductDAO();  
   		
		boolean result=false;
   		String deleteId=request.getParameter("id");
   		result=productdao.deleteProduct( Integer.parseInt(request.getParameter("id")));
   		if(result==false){
   			System.out.println("제품 삭제 실패");
	   		return null;
	   	}
	/*
	 * PrintWriter out=response.getWriter(); out.println("<script>");
	 * out.println("alert('회원을 삭제하였습니다');"); out.println("</script>");
	 */
		ProductDAO productdao2=new ProductDAO();
   		
   		List productlist=new ArrayList();
   		productlist=productdao2.getProductList2();

   		
   		request.setAttribute("productlist", productlist);
   		
   		
   		forward.setRedirect(false);
   		forward.setPath("admin/product_list.jsp");
   		return forward;
}
}