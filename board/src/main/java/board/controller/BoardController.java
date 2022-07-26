package board.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.service.BoardService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {

	//private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService boardService;
	
//	@Autowired
//	private FileUtils fileUtils;
	
	@RequestMapping("/board/downloadBoardFile.do")
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

	//게시판 수정
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto boardDto) throws Exception{
		boardService.updateBoard(boardDto);
		return "redirect:/board/openBoardList.do";
	}
	//삭제 처리
	@RequestMapping("/board/deleteBoard.do")
	public String updateBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
	
	//게시판 등록
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board", board);
		
		return mv;
	}
	
	// 	글쓰기 페이지에 대한 요청 처리 
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception {
		return "/board/boardWrite";
	}
	
	//	글저장 처리에 대한 요청 처리
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board, MultipartHttpServletRequest request) throws Exception {
		boardService.insertBoard(board, request);
		return "redirect:/board/openBoardList.do";		
	}
		
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception {
		log.trace("openBoardList() is called by trace");
		log.debug("openBoardList() is called by debug");
		log.info("openBoardList() is called by info");
		
		ModelAndView mv = new ModelAndView("/board/boardList");
		
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list", list);
		
		return mv;
	}
}
