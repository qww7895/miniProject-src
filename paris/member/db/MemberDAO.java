package paris.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MemberDAO() {
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
	
	public int isMember(MemberBean member){
		String sql="SELECT MPW FROM MEMBER WHERE MID=?";
		int result=-1;
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMID());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				if(rs.getString("MPW").equals(
									member.getMPW())){
					result=1;//일치.
				}else{
					result=0;//불일치.
				}
			}else{
				result=-1;//아이디 존재하지 않음.
			}
		}catch(Exception ex){
			System.out.println("isMember 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return result;
	}
	
	public boolean joinMember(MemberBean member){
		String sql="INSERT INTO MEMBER VALUES (?,?,?,?,?,?,?)";
		int result=0;
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, member.getMID());
			pstmt.setString(2, member.getMPW());
			pstmt.setString(3, member.getMHNUM());
			pstmt.setString(4, member.getMTELL());
			pstmt.setString(5, member.getMMAIL());
			pstmt.setInt(6, member.getISADMIN());
			pstmt.setString(7, member.getMNAME());
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		}catch(Exception ex){
			System.out.println("joinMember 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	
	public List getMemberList(){
		String sql="SELECT * FROM MEMBER";
		List memberlist=new ArrayList();
		
		try{
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()){
				MemberBean mb=new MemberBean();
				mb.setMID(rs.getString("MID"));
				mb.setMPW(rs.getString("MPW"));
				mb.setMHNUM(rs.getString("MHNUM"));
				mb.setMTELL(rs.getString("MTELL"));
				mb.setMMAIL(rs.getString("MMAIL"));
				mb.setISADMIN(rs.getInt("ISADMIN"));
				mb.setMNAME(rs.getString("MNAME"));
				
				
				memberlist.add(mb);
			}
			
			return memberlist;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}  
		}
		return null;
	}
	
	public MemberBean getDetailMember(String id){
		String sql="SELECT * FROM MEMBER WHERE MID=?";
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			MemberBean mb=new MemberBean();
			while(rs.next()) {
			
			mb.setMID(rs.getString("MID"));
			mb.setMPW(rs.getString("MPW"));
			mb.setMHNUM(rs.getString("MHNUM"));
			mb.setMTELL(rs.getString("MTELL"));
			mb.setMMAIL(rs.getString("MMAIL"));
			mb.setISADMIN(rs.getInt("ISADMIN"));
			mb.setMNAME(rs.getString("MNAME"));
			}
			return mb;
		}catch(Exception ex){
			System.out.println("getDeatilMember 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	public boolean deleteMember(String id){
		String sql="DELETE FROM MEMBER WHERE MID=?";
		int result=0;
		
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			result=pstmt.executeUpdate();
			
			if(result!=0){
				return true;
			}
		}catch(Exception ex){
			System.out.println("deleteMember 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		
		return false;
	}
	public int IsAdmin(String MID) {
		String sql="SELECT ISADMIN FROM MEMBER where MID=?";
		System.out.println("admin check");
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, MID);
			rs=pstmt.executeQuery();
			rs.next();
			
			if(rs.getInt(1)==1)return 1;
			else return 0;
		}catch(Exception ex){
			System.out.println("IsAdmin 에러: " + ex);			
		}finally{
			if(con!=null) try{con.close();}catch(SQLException ex){}
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
		}
		return 0;
	}
	public boolean memeberModify(MemberBean modifymember) throws Exception{
		String sql="update MEMBER set MNAME=?,MID=?, MPW=?,MHNUM=?,MTELL=?,MMAIL=?,ISADMIN=?";
		sql+="where MID=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,modifymember.getMNAME());
			pstmt.setString(2,modifymember.getMID());
			pstmt.setString(3,modifymember.getMPW());
			pstmt.setString(4,modifymember.getMHNUM());
			pstmt.setString(5,modifymember.getMTELL());
			pstmt.setString(6,modifymember.getMMAIL());
			pstmt.setInt(7,modifymember.getISADMIN());
			pstmt.setString(8,modifymember.getMID());
			
			pstmt.executeUpdate();
			return true;
		}catch(Exception ex){
			System.out.println("boardModify 에러 : " + ex);
		}finally{
			if(rs!=null)try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null)try{pstmt.close();}catch(SQLException ex){}
			}
		return false;
	}	
	
}