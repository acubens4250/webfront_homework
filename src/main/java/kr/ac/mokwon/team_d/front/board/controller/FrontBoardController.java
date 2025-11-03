package kr.ac.mokwon.team_d.front.board.controller;

import jakarta.servlet.http.HttpServletRequest;
import kr.ac.mokwon.team_d.front.board.service.impl.FrontBoardServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class FrontBoardController {

    @Autowired
    private FrontBoardServiceImpl frontBoardServiceImpl;

    @GetMapping("")
    public String boardListRedirect(
        Model model
    ) {
        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String boardList(
        Model model
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();
        Map<String, Object> resultMap = frontBoardServiceImpl.selectBoardListService(dataMap);
        model.addAttribute("result", resultMap);

        return "front/board/list";
    }

    @GetMapping("/detail/{reg_no}")
    public String boardDetail(
        Model model,
        @PathVariable int reg_no
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();
        System.err.println(reg_no);
        dataMap.put("reg_no", reg_no);

        Map<String, Object> resultMap = frontBoardServiceImpl.selectOneBoardService(dataMap);
        model.addAttribute("result", resultMap);

        return "front/board/detail";
    }

    @GetMapping("/register")
    public String frontBoardRegister() {

        return "front/board/register";
    }

    @PostMapping("/modify")
    public String frontBoardModify(
        Model model,
        HttpServletRequest request
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();
        int regNo = Integer.parseInt(request.getParameter("reg_no"));

        System.err.println(regNo);
        dataMap.put("reg_no", regNo);

        Map<String, Object> resultMap = frontBoardServiceImpl.selectOneBoardService(dataMap);
        model.addAttribute("result", resultMap);

        return "front/board/modify";
    }

    @PostMapping("/insert")
    public String frontBoardInsert(
        HttpServletRequest request
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();

        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        dataMap.put("title", title);
        dataMap.put("contents", contents);

        Map<String, Object> resultMap = frontBoardServiceImpl.insertBoardService(dataMap);

        boolean result = (boolean) resultMap.get("result");

        if(result) {
            return "redirect:/board/list";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/update")
    public String frontBoardUpdate(
            HttpServletRequest request
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();

        int regNo = Integer.parseInt(request.getParameter("reg_no"));
        String title = request.getParameter("title");
        String contents = request.getParameter("contents");

        dataMap.put("reg_no", regNo);
        dataMap.put("title", title);
        dataMap.put("contents", contents);

        Map<String, Object> resultMap = frontBoardServiceImpl.updateBoardService(dataMap);

        boolean result = (boolean) resultMap.get("result");

        if(result) {
            return "redirect:/board/list";
        } else {
            return "redirect:/error";
        }
    }

    @PostMapping("/delete")
    public String frontBoardDelete(
        HttpServletRequest request
    ) {
        HashMap<String, Object> dataMap = new HashMap<>();

        int regNo = Integer.parseInt(request.getParameter("reg_no"));
        dataMap.put("reg_no", regNo);

        Map<String, Object> resultMap = frontBoardServiceImpl.deleteBoardService(dataMap);

        boolean result = (boolean) resultMap.get("result");

        if(result) {
            return "redirect:/board/list";
        } else {
            return "redirect:/error";
        }
    }
}
