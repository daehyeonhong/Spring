package com.springbook.biz.board;

import java.util.List;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.springbook.biz.BoardVO;

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
		List<BoardVO> boardList = boardService.getBoardList(vo);
		for (BoardVO board : boardList) {
			System.out.printf("--> %s\n", board.toString());
		}

		/* 4-1. 글 상세 보기 */
		BoardVO boardSeq = new BoardVO();
		boardSeq.setSeq(1);
		BoardVO board = boardService.getBoard(boardSeq);
		System.out.printf("글 상세 조회:\n--> %s\n", board);

		/* 4-2. 글 수정 */
		boardSeq.setSeq(2);
		boardSeq.setTitle("수정 제목");
		boardSeq.setContent("수정 내용");

		/* 수정 처리 */
		boardService.updateBoard(boardSeq);

		/* 수정 내용 조회 */
		board = boardService.getBoard(boardSeq);
		System.out.printf("글 수정 결과:\n--> %s\n", board);

		/* 4-3. 글 삭제 */
		vo.setSeq(7);
		boardService.deleteBoard(vo);

		/* 5. 자원 해제 */
		container.close();

	}
}