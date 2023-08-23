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


    public List<PageDto> selectBoard(BoardDto boardDto) {
        return pageDao.selectBoard(boardDto);}

    public int countBoard() {
        return pageDao.countBoard();
    }


}