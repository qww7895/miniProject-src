package paris.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class Membersearch2Action implements Action {

	@Override
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
forward.setPath("member/memberedit.jsp"); 	
System.out.println("seachAction2 �����۵�");
	return forward;	

}

}
