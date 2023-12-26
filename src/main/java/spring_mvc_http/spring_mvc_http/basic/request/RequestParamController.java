package spring_mvc_http.spring_mvc_http.basic.request;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import spring_mvc_http.spring_mvc_http.basic.HelloData;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {
    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username = {}", username);
        log.info("age = {}", age);
        response.getWriter().write("ok");

    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge) {
        log.info("username = {}", memberName);
        log.info("age = {}", memberAge);

        return "request param member";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age
    ) {
        log.info("username = {}, age = {}", username, age);
        return "Request Param V3";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(
            String username,
            int age
    ) {
        log.info("username = {}, age = {}", username, age);
        return "Request Param V4";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username = {}, age = {}", username, age);
        return "requestParamV5";
    }


    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") int age) {
        log.info("username = {}, age = {}", username, age);
        return "requestParamDefault";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap( @RequestParam Map<String, Object> paramMap ) {
        log.info("username = {}, age = {}",paramMap.get("username"), paramMap.get("age"));
        return "requestParamMap";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public  String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
        log.info("helloData = {}",helloData);

        return "modelAttributeV1";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v1-1")
    public  String modelAttributeV1_1(@ModelAttribute HelloData helloData) {
        log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
        log.info("helloData = {}",helloData);
        //바인딩 exception 발생에 대한 검증?
        return "modelAttributeV1-1";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("username = {}, age = {}",helloData.getUsername(), helloData.getAge());
        log.info("테스트 !!");
        return "ModelAttributeV2";
    }


}
