package ljhproject.ljhproject.controller;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

 @Controller
    public class BoardController {

        BoardService boardService;

        public BoardController(BoardService boardService) {
            this.boardService = boardService;
        }

        @RequestMapping("/board")
        public String toBoard(Model model) {

            List<BoardDto> boardDtoList = boardService.findAllBoard();
            model.addAttribute("boardList", boardDtoList);

            return "/board.html";

        }

        @RequestMapping("/write")
        public String toWrite(Model model){

            return "write.html";
        }
}
