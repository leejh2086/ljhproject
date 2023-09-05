package ljhproject.ljhproject.dao;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.mybatis.mappers.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardDao {

    BoardMapper boardMapper;

    @Autowired
    public BoardDao(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    public List<BoardDto> findAllBoard() {

        return boardMapper.findAllBoard();
    }

    public void insertBoard(BoardDto boardDto){

        boardMapper.insertBoard(boardDto);
    }

    public void updateBoard(BoardDto boardDto){

        boardMapper.updateBoard(boardDto);
    }

    public void deleteBoard(BoardDto boardDto){

        boardMapper.updateBoard(boardDto);
    }
}
