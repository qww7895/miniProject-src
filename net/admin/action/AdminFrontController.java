package net.admin.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class AdminFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
		   
		 	if(command.equals("/manager.ad")){
				   System.out.println("manager.ad 작동");		 		
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("admin/manage.jsp");
			   
		   }else if(command.equals("/member_list.ad")){
			   System.out.println("member_list.ad 작동");			   
			   action = new MemberListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }  
		   }else if(command.equals("/MemberDeleteAction.ad")){
			   System.out.println("MemberDeleteAction.ad 작동");
			   action = new mbDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }  
		   } else if(command.equals("/MemberViewPage.ad")) {
			   System.out.println("MemberViewPage.ad 작동");
			   action = new mbsearchAction();
			   try {
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		  }else if(command.equals("/Memberedit.ad")) {
			  System.out.println("Memberedit.ad 작동");
			   action = new mbsearchAction2();
			   try {
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		  }else if(command.equals("/editaction.ad")) {
			  System.out.println("editaction.ad 작동");
			   action = new mbeditaction();
			   try {
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }
		  }else if(command.equals("/product_list.ad")){
			  System.out.println("product_list.ad 작동");
			   action = new ProductListAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }  
		   }else if(command.equals("/ProductDeleteAction.ad")){
			   System.out.println("ProductDeleteAction.ad 작동");
			   action = new pdDeleteAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			   }  
		   }else if(command.equals("/ProductViewAction.ad")){
			   System.out.println("ProductViewAction.ad 작동");
			   action=new ProductViewAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			}
			   
		   }else if(command.equals("/Productsearch.ad")){
			   action=new pdsearchAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			}
		   }else if(command.equals("/productAdd.ad")){
			   System.out.println("productAdd.ad 작동");
			   forward=new ActionForward();
			   forward.setRedirect(false);
			   forward.setPath("admin/productAdd.jsp");
			   
		   }else if(command.equals("/productAddAction.ad")){
			   System.out.println("productAddAction.ad 작동");
			   action=new productAddAction();
			   try{
				   forward=action.execute(request, response);
			   }catch(Exception e){
				   e.printStackTrace();
			}
			   
		   }else {
			   System.out.print(command.toString());
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