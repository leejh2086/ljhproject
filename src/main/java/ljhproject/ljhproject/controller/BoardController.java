package ljhproject.ljhproject.controller;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import ljhproject.ljhproject.service.BoardService;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

 @Controller
    public class BoardController {

        BoardService boardService;

        public BoardController(BoardService boardService) {
            this.boardService = boardService;
        }

        @Configuration
        public class WebConfig implements WebMvcConfigurer {

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                configurer.setUseRegisteredSuffixPatternMatch(true); // 대소문자 무시 설정
            }
        }


        @RequestMapping("/write")
        public String toWrite(Model model){

            return "write.html";
        }

        @PostMapping("/insert")
        public String BoardDto(BoardDto boardDto) {

            boardService.insertBoard(boardDto);
            return "/write.html";
        }

     @PutMapping("/update")
     public String updateBoard(BoardDto boardDto) {

         boardService.updateBoard(boardDto);
         return "redirect:/write.html";
     }

     @DeleteMapping("/delete")
     public String deleteBoard(BoardDto boardDto) {

         boardService.deleteBoard(boardDto);
         return "redirect:/write.html";
     }

     @RequestMapping("/free")
     public String toFree(Model model){

         return "free.html";
     }

     @RequestMapping("/game")
     public String toGame(Model model){

         return "game.html";
     }

     @RequestMapping("/world")
     public String toWorld(Model model){

         return "world.html";
     }

     @RequestMapping("/pancake")
     public String toPanCake(Model model){

         return "panCake.html";
     }

     @RequestMapping("/update")
     public String toUpdate(Model model){

         return "update.html";
     }


}

