package paris.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class MemberFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 static final long serialVersionUID = 1L;
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		   
		   if(command.equals("/MemberLogin.log")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("member/loginForm.jsp");
		   }else if(command.equals("/MemberJoin.log")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("member/joinForm.jsp");
		   }else if(command.equals("/MemberLoginAction.log")){
			   action = new MemberLoginAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/MemberJoinAction.log")){
			   action = new MemberJoinAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		} /*
			 * else if(command.equals("/MemberListAction.log")){ action = new
			 * MemberListAction(); try{ forward=action.execute(request, response);
			 * }catch(Exception e){ e.printStackTrace(); } }
			 */else if(command.equals("/MemberViewAction.log")){
			   action = new MemberViewAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/MemberDeleteAction.log")){
			   action = new MemberDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/JoinForm.log")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("member/joinForm.jsp");
			   
		   }else if(command.equals("/MemberLogout.log")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("member/logout.jsp");
		   }else if(command.equals("/MemberJoinAction.log")){
			   action = new MemberJoinAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/Membersearch.log")){
			   action = new MembersearchAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/Memberedit.log")){
			   action = new Membersearch2Action();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/editaction.log")) {
				  System.out.println("editaction.log 작동");
				   action = new myEditAction();
				   try {
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
			  }else if(command.equals("/MemberDelete2Action.log")) {
				  System.out.println("MemberDelete2Action.log 작동");
				   action = new MemberDelete2Action();
				   try {
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				   }
			  }
		   
		   
		   
		   if(forward.isRedirect()){
			   response.sendRedirect(forward.getPath());
		   }else{
			   RequestDispatcher dispatcher=
				   request.getRequestDispatcher(forward.getPath());
			   dispatcher.forward(request, response);
		   }
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}   	  	      	    
}