package boardClone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import boardClone.dto.BoardDto;
import boardClone.mapper.BoardMapper;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}

	@Override
	public void insertBoard(BoardDto board) {
		boardMapper.insertBoard(board);
	}

	@Override
	public BoardDto selectBoardDetail(int boardIdx) {
		boardMapper.updateHitCount(boardIdx);
		return boardMapper.selectBoardDetail(boardIdx);
	}

	@Override
	public  void updateBoard(BoardDto boardDto) {
		boardMapper.updateBoard(boardDto);
	}

	@Override
	public void deleteBoard(int boardIdx) {
		boardMapper.deleteBoard(boardIdx);		
	}

}
