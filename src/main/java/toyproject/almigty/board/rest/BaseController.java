//package toyproject.almigty.board.rest;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import toyproject.almigty.config.auth.SessionUser;
//
//import javax.servlet.http.HttpSession;
//
//@RequiredArgsConstructor
//@Controller
//public class BaseController {
//
//    private final HttpSession httpSession;
//
//    @GetMapping("/")
//    public String index(Model model){
//
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        if(user != null) {
//            model.addAttribute("userName", user.getName());
//            model.addAttribute("userImg", user.getPicture());
//        }
//
//        return "index";
//    }
//}