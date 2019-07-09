package net.promotion.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.main.action.ActionForward;

 public class PromotionFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		  if(command.equals("/associatedcard_info.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/associatedcard_info.jsp");
			   
		   }else if(command.equals("/event_view.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/event_view.jsp");
			   
		   }else if(command.equals("/event.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/event.jsp");
			   
		   }else if(command.equals("/pb_news_view.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/pb_news_view.jsp");
			   
		   }else if(command.equals("/pb_news.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/pb_news.jsp");
			   
		   }else if(command.equals("/prizewinner_view.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/prizewinner_view.jsp");
			   
		   }else if(command.equals("/prizewinner.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/prizewinner.jsp");
			   
		   }else if(command.equals("/pb_news_view.pr")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("promotion/pb_news_view.jsp");
			   
		   }
		  
		  
		  
		 
/*		   if(command.equals("/BoardWrite.bo")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./board/qna_board_write.jsp");
		   }else if(command.equals("/BoardReplyAction.bo")){
			   action = new BoardReplyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardDelete.bo")){
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("./board/qna_board_delete.jsp");
		}else if(command.equals("/BoardModify.bo")){
			   action = new BoardModifyView();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
	 	   }else if(command.equals("/BoardAddAction.bo")){
			   action  = new BoardAddAction();
			   try {
				   forward=action.execute(request, response );
			   } catch (Exception e) {
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardReplyView.bo")){
			   action = new BoardReplyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardModifyAction.bo")){
			   action = new BoardModifyAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardDeleteAction.bo")){
			   action = new BoardDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardList.bo")){
			   action = new BoardListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		   }else if(command.equals("/BoardDetailAction.bo")){
			   action = new BoardDetailAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }		 
		 }
		   */

		   
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