package paris.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class MembersearchAction implements Action {
	
		public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			System.out.println("mbsearchAction �۵�");
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
			forward.setPath("member/memberViewPage.jsp"); 	
			System.out.println("seachAction �����۵�");
	   		return forward;	
			
		}

	}