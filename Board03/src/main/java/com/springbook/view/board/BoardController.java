package com.springbook.view.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import com.springbook.biz.BoardVO;
import com.springbook.biz.board.BoardService;

@Controller
@SessionAttributes("board") /* null update 방지 */
public class BoardController {

	@Autowired
	private BoardService boardService;

	/* 글 입력 */
	@RequestMapping(value = "insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
		/* File_Upload */
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/upload/" + fileName));/* 지정 경로로 파일 저장 */
		}
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}

	/* 검색 조건 목록 설정 */
	/* @ModelAttribute("속성 명") 리턴 값은 객체로 리턴 */
	/* View_Page로 전달 시 Model Object에 저장됨 */
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("전체", null);
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

	/* 글 상세 조회 */
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.printf("글 번호: %s\n", vo.getSeq());
		/* vo.setImages("c:/upload" + vo.getImages()); */
		model.addAttribute("board", boardService.getBoard(vo));/* Model View 전송 */
		return "getBoard.jsp";/* View_Name return */
	}

	/* 글 수정 */
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo) throws IllegalStateException, IOException {
		/* File_Upload */
		MultipartFile uploadFile = vo.getUploadFile();
		if (!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("c:/upload/" + fileName));/* 지정 경로로 파일 저장 */
		}
		boardService.updateBoard(vo);
		return "getBoardList.do";
	}

	/* 글 삭제 */
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}

}