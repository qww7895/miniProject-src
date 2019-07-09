package paris.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paris.member.action.ActionForward;
import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class MemberJoinAction implements Action{
	 @SuppressWarnings("finally")
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	request.setCharacterEncoding("UTF-8");
		 	
		 	ActionForward forward = new ActionForward();
			MemberDAO memberdao=new MemberDAO();
	   		MemberBean member=new MemberBean();
	   		
	   		boolean result=false;
	   		
	   		
	   		System.out.println("this is MemberJoinAction");
	   		member.setMID(request.getParameter("MID"));
	   		member.setMPW(request.getParameter("MPW"));
	   		member.setMHNUM(request.getParameter("MHNUM"));
	   		member.setMTELL(request.getParameter("MTELL"));
	   		member.setMMAIL(request.getParameter("MMAIL"));
	   		member.setISADMIN(0);
	   		member.setMNAME(request.getParameter("MNAME"));
		  
		  
		  
	   		System.out.println(member.getMID());
	   		System.out.println(member.getMPW());
	   		System.out.println(member.getMHNUM());
	   		System.out.println(member.getMTELL());
	   		System.out.println(member.getMMAIL());
	   		System.out.println(member.getISADMIN());
	   		System.out.println(member.getMNAME());
	   		try {
	   		result=memberdao.joinMember(member);	
	   		
	   		if(result) {
		   		System.out.println("회원가입 성공");
		   		forward.setPath("main.gg");
		   		forward.setRedirect(false);
	   			   			
	   		}else {
	   			PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('회원가입 실패.');");
		   		out.println("location.href='Memberjoin.log';");
		   		out.println("</script>");
	   			System.out.println("회원가입 실패");
	   			forward.setPath("Memberjoin.log");	
	   			forward.setRedirect(true);
	   		}
	   		}catch(Exception ex) {
	   			PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('회원가입 실패.');");
		   		out.println("</script>");
	   			System.out.println("회원가입 실패");
	   			forward.setPath("Memberjoin.log");
	   			forward.setRedirect(true);
	   		}finally {
		   		
		   		return forward;	   			
	   		}
	   		
	   		//회원가입 성공.
	   		

	}
}