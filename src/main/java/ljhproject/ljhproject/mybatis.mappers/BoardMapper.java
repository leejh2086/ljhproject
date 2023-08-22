package ljhproject.ljhproject.mybatis.mappers;

import ljhproject.ljhproject.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

    @Mapper
    public interface BoardMapper {
        List<BoardDto> findAllBoard();

        void insertBoard(BoardDto boardDto);
    }

