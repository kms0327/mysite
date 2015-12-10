package com.hanains.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.mysite.vo.BoardVo;
import com.hanains.mysite.vo.GuestBookVo;

public class BoardDao {
	private Connection getConnection(){
		Connection connection = null;
		
		try{
			//1.driver loading
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//2.db connect
			String dbUrl = "jdbc:oracle:thin:@localhost:1522:xe";
			connection = DriverManager.getConnection(dbUrl,"webdb","webdb");
			
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패 - "+e);
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}
		return connection;
	}
	
	public List<GuestBookVo> getList(){
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			
			connection = getConnection();
			//3.statement make
			stmt = connection.createStatement();
			//4.sql execute
			String sql="select * from board ORDER BY no desc";
			rs = stmt.executeQuery(sql);
			//5.result get
			while(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String member_no = rs.getString(4);
				String view_cnt = rs.getString(5);
				String date = rs.getString(6);
				
				GuestBookVo vo = new GuestBookVo();
				vo.setNo(no);
				vo.setName(title);
				vo.setPassword(content);
				vo.setMessage(member_no);
				vo.setDate(view_cnt);
				vo.setDate(date);
				
				list.add(vo);
			}
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(rs!=null)rs.close();
				if(stmt!=null)stmt.close();
				if(connection!=null)connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void insert(BoardVo vo){
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
			connection = getConnection();
			
			String sql = "insert into board values(board_no_seq.nextval,?,?,?,?,SYSDATE)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getMemberNo());
			pstmt.setString(4, "1");
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				System.out.println("에러- "+e);
				e.printStackTrace();
			}
		}
	}
	
	public void Delete(GuestBookVo vo){
		Connection connection = null;
		PreparedStatement pstmt = null;
		try{
			connection = getConnection();
			
			String sql = "delete from guestbook where no =? AND password = ?";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getNo());
			pstmt.setString(2, vo.getPassword());
			
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("에러 - "+e);
		}finally{
			try{
				if(pstmt!=null) pstmt.close();
				if(connection!=null) connection.close();
			}catch(SQLException e){
				System.out.println("에러- "+e);
				e.printStackTrace();
			}
		}
	}
}
