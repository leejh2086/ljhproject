package ljhproject.ljhproject.dao;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import ljhproject.ljhproject.mybatis.mappers.PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PageDao {

    PageMapper pageMapper;
    @Autowired
    public PageDao(PageMapper pageMapper) { this.pageMapper = pageMapper; }

    public List<PageDto> selectFree(BoardDto boardDto) {
        return pageMapper.selectFree(boardDto);
    }
    public List<PageDto> selectFreeAll(BoardDto boardDto) {
        return pageMapper.selectFreeAll(boardDto);
    }
    public List<PageDto> selectGame(BoardDto boardDto) {
        return pageMapper.selectGame(boardDto);
    }
    public List<PageDto> selectGameAll(BoardDto boardDto) {
        return pageMapper.selectGameAll(boardDto);
    }
    public List<PageDto> selectWorld(BoardDto boardDto) {
        return pageMapper.selectWorld(boardDto);
    }
    public List<PageDto> selectWorldAll(BoardDto boardDto) {
        return pageMapper.selectWorldAll(boardDto);
    }
    public List<PageDto> selectPcb(BoardDto boardDto) {
        return pageMapper.selectPcb(boardDto);
    }
    public List<PageDto> selectPcbAll(BoardDto boardDto) {
        return pageMapper.selectPcbAll(boardDto);
    }
    public BoardDto selectDetail(BoardDto boardDto) {
        return pageMapper.selectDetail(boardDto);
    }


    public int countBoardFree() {
        return pageMapper.countBoardFree();
    }
    public int countBoardGame() { return pageMapper.countBoardGame(); }
    public int countBoardWorld() {
        return pageMapper.countBoardWorld();
    }
    public int countBoardPcb() {
        return pageMapper.countBoardPcb();
    }

    public void insertBoard(BoardDto boardDto){

        pageMapper.insertBoard(boardDto);
    }

    public void updateBoard(BoardDto boardDto){

        pageMapper.updateBoard(boardDto);
    }

    public void deleteBoard(BoardDto boardDto){

        pageMapper.deleteBoard(boardDto);
    }





}
