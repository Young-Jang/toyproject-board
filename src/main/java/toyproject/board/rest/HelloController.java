package toyproject.board.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import toyproject.board.application.PatchMemberService;

import javax.json.JsonMergePatch;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final PatchMemberService patchMemberService;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }


    @PatchMapping("/member/{id}")
    public String patchMember(@PathVariable Long id, @RequestBody JsonMergePatch jsonMergePatch){
        patchMemberService.patchMemberInfo(id,jsonMergePatch);
        return "hello";
    }
}
