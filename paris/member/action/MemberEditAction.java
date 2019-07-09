package paris.member.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paris.member.action.ActionForward;
import paris.member.db.MemberBean;
import paris.member.db.MemberDAO;

public class MemberEditAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
			 	throws Exception{
				 request.setCharacterEncoding("euc-kr");
				 ActionForward forward = new ActionForward();
				 boolean result = false;
				 MemberDAO memdao = new MemberDAO();
				 MemberBean bean= new MemberBean();
				 try{
					 System.out.println("MID : "+request.getParameter("MID"));
					 System.out.println("MNAME : "+request.getParameter("MNAME"));
					 System.out.println("ISADMIN : "+request.getParameter("ISADMIN"));
					 bean.setMID((String)request.getParameter("MID"));
					 bean.setMPW((String)request.getParameter("MPW"));
					 bean.setMNAME((String)request.getParameter("MNAME"));
					 bean.setMHNUM((String)request.getParameter("MHNUM"));
					 bean.setMTELL((String)request.getParameter("MTELL"));
					 bean.setMMAIL((String)request.getParameter("MMAIL"));
					 bean.setISADMIN(Integer.parseInt( request.getParameter("ISADMIN")));
					 result =memdao.memeberModify(bean);

					 MemberDAO memberdao2=new MemberDAO();	
				   		List memberlist=new ArrayList();
				   		memberlist=memberdao2.getMemberList();
				   		request.setAttribute("memberlist", memberlist);		   		
				   		forward.setRedirect(false);
				   		forward.setPath("Membersearch.log");
					 if(result==false) {
						 PrintWriter out=response.getWriter();
					   		out.println("<script>");
					   		out.println("alert('멤버 수정 실패.');");
					   		out.println("</script>");
					   		return forward;
					 }
			   	 }catch(Exception ex){
			   			ex.printStackTrace();	 
				 }
				 return forward;
				 
			 }
		}