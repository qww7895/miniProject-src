package net.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.action.ActionForward;
import paris.member.db.MemberDAO;
import paris.member.db.MemberBean;


public class mbDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		 	ActionForward forward = new ActionForward();
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();  
	   		
			boolean result=false;
	   		String deleteId=request.getParameter("id");
	   		result=memberdao.deleteMember(request.getParameter("id"));
	   		if(result==false){
	   			System.out.println("ȸ�� ���� ����");
		   		return null;
		   	}
		

		 
			MemberDAO memberdao2=new MemberDAO();
	   		
	   		List memberlist=new ArrayList();
	   		memberlist=memberdao2.getMemberList();

	   		
	   		request.setAttribute("memberlist", memberlist);
	   		
	   		forward.setRedirect(false);
	   		forward.setPath("admin/member_list.jsp");
	   		return forward;
	}
}