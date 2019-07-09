package net.product.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.product.action.ActionForward;

 public class ProductFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		   
		 	if(command.equals("/coupon_info.pb")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("product/coupon_info.jsp");
				   
			   }else if(command.equals("/list_new.pb")){
				   forward=new ActionForward();
				   forward.setRedirect(false);
				   forward.setPath("product/list_new.jsp");
				   
			   }else if(command.equals("/list.pb")){
				   action=new productListaction();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				}
				   
			   }else if(command.equals("/view.pb")){
				   action=new productViewAction();
				   try{
					   forward=action.execute(request, response);
				   }catch(Exception e){
					   e.printStackTrace();
				}
				   
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