package board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import board.dto.BoardDto;

@Mapper
public interface BoardMapper {

	public List<BoardDto> selectBoardList() throws Exception;
}