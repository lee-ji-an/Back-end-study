package board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestBoardController {

	@Autowired
	private BoardService boardService;
	
	// 게시판 수정 
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.PUT)
	public String updateBoard(BoardDto boardDto) throws Exception {
		boardService.updateBoard(boardDto);
		return "redirect:/board";
	}
	
	// 게시판 삭제
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.DELETE)
	public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
		boardService.deleteBoard(boardIdx);
		return "redirect:/board";
	}	
	
	// 게시판 상세 화면
	@RequestMapping(value="/board/{boardIdx}", method=RequestMethod.GET)
	public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/board/restBoardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	// 첨부파일 다운로드
	@RequestMapping(value="/board/file", method=RequestMethod.GET)
	public void downloadBoardFile(@RequestParam int idx, @RequestParam int boardIdx, HttpServletResponse response) throws Exception {
		BoardFileDto boardFileDto = boardService.selectBoardFileInfo(idx, boardIdx);
		if (!ObjectUtils.isEmpty(boardFileDto)) {
			String fileName = boardFileDto.getOriginalFileName();
			byte[] files = FileUtils.readFileToByteArray(new File(boardFileDto.getStoredFilePath()));
			
			response.setContentType("application/octet-stream");
			response.setContentLength(files.length);
			response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(fileName, "UTF-8") + "\";");
			response.setHeader("Content-Transfer-Encoding", "binary");
			
			response.getOutputStream().write(files);
			response.getOutputStream().flush();
			response.getOutputStream().close();			
		}
	}

	
	// 게시판 작성 화면
	@RequestMapping(value="/board/write", method=RequestMethod.GET)
	public String openBoardWrite() throws Exception {
		return "/board/restBoardWrite";
	}
	
	// 게시판 작성
	@RequestMapping(value="/board/write", method=RequestMethod.POST)
	public String insertBoard(BoardDto board, MultipartHttpServletRequest request) throws Exception {
		boardService.insertBoard(board, request);
		return "redirect:/board";		
	}
		
	// 게시판 목록
	// @RequestMapping(value="/board", method=RequestMethod.GET)
	@GetMapping("/board")
	public ModelAndView openBoardList() throws Exception {

		ModelAndView mv = new ModelAndView("/board/restBoardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
