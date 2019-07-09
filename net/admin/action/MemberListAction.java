package net.admin.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.admin.*;
import paris.member.db.MemberDAO;

public class MemberListAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
	   		
	   		List memberlist=new ArrayList();
	   		memberlist=memberdao.getMemberList();

	   		
	   		request.setAttribute("memberlist", memberlist);
	   		forward.setRedirect(false);
	   		forward.setPath("admin/member_list.jsp");
	   		return forward;
	}
}