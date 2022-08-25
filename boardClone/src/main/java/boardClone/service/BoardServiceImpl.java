package boardClone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import boardClone.dto.BoardDto;
import boardClone.mapper.BoardMapper;

@Service
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

//	@Override
//	public BoardDto selectBoardDetail(int boardIdx) {
//		return 
//	}

}
