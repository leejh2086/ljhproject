package ljhproject.ljhproject.controller;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import ljhproject.ljhproject.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    PageService pageService;

    @Autowired
    public PageController(PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/boardList")
    public String boardList(BoardDto boardDto, Model model,
                            @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                            @RequestParam(value = "cntPerPage", defaultValue = "11") int cntPerPage) {

        int total = pageService.countBoard();


        PageDto pageDto = new PageDto(total, nowPage, cntPerPage);
        boardDto.setAbc((nowPage-1) * cntPerPage);
        model.addAttribute("paging", pageDto);
        model.addAttribute("viewAll", pageService.selectBoard(boardDto));
        System.out.println(boardDto);
        System.out.println(pageDto.getStartPage());
        System.out.println(pageDto.getEndPage());
        return "/board.html";
    }
}