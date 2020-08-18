package com.springbook.view.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import com.springbook.biz.BoardVO;
import com.springbook.biz.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	/* 글 입력 */
	@RequestMapping(value = "insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	/* 검색 조건 목록 설정 */
	/* @ModelAttribute("속성 명") 리턴 값은 객체로 리턴 */
	/* View_Page로 전달 시 Model Object에 저장됨 */
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	/* 글 목록 검색 */
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {/* Model:view로 Object 전달. */
		if (vo.getSearchCondition() == null) {
			vo.setSearchCondition("TITLE");
		}
		if (vo.getSearchKeyword() == null) {
			vo.setSearchKeyword("");
		}
		model.addAttribute("boardList", boardService.getBoardList(vo));
		return "getBoardList.jsp";
	}

}