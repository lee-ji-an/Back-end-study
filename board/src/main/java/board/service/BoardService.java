package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.dto.BoardDto;
import board.dto.BoardFileDto;

public interface BoardService {

	public List<BoardDto> selectBoardList() throws Exception;

	public void insertBoard(BoardDto board, MultipartHttpServletRequest request) throws Exception;
	
	public BoardDto selectBoardDetail(int boardIdx);

	public void updateBoard(BoardDto boardDto);

	public void deleteBoard(int boardIdx);

	public BoardFileDto selectBoardFileInfo(int idx, int boardIdx) throws Exception;

}
