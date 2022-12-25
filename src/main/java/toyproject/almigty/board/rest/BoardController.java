package toyproject.almigty.board.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toyproject.almigty.board.application.BoardService;
import toyproject.almigty.board.application.GetUserInfoService;
import toyproject.almigty.board.application.RestJsonService;
import toyproject.almigty.board.rest.DTO.BoardDto;

import java.util.List;

import static toyproject.almigty.common.constants.BoardApiUrl.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("board")
@Slf4j
public class BoardController {
    private final BoardService boardService;

    // 게시판
    // 게시글 목록
    // list 경로로 GET 메서드 요청이 들어올 경우 list 메서드와 맵핑시킴
    // list 경로에 요청 파라미터가 있을 경우 (?page=1), 그에 따른 페이지네이션을 수행함.

    @GetMapping({"", GET_BOARD_LIST})
    public String list(Model model, @RequestParam(value="page", defaultValue = "1") Integer pageNum) {
        log.info("[GET] /list api 호출");
        List<BoardDto> boardList = boardService.getBoardlist(pageNum);
        Integer[] pageList = boardService.getPageList(pageNum);

        model.addAttribute("boardList", boardList);
        model.addAttribute("pageList", pageList);

        return "board/list";
    }

    // 글쓰는 페이지

    @GetMapping(GET_BOARD_POST_PAGE)
    public String write() {
        log.info("[GET] /post api 호출");
        return "board/write";
    }

    // 글을 쓴 뒤 POST 메서드로 글 쓴 내용을 DB에 저장
    // 그 후에는 /list 경로로 리디렉션해준다.

    @PostMapping(POST_BOARD_POST_PAGE)
    public String write(BoardDto boardDto) {
        log.info("[POST] /post api 호출");
        boardService.savePost(boardDto);
        return "redirect:/board/list";
    }

    // 게시물 상세 페이지이며, {no}로 페이지 넘버를 받는다.
    // PathVariable 애노테이션을 통해 no를 받음

    @GetMapping(GET_BOARD_DETAIL)
    public String detail(@PathVariable("no") Long no, Model model) {
        log.info("[GET] /post/{no} api 호출");

        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail";
    }

    // 게시물 수정 페이지이며, {no}로 페이지 넘버를 받는다.

    @GetMapping(GET_BOARD_EDIT_PAGE)
    public String edit(@PathVariable("no") Long no, Model model) {
        log.info("[GET] /post/edit/{no} api 호출");

        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update";
    }

    // 위는 GET 메서드이며, PUT 메서드를 이용해 게시물 수정한 부분에 대해 적용

    @PostMapping(POST_EDIT)
    public String update(BoardDto boardDTO) {
        log.info("[Put] /post/edit/{no} api 호출");

        boardService.savePost(boardDTO);

        return "redirect:/board/list";
    }

    // 게시물 삭제는 deletePost 메서드를 사용하여 간단하게 삭제할 수 있다.

    @PostMapping(POST_DELETE)
    public String delete(@PathVariable("no") Long no) {
        log.info("[Delete] /post/{no} api 호출");

        boardService.deletePost(no);

        return "redirect:/board/list";
    }

    // 검색
    // keyword를 view로부터 전달 받고
    // Service로부터 받은 boardDtoList를 model의 attribute로 전달해준다.

    @GetMapping(GET_SEARCH)
    public String search(@RequestParam(value="keyword") String keyword, Model model) {
        log.info("[Get] /board/search api 호출");

        List<BoardDto> boardDtoList = boardService.searchPosts(keyword);

        model.addAttribute("boardList", boardDtoList);

        return "board/list";
    }


    @GetMapping("/home")
    public String home(Model model){
        return "board/home";
    }

    @GetMapping("/receiveAC")
    public String receiveAC(@RequestParam("code") String code, Model model) throws ParseException {
        RestJsonService restJsonService = new RestJsonService();

        //access_token이 포함된 JSON String을 받아온다.
        String accessTokenJsonData = restJsonService.getAccessTokenJsonData(code);
        if(accessTokenJsonData.equals("error")) return "error";

        log.info(accessTokenJsonData);

        //JSON String -> JSON Object
        JSONObject accessTokenJsonObject = convertToJsonObject(accessTokenJsonData);

        //access_token 추출
        String accessToken = accessTokenJsonObject.get("access_token").toString();


        //유저 정보가 포함된 JSON String을 받아온다.
        GetUserInfoService getUserInfoService = new GetUserInfoService();
        String userInfo = getUserInfoService.getUserInfo(accessToken);

        //JSON String -> JSON Object
        JSONObject userInfoJsonObject = convertToJsonObject(userInfo);

        //유저의 Email 추출
        JSONObject propertiesJsonObject = (JSONObject)userInfoJsonObject.get("properties");
        String profileImage = propertiesJsonObject.get("profile_image").toString();

        JSONObject kakaoAccountJsonObject = (JSONObject)userInfoJsonObject.get("kakao_account");

        String email;
        try{
            email = kakaoAccountJsonObject.get("email").toString();
        }
        catch (Exception e){
            email = "약관 동의 안함";
        }

        model.addAttribute("profile_image", profileImage);
        model.addAttribute("email", email);

        return "success";
    }

    private JSONObject convertToJsonObject(String jsonString) throws ParseException {
        JSONParser parser = new JSONParser();
        return  (JSONObject) parser.parse(jsonString);
    }
}
