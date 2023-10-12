package ljhproject.ljhproject.controller;

import ljhproject.ljhproject.dto.BoardDto;
import ljhproject.ljhproject.dto.LoginDto;
import ljhproject.ljhproject.dto.PageDto;
import ljhproject.ljhproject.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        return "free";
    }
    @RequestMapping("/free")
    public String toFree(Model model){

        return "free.html";
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
    @RequestMapping("/game")
    public String toGame(Model model){

        return "game.html";
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

        return "world";
    }
    @RequestMapping("/world")
    public String toWorld(Model model){

        return "world.html";
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

        return "pancake";
    }
    @RequestMapping("/pancake")
    public String toPancake(Model model){

        return "pancake.html";
    }


    @RequestMapping("boardDetail")
    public String Detail(@RequestParam("b_Id") int b_Id, Model model) {
        BoardDto boardDto = new BoardDto();
        boardDto.setB_Id(b_Id);
        model.addAttribute("boardDetail", pageService.selectDetail(boardDto));
        return "boardDetail"; // 상세 페이지 뷰 이름
    }

    @PostMapping("/insert")
    public String insertBoard(BoardDto boardDto) {


        pageService.insertBoard(boardDto);

        if (boardDto.getB_Category() == 1) {
            return "redirect:/free";
        } else if (boardDto.getB_Category() == 2) {
            return "redirect:/game";
        } else if (boardDto.getB_Category() == 3) {
            return "redirect:/world";
        } else if (boardDto.getB_Category() == 4) {
            return "redirect:/pancake";
        } else {
            // 다른 조건이나 예외 처리를 원하는 경우에 대한 기본 리다이렉트 설정
            return "redirect:/write";
        }
    }
    @RequestMapping("/update")
    public String updateDetail(@RequestParam("b_Id") int b_Id, Model model) {
        BoardDto boardDto = new BoardDto();
        boardDto.setB_Id(b_Id);
        model.addAttribute("boardUpdate", pageService.selectDetail(boardDto));
        return "update"; // 상세 페이지 뷰 이름
    }

    @PostMapping("/update")
    public String UpdateBoard(BoardDto boardDto){

        pageService.updateBoard(boardDto);
        if (boardDto.getB_Category() == 1) {
            return "redirect:/boardDetail?b_Id=" + boardDto.getB_Id();
        } else if (boardDto.getB_Category() == 2) {
            return "redirect:/boardDetail?b_Id=" + boardDto.getB_Id();
        } else if (boardDto.getB_Category() == 3) {
            return "redirect:/boardDetail?b_Id=" + boardDto.getB_Id();
        } else if (boardDto.getB_Category() == 4) {
            return "redirect:/boardDetail?b_Id=" + boardDto.getB_Id();
        } else {
            // 다른 조건이나 예외 처리를 원하는 경우에 대한 기본 리다이렉트 설정
            return "redirect:/write";
        }
    }

    @RequestMapping("/delete")
    public String DeleteBoard(BoardDto boardDto, @RequestParam int bid) {
        boardDto.setB_Id(bid);
        pageService.deleteBoard(boardDto);
        return "redirect:/";
    }


    @GetMapping("/login")
    public String goLogin(@ModelAttribute LoginDto loginDto) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Validated @ModelAttribute LoginDto loginDto, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()){

            return "login";
        }

        return "redirect:/";
    }


    @RequestMapping("/jMemberShip")
    public String toMemberShip(Model model){

        return "jMemberShip.html";
    }




}