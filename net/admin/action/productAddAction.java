package net.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.*;
import net.product.db.ProductBean;
import net.product.db.ProductDAO;

public class productAddAction implements Action {
		 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
		 	throws Exception{
			 	ActionForward forward = new ActionForward();
			 	System.out.println("productAddAction 작동");
			 	HttpSession session=request.getSession();
				ProductDAO productdao=new ProductDAO();
				ProductBean bean= new ProductBean();
				boolean result =false;
				System.out.println("Adding Product");
				System.out.println("req : "+(String)request.getAttribute("PINDEX"));
				System.out.println("par : "+(String)request.getParameter("PINDEX"));
				
				bean.setPINDEX(Integer.parseInt((String)request.getParameter("PINDEX")));System.out.println(Integer.parseInt((String)request.getParameter("PINDEX")));
				bean.setPBCLASS((String)request.getParameter("PBCLASS"));System.out.println(request.getParameter("PBCLASS"));
				bean.setPSCLASS((String)request.getParameter("PSCLASS"));System.out.println(request.getParameter("PSCLASS"));
				bean.setPNAME((String)request.getParameter("PNAME"));System.out.println(request.getParameter("PNAME"));
				bean.setPINTRO((String)request.getParameter("PINTRO"));System.out.println(request.getParameter("PINTRO"));
				bean.setPNUTRO((String)request.getParameter("PNUTRO"));System.out.println(request.getParameter("PNUTRO"));
				bean.setPALLERGY((String)request.getParameter("PALLERY"));System.out.println(request.getParameter("PALLERY"));
				bean.setPPICTURE((String)request.getParameter("PPICTURE"));System.out.println(request.getParameter("PPICTURE"));
				bean.setPLIKE(Integer.parseInt((String)request.getParameter("PLIKE")));System.out.println(request.getParameter("PLIKE"));
				System.out.println("beans Setting Complete");
				result=productdao.AddProduct(bean);
				System.out.println("productAddAction 결과 :"+result);
					if(result) {//등록 성공
						System.out.println("Adding Sucess");
				   		forward.setPath("product_list.ad");
				   		forward.setRedirect(false);						
						
					}else {
			   			PrintWriter out=response.getWriter();
				   		out.println("<script>");
				   		out.println("alert('상품등록 실패.');");
				   		out.println("</script>");
			   			System.out.println("Adding fail");
			   			forward.setPath("product_list.ad");	
			   			forward.setRedirect(false);						
					}
					
					
		   		return forward;
		}
	}