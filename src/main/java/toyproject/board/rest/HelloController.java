package toyproject.board.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.board.application.PatchMemberService;

import javax.json.JsonMergePatch;

@RestController
@RequiredArgsConstructor
public class HelloController {

    private final PatchMemberService patchMemberService;

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!!");
        return "hello";
    }

    //TODO PATCH ERROR 조치필요
    @ApiOperation(value="member entity patch", notes="member entity 개별 컬럼들을 patch한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "API 정상 작동"),
            @ApiResponse(code = 500, message = "서버 에러")
    })
    @PatchMapping("/member/{id}")
    public String patchMember(@PathVariable Long id, @JsonProperty("email") @RequestBody JsonMergePatch jsonMergePatch){
        patchMemberService.patchMemberInfo(id,jsonMergePatch);
        return "hello";
    }
}
