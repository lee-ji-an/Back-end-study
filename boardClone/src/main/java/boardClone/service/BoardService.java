package boardClone.service;

import java.util.List;

import boardClone.dto.BoardDto;

public interface BoardService {

	public List<BoardDto> selectBoardList() throws Exception;

	public void insertBoard(BoardDto board);

	public BoardDto selectBoardDetail(int boardIdx);

}

