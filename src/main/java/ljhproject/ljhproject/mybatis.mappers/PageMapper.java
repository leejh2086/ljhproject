package ljhproject.ljhproject.mybatis.mappers;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PageMapper {
    List<PageDto> selectFree(BoardDto boardDto);
    List<PageDto> selectFreeAll(BoardDto boardDto);
    List<PageDto> selectGame(BoardDto boardDto);
    List<PageDto> selectGameAll(BoardDto boardDto);
    List<PageDto> selectWorld(BoardDto boardDto);
    List<PageDto> selectWorldAll(BoardDto boardDto);
    List<PageDto> selectPcb(BoardDto boardDto);
    List<PageDto> selectPcbAll(BoardDto boardDto);

    int countBoardFree();
    int countBoardGame();
    int countBoardWorld();
    int countBoardPcb();
}
