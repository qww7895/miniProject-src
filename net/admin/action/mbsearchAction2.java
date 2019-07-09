package net.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.action.Action;
import net.admin.action.ActionForward;
import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class mbsearchAction2 implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
	 	MemberDAO memberdao=new MemberDAO();
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
		forward.setPath("admin/memberedit.jsp"); 	
		System.out.println("seachAction2 정상작동");
   		return forward;	
		
	}

}
