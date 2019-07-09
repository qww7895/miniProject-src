package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.action.Action;
import net.admin.action.ActionForward;
import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class mbsearchAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("mbsearchAction 작동");
		/* HttpSession session=request.getSession(); */
	 	MemberDAO memberdao=new MemberDAO();
	 	System.out.println("mbsearchAction id : "+request.getParameter("id"));
	 	MemberBean bean = memberdao.getDetailMember(request.getParameter("id"));
	 	request.setAttribute("MID",bean.getMID());
	 	request.setAttribute("MPW",bean.getMPW());
	 	request.setAttribute("MHNUM",bean.getMHNUM());
	 	request.setAttribute("MTELL",bean.getMTELL());
	 	request.setAttribute("MMAIL",bean.getMMAIL());
	 	request.setAttribute("ISADMIN",bean.getISADMIN());
	 	request.setAttribute("MNAME",bean.getMNAME());
	 	
   		ActionForward forward = new ActionForward();
   		forward.setRedirect(false);
		forward.setPath("admin/MemberViewPage.jsp"); 	
		System.out.println("seachAction 정상작동");
   		return forward;	
		
	}

}
