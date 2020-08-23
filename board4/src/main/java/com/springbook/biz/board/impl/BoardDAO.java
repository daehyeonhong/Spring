package com.springbook.biz.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.springbook.biz.BoardVO;
import com.springbook.biz.common.JDBCUtil;

//@Component("boardDAO")
//@Repository("boardDAO")
public class BoardDAO {
	//JDBC관련 변수
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;

	//SQL명령어
	private final String BOARD_INSERT="insert into board(seq,title,writer,content,uploadFile) values((select nvl(max(seq),0)+1 from board),?,?,?,?)";
	private final String BOARD_UPDATE="update board set title=?,content=? where seq=?";
	private final String BOARD_UPDATE_UPLOADFILE="update board set title=?,content=?,uploadFile=? where seq=?";
	private final String BOARD_DELETE="delete from board where seq=?";
	private final String BOARD_GET="select * from board where seq=?";
	//private final String BOARD_LIST="select * from board order by seq desc";
	private final String BOARD_LIST="select * from board where (title like '%'||?||'%' or  content like '%'||?||'%'  ) order by seq desc";
	private final String BOARD_LIST_T="select * from board where title like '%'||?||'%' order by seq desc";
	private final String BOARD_LIST_C="select * from board where content like '%'||?||'%' order by seq desc";
    private final String BOARD_UPDATE_CNT="update board set cnt=nvl(cnt,0)+1 where seq=?";
	
	//글등록 메소드
	public void insertBoard(BoardVO vo) {
		System.out.println("===> jdbc로 insertBoard()기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setString(4,vo.getUploadFile().getOriginalFilename());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
   //글 목록 조회
	public List<BoardVO> getBoardList(BoardVO vo) {
		System.out.println("===>JDBC로 getBoardLiist() 기능 처리");
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		try {
			      conn=JDBCUtil.getConnection();
			      if(vo.getSearchCondition().equals("TITLE")) {
			    	  pstmt=conn.prepareStatement(BOARD_LIST_T);
			      }else if(vo.getSearchCondition().equals("CONTENT")) {
			    	  pstmt=conn.prepareStatement(BOARD_LIST_C);
			      }else {
			    	  pstmt=conn.prepareStatement(BOARD_LIST);
			      }
          if(vo.getSearchCondition().equals("TITLE")|| 
        		    vo.getSearchCondition().equals("CONTENT")) {
			         pstmt.setString(1, vo.getSearchKeyword());
          }else if(vo.getSearchCondition().equals("")) {
        	  pstmt.setString(1, vo.getSearchKeyword());
        	  pstmt.setString(2, vo.getSearchKeyword());
          }
			    	  
			      rs=pstmt.executeQuery();
			      while(rs.next()) {
			    	  BoardVO board=new BoardVO();
			    	  board.setSeq(rs.getInt("seq"));
			    	  board.setTitle(rs.getString("title"));
			    	  board.setWriter(rs.getString("writer"));
			    	  board.setContent(rs.getString("content"));
			    	  board.setRegDate(rs.getDate("regdate"));
			    	  board.setCnt(rs.getInt("cnt"));
			    	  
			    	  boardList.add(board);
			      }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return boardList;
	}

	//글 상세 조회 메소드
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===>JDBC로 getBoard()기능 처리");
		  Connection conn=null;
		  PreparedStatement pstmt=null;
		  ResultSet rs=null;
		  BoardVO board=new BoardVO();
		  //조회수 증가 메소드 호출
		  updateBoardCnt(vo);
		  try {
			     conn=JDBCUtil.getConnection();
			     pstmt=conn.prepareStatement(BOARD_GET);
			     pstmt.setInt(1, vo.getSeq());
			     rs=pstmt.executeQuery();
			     if(rs.next()) {
			    	 board.setSeq(vo.getSeq());
			    	 board.setTitle(rs.getString("title"));
			    	 board.setWriter(rs.getString("writer"));
			    	 board.setContent(rs.getString("content"));
			    	 board.setRegDate(rs.getDate("regdate"));
			    	 board.setCnt(rs.getInt("cnt"));
			    	 board.setImages(rs.getString("uploadFile"));
			    	 //board.setImages("c:/upload/"+rs.getString("uploadFile"));
			     } 
		  }catch(Exception e) {
			  e.printStackTrace();
		  }finally {
			  JDBCUtil.close(rs, pstmt, conn);
		  }
		return board;
	}

	public void updateBoard(BoardVO vo) {
	   System.out.println("===>JDBC로 updateBoard()기능 처리");
	   try {
		   conn=JDBCUtil.getConnection();
		   //수정시 getBoard.jsp에서 uploadFile이 넘어오면  파일경로 수정
		   //안넘어오면 그대로 처리
		   MultipartFile uploadFile = vo.getUploadFile();
		   if(!uploadFile.isEmpty()) {
			   pstmt=conn.prepareStatement(BOARD_UPDATE_UPLOADFILE);
			   pstmt.setString(1, vo.getTitle());
			   pstmt.setString(2, vo.getContent());
			   pstmt.setString(3, uploadFile.getOriginalFilename());
			   pstmt.setInt(4, vo.getSeq());
		   }else {
		       pstmt=conn.prepareStatement(BOARD_UPDATE);
		       pstmt.setString(1, vo.getTitle());
		       pstmt.setString(2, vo.getContent());
		       pstmt.setInt(3, vo.getSeq());
		   }
		   pstmt.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   JDBCUtil.close(pstmt, conn);
	   }
	}

	public void deleteBoard(BoardVO vo) {
	   System.out.println("===>JDBC로 deleteBoard() 기능 처리");
	   try {
		       conn=JDBCUtil.getConnection();
		       pstmt=conn.prepareStatement(BOARD_DELETE);
		       pstmt.setInt(1, vo.getSeq());
		       pstmt.executeUpdate();
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   JDBCUtil.close(pstmt, conn);
	   }
	}
	//조회수 증가메소드
	public void updateBoardCnt(BoardVO vo) {
		   System.out.println("===>JDBC로 updateBoardCnt()기능 처리");
		   try {
			   conn=JDBCUtil.getConnection();
			   pstmt=conn.prepareStatement(BOARD_UPDATE_CNT);
			   pstmt.setInt(1, vo.getSeq());
			   pstmt.executeUpdate();
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   JDBCUtil.close(pstmt, conn);
		   }
		}
	
}
