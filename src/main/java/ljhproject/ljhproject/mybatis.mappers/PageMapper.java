package ljhproject.ljhproject.mybatis.mappers;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
    List<PageDto> selectBoard(BoardDto boardDto);

    int countBoard();
}
