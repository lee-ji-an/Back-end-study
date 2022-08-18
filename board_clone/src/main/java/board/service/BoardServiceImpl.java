package board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import board.dto.BoardDto;
import board.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
}
