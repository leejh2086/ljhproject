package ljhproject.ljhproject.service;

import ljhproject.ljhproject.dao.PageDao;
import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageService {

    PageDao pageDao;

    @Autowired
    public PageService(PageDao pageDao) {this.pageDao = pageDao;}


    public List<PageDto> selectGame(BoardDto boardDto) {
        return pageDao.selectGame(boardDto);
    }
    public List<PageDto> selectGameAll(BoardDto boardDto) {
        return pageDao.selectGameAll(boardDto);
    }

    public List<PageDto> selectFree(BoardDto boardDto){

        return pageDao.selectFree(boardDto);
    }

    public List<PageDto> selectFreeAll(BoardDto boardDto){

        return pageDao.selectFreeAll(boardDto);
    }

    public List<PageDto> selectWorld(BoardDto boardDto){

        return pageDao.selectWorld(boardDto);
    }
    public List<PageDto> selectWorldAll(BoardDto boardDto){

        return pageDao.selectWorldAll(boardDto);
    }

    public List<PageDto> selectPcb(BoardDto boardDto){

        return pageDao.selectPcb(boardDto);
    }

    public List<PageDto> selectPcbAll(BoardDto boardDto){

        return pageDao.selectPcbAll(boardDto);
    }

    public BoardDto selectDetail(BoardDto boardDto){
        return pageDao.selectDetail(boardDto);

    }

    public int countBoardFree() {
        return pageDao.countBoardFree();
    }
    public int countBoardGame() {
        return pageDao.countBoardFree();
    }
    public int countBoardWorld() {
        return pageDao.countBoardFree();
    }
    public int countBoardPcb() {
        return pageDao.countBoardFree();
    }


}