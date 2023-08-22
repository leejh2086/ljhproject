package ljhproject.ljhproject.service;

import ljhproject.ljhproject.dao.BoardDao;
import ljhproject.ljhproject.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    BoardDao boardDao;

    @Autowired
    public BoardService(BoardDao boardDao){
        this.boardDao = boardDao;
    }

    public List<BoardDto> findAllBoard() {
        return boardDao.findAllBoard();
    }

    public void insertBoard(BoardDto boardDto){
        boardDao.insertBoard(boardDto);
    }


}
