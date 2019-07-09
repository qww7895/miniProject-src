package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.action.ActionForward;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class ProductViewAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	 	HttpSession session=request.getSession();
	 	ProductDAO productdao=new ProductDAO();
	 	

	 	request.setCharacterEncoding("UTF-8");
	 	
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
		forward.setPath("admin/product_view.jsp"); 	
		System.out.println("ProductViewAction 정상작동");
   		return forward;		 	
 }
}