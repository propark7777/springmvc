package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        return new ModelAndView("response/hello")
            .addObject("data","hello!");
    }

    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
       model.addAttribute("data","v2");

        return "response/hello";
    }
    //비추천 - Controller 경로의 이름과 view의 논리적 경로 이름이 같으면 생략 가능하나 비추천 
    @RequestMapping("/response/hello")
    public void responseView3(Model model) {
        model.addAttribute("data","v3");
    }
}
