package net.product.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ProductDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public ProductDAO() {
		try{
			Context init = new InitialContext();
	  		DataSource ds = 
	  			(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	  		con = ds.getConnection();
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	public List getProductList(String PBCLASS, String PSCLASS){
		//제품소개 페이지에서 데이터 받아오기
		String sql;
		
		if(PSCLASS!=null) {
			sql="SELECT * FROM PRODUCTDB where PBCLASS=? and PSCLASS=?";
		}else {
			sql="SELECT * FROM PRODUCTDB where PBCLASS=?";
		}
		List productlist=new ArrayList();
		
		try {
			pstmt=con.prepareStatement(sql);
			if(PSCLASS!=null) {
				pstmt.setString(1,PBCLASS);
				pstmt.setString(2,PSCLASS);
			}else {
				pstmt.setString(1,PBCLASS);
			}			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductBean beans = new ProductBean();
				beans.setPINDEX(rs.getInt("PINDEX"));
				beans.setPBCLASS(rs.getString("PBCLASS"));
				beans.setPBCLASS(rs.getString("PSCLASS"));
				beans.setPINTRO(rs.getString("PINTRO"));
				beans.setPALLERGY(rs.getString("PALLERGY"));
				beans.setPNUTRO(rs.getString("PNUTRO"));
				beans.setPPICTURE(rs.getString("PPICTURE"));
				beans.setPNAME(rs.getString("PNAME"));
				beans.setPLIKE(rs.getInt("PLIKE"));
				productlist.add(beans);
				
			}
			System.out.println("getProductList0 정상작동");
			return productlist;
		}catch(Exception ex) {
			System.out.println("getProductData Error");
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}  
		}
		return null;
	}
	public ProductBean getProductView(int PINDEX){
		String sql="SELECT * FROM PRODUCTDB where PINDEX=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,PINDEX);
			rs=pstmt.executeQuery();
			ProductBean beans = new ProductBean();
			while(rs.next()){
			beans.setPINDEX(rs.getInt("PINDEX"));
			beans.setPBCLASS(rs.getString("PBCLASS"));
			beans.setPBCLASS(rs.getString("PSCLASS"));
			beans.setPINTRO(rs.getString("PINTRO"));
			beans.setPALLERGY(rs.getString("PALLERGY"));
			beans.setPNUTRO(rs.getString("PNUTRO"));
			beans.setPPICTURE(rs.getString("PPICTURE"));
			beans.setPNAME(rs.getString("PNAME"));
			beans.setPLIKE(rs.getInt("PLIKE"));
			System.out.println("getProductData operate");
			}
			return beans;
		}catch(Exception ex) {
			System.out.println("getProductData Error");
		}finally {
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}  
		}
		
		
		return null;
	}
	public List getProductList2(){
		String sql="SELECT * FROM PRODUCTDB ORDER BY PINDEX";
		List productlist=new ArrayList();
		try {
			pstmt=con.prepareStatement(sql);			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				ProductBean beans = new ProductBean();
				beans.setPINDEX(rs.getInt("PINDEX"));
				beans.setPBCLASS(rs.getString("PBCLASS"));
				beans.setPSCLASS(rs.getString("PSCLASS"));
				beans.setPINTRO(rs.getString("PINTRO"));
				beans.setPALLERGY(rs.getString("PALLERGY"));
				beans.setPNUTRO(rs.getString("PNUTRO"));
				beans.setPPICTURE(rs.getString("PPICTURE"));
				beans.setPNAME(rs.getString("PNAME"));
				beans.setPLIKE(rs.getInt("PLIKE"));
				productlist.add(beans);
				
			}
			System.out.println("getProductList2 정상작동");
			return productlist;
		}catch(Exception ex) {
			System.out.println("getProductData Error");
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}  
		}
		return null;
	}
	
	
	public boolean deleteProduct(int id){
		String sql="DELETE FROM PRODUCTDB WHERE PINDEX=?";
		int result=0;
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		}catch(Exception ex){
			System.out.println("deleteProduct 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	public boolean AddProduct(ProductBean bean){
		String sql="INSERT INTO PRODUCTDB VALUES (?,?,?,?,?,?,?,?,?)";
		int result=0;
		System.out.println("AddProduct 작동");
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bean.getPINDEX());
			pstmt.setString(2, bean.getPBCLASS());
			pstmt.setString(3, bean.getPSCLASS());
			pstmt.setString(4, bean.getPINTRO());
			pstmt.setString(5, bean.getPALLERGY());
			pstmt.setString(6, bean.getPNUTRO());
			pstmt.setString(7, bean.getPPICTURE());
			pstmt.setString(8, bean.getPNAME());
			pstmt.setInt(9, bean.getPLIKE());
			result=pstmt.executeUpdate();
			
			if(result!=0){
				System.out.println("AddProduct 정상작동");
				return true;
			}
		}catch(Exception ex){
			System.out.println("AddProduct 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	
	public ProductBean getProductView2(String PNAME){
		String sql="SELECT * FROM PRODUCTDB where PNAME=?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,PNAME);
			rs=pstmt.executeQuery();
			ProductBean beans = new ProductBean();
			while(rs.next()){
			beans.setPINDEX(rs.getInt("PINDEX"));
			beans.setPBCLASS(rs.getString("PBCLASS"));
			beans.setPBCLASS(rs.getString("PSCLASS"));
			beans.setPINTRO(rs.getString("PINTRO"));
			beans.setPALLERGY(rs.getString("PALLERGY"));
			beans.setPNUTRO(rs.getString("PNUTRO"));
			beans.setPPICTURE(rs.getString("PPICTURE"));
			beans.setPNAME(rs.getString("PNAME"));
			beans.setPLIKE(rs.getInt("PLIKE"));
			System.out.println("getProductData operate");
			}
			return beans;
		}catch(Exception ex) {
			System.out.println("getProductData Error");
		}finally {
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}  
		}
		
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
