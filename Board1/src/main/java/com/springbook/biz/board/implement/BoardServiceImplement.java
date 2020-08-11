package com.springbook.biz.board.implement;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;
import com.springbook.biz.BoardVO;
import com.springbook.biz.board.BoardService;

/*@Component("boardService")*/
@Service("boardService")
public class BoardServiceImplement implements BoardService {
	/* @Autowired */
	@Inject
	private BoardDAO boardDAO;

	@Override
	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	@Override
	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}