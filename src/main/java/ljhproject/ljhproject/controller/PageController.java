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

    @GetMapping("/")
    public String boardList(BoardDto boardDto, Model model,
                            @RequestParam(value = "cntPerPage", defaultValue = "6") int cntPerPage) {

        model.addAttribute("viewFree", pageService.selectFree(boardDto));
        model.addAttribute("viewGame", pageService.selectBoard(boardDto));
        model.addAttribute("viewWorld", pageService.selectWorld(boardDto));
        model.addAttribute("viewPcb", pageService.selectPcb(boardDto));
        return "index";

    }
    @GetMapping("/free")
    public String freeList(BoardDto boardDto, Model model,
                            @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                            @RequestParam(value = "cntPerPage", defaultValue = "10") int cntPerPage) {

        int total = pageService.countBoardFree();


        PageDto pageDto = new PageDto(total, nowPage, cntPerPage);
        boardDto.setAbc((nowPage-1) * cntPerPage);
        model.addAttribute("paging", pageDto);
        model.addAttribute("viewAllFree", pageService.selectFreeAll(boardDto));
        System.out.println(boardDto);
        System.out.println(pageDto.getStartPage());
        System.out.println(pageDto.getEndPage());
        return "/free.html";
    }

}