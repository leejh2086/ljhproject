package ljhproject.ljhproject.controller;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.PageDto;
import ljhproject.ljhproject.service.BoardService;
import ljhproject.ljhproject.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
        model.addAttribute("viewGame", pageService.selectGame(boardDto));
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
        return "free";
    }
    @GetMapping("/game")
    public String gameList(BoardDto boardDto, Model model,
                           @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                           @RequestParam(value = "cntPerPage", defaultValue = "10") int cntPerPage) {

        int total = pageService.countBoardGame();


        PageDto pageDto = new PageDto(total, nowPage, cntPerPage);
        boardDto.setAbc((nowPage-1) * cntPerPage);
        model.addAttribute("paging", pageDto);
        model.addAttribute("viewAllGame", pageService.selectGameAll(boardDto));
        System.out.println(boardDto);
        System.out.println(pageDto.getStartPage());
        System.out.println(pageDto.getEndPage());
        return "game";
    }
    @GetMapping("/pancake")
    public String pcbList(BoardDto boardDto, Model model,
                           @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                           @RequestParam(value = "cntPerPage", defaultValue = "10") int cntPerPage) {

        int total = pageService.countBoardPcb();


        PageDto pageDto = new PageDto(total, nowPage, cntPerPage);
        boardDto.setAbc((nowPage-1) * cntPerPage);
        model.addAttribute("paging", pageDto);
        model.addAttribute("viewAllPcb", pageService.selectPcbAll(boardDto));
        System.out.println(boardDto);
        System.out.println(pageDto.getStartPage());
        System.out.println(pageDto.getEndPage());
        return "pancake";
    }
    @GetMapping("/world")
    public String worldList(BoardDto boardDto, Model model,
                           @RequestParam(value = "nowPage", defaultValue = "1") int nowPage,
                           @RequestParam(value = "cntPerPage", defaultValue = "10") int cntPerPage) {

        int total = pageService.countBoardWorld();


        PageDto pageDto = new PageDto(total, nowPage, cntPerPage);
        boardDto.setAbc((nowPage-1) * cntPerPage);
        model.addAttribute("paging", pageDto);
        model.addAttribute("viewAllWorld", pageService.selectWorldAll(boardDto));
        System.out.println(boardDto);
        System.out.println(pageDto.getStartPage());
        System.out.println(pageDto.getEndPage());
        return "world";
    }

    @RequestMapping("boardDetail")
    public String Detail(@RequestParam("b_Id") int b_Id, Model model) {
        BoardDto boardDto = new BoardDto();
        boardDto.setB_Id(b_Id);
        model.addAttribute("boardDetail", pageService.selectDetail(boardDto));
        return "boardDetail"; // 상세 페이지 뷰 이름
    }

    @RequestMapping("boardUpdate")
    public String updateDetail(@RequestParam("b_Id") int b_Id, Model model) {
        BoardDto boardDto = new BoardDto();
        boardDto.setB_Id(b_Id);
        model.addAttribute("boardUpdate", pageService.selectDetail(boardDto));
        return "update"; // 상세 페이지 뷰 이름
    }

}