package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import board.dto.BoardDto;
import board.service.BoardService;

// @Controller와 @ResponseBody 어노테이션을 결합한 형태
// 해당 API의 응답 결과를 JSON 형식으로 변환해서 응답 본문으로 전송 
@RestController
public class RestBoardApiController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/api/board", method=RequestMethod.GET)
	public List<BoardDto> openBoardList() throws Exception {
		return boardService.selectBoardList();
	}
	
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.GET)
	public BoardDto openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		return boardService.selectBoardDetail(boardIdx);
	}

	@RequestMapping(value="/api/board/write", method=RequestMethod.POST)
	public void insertBoard(@RequestBody BoardDto board) throws Exception {
		boardService.insertBoard(board, null);
	}
	
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.PUT)
	public void updateBoard(@RequestBody BoardDto boardDto) throws Exception {
		boardService.updateBoard(boardDto);
	}
	
	@RequestMapping(value="/api/board/{boardIdx}", method=RequestMethod.DELETE)
	public void deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
	}
}
