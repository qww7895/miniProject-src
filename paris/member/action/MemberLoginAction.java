package paris.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;  

public class MemberLoginAction implements Action{
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 	ActionForward forward = new ActionForward();
		 	
		 	HttpSession session=request.getSession();
			MemberDAO memberdao=new MemberDAO();
	   		MemberBean member=new MemberBean();
	   		
	   		int result=-1;
	   		
	   		member.setMID(request.getParameter("MID"));
	   		member.setMPW(request.getParameter("MPW"));
	   		result=memberdao.isMember(member);
	   		if(result==0){
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('비밀번호가 일치하지 않습니다.');");
		   		out.println("location.href='MemberLogin.log';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
	   		}else if(result==-1){
	   			response.setContentType("text/html;charset=euc-kr");
		   		PrintWriter out=response.getWriter();
		   		out.println("<script>");
		   		out.println("alert('아이디가 존재하지 않습니다.');");
		   		out.println("location.href='MemberLogin.log';");
		   		out.println("</script>");
		   		out.close();
		   		return null;
		   	}
	   		
	   		//로그인 성공.
	   		MemberDAO memberdao2 = new MemberDAO();
	   		session.setAttribute("id", member.getMID());
	   		session.setAttribute("admin", memberdao2.IsAdmin(member.getMID()));
	   		PrintWriter out=response.getWriter();
	   		
	   		
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("main.gg");
	   		return forward;
	}
}