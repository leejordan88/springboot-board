package board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.dto.BoardDto;
import board.dto.BoardFileDto;

public interface BoardService {
	List<BoardDto> selectBoardList() throws Exception;

	void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception;
	
	void updateHitCount(int boardIdx) throws Exception;
	
	BoardDto selectBoardDetail(int boardIdx) throws Exception;

	void updateBoard(BoardDto boardDto) throws Exception;

	void deleteBoard(int boardIdx) throws Exception;

	BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception;
}
