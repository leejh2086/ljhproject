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

    public List<PageDto> selectBoard(BoardDto boardDto) {
        return pageMapper.selectBoard(boardDto);
    }

    public int countBoard() {
        return pageMapper.countBoard();
    }




}
