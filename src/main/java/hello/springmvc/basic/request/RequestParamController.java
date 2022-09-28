package hello.springmvc.basic.request;

import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("uesrname =  {}, age = {}",username,age);

        response.getWriter().write("ok");

    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String memberName,
        @RequestParam("age") int memberAge) {

        log.info("uesrname =  {}, age = {}",memberName,memberAge);

        return "ok";
    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
        @RequestParam String username,
        @RequestParam int age) {

        log.info("uesrname =  {}, age = {}",username,age);

        return "ok";
    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age ){

        log.info("uesrname =  {}, age = {}",username,age);

        return "ok";
    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
        @RequestParam(required = true)  String username,
        @RequestParam(required = false)  Integer age ){

        //기본형인 int 에는 null이 들어갈수 없다
        //그래서 Integer 객체로 쓰면 required false를 사용할 수 있다.

        log.info("uesrname =  {}, age = {}",username,age);

        return "ok";
    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
        @RequestParam(defaultValue = "guest")  String username,
        @RequestParam(defaultValue = "-1")  int age ){

        log.info("uesrname =  {}, age = {}",username,age);

        return "ok";
    }

    @ResponseBody //RestController와 같은 효과
    @RequestMapping("/request-param-map")
    public String requestParamMap(
        @RequestParam Map<String,Object> paramMap){

        log.info("uesrname =  {}, age = {}",paramMap.get("username"),paramMap.get("age"));

        return "ok";
    }
}