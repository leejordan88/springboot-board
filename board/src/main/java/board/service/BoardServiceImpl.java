package board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import board.common.FileUtils;
import board.dto.BoardDto;
import board.dto.BoardFileDto;
import board.mapper.BoardMapper;

@Service
@Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Autowired
	private FileUtils fileUtils;
	
	@Override
	public List<BoardDto> selectBoardList() throws Exception {
		return boardMapper.selectBoardList();
	}
	@Override
	public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
		boardMapper.insertBoard(board);
		int newBoardIdx = boardMapper.getNewBoardIdx();
		List<BoardFileDto> list = fileUtils.parseFileInfo(newBoardIdx, multipartHttpServletRequest);
		if(CollectionUtils.isEmpty(list) == false) {
			boardMapper.insertBoardFileList(list);
		}
//		if(ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
//			Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
//			String name;
//			while(iterator.hasNext()) {
//				name = iterator.next();
//				log.debug("file tag name: " + name);
//				List<MultipartFile> list = multipartHttpServletRequest.getFiles(name);
//				for(MultipartFile multipartFile : list) {
//					log.debug("start file information");
//					log.debug("file name : " + multipartFile.getOriginalFilename());
//					log.debug("file size : " + multipartFile.getSize());
//					log.debug("file content type : " + multipartFile.getContentType());
//					log.debug("end file information.\n");
//				}
//			}
//		}
	}
	
	@Override
	public void updateHitCount(int boardIdx) throws Exception {
		boardMapper.updateHitCount(boardIdx);
	}
	@Override
	public BoardDto selectBoardDetail(int boardIdx) throws Exception {
		BoardDto boardDto = boardMapper.selectBoardDetail(boardIdx);
		List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
		boardDto.setFileList(fileList);
		
		updateHitCount(boardIdx);
//		int i = 10 / 0;
		return boardDto;
	}
	@Override
	public void updateBoard(BoardDto boardDto) throws Exception {
		boardMapper.updateBoard(boardDto);
	}
	@Override
	public void deleteBoard(int boardIdx) throws Exception {
		boardMapper.deleteBoard(boardIdx);
		
	}
	@Override
	public BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
		return boardMapper.selectBoardFileInformation(idx, boardIdx);
	}


}
