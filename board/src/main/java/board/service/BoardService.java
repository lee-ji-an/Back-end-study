package board.service;

import board.dto.BoardDto;
import java.util.List;

public interface BoardService {

	public List<BoardDto> selectBoardList() throws Exception;

	public void insertBoard(BoardDto board);
	
	public BoardDto selectBoardDetail(int boardIdx);

	public void updateBoard(BoardDto boardDto);

	public void deleteBoard(int boardIdx);


}
