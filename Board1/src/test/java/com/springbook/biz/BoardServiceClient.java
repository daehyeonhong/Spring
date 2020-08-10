package com.springbook.biz;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.springbook.biz.board.BoardService;

public class BoardServiceClient {
	public static void main(String[] args) {
		/* 1. Spring Container 구동. */
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		/* 2. Spring Container로 부터 BoardService 얻기. */
		BoardService boardService = (BoardService) container.getBean("boardService");
		/* 3. 글 등록 기능 Test */
		BoardVO vo = new BoardVO();
		vo.setSeq(100);
		vo.setTitle("임시 제목");
		vo.setWriter("홍길동");
		vo.setContent("임시 내용");
		boardService.insertBoard(vo);
		/* 4. 글 목록 검색 기능 테스트 */

		/* 5. 자원 해제 */
		container.close();
	}
}