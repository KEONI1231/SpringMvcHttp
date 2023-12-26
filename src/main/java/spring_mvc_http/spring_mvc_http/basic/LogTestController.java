package spring_mvc_http.spring_mvc_http.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //롬복이 제공하는 로그 찍는 어노테이션.
@RestController //레스트 컨트롤러라고 하면 리턴을 문자로 그대로 리턴
//@Controller는 뷰 이름이 반환됨.
public class LogTestController {
    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace = log{}",name); //
        log.debug("debug = log{}", name); // 디버그, 개발 로그
        log.info("info = log{}", name); // 정보 ?
        log.warn("warn = log{}", name); // 경고
        log.error("error log = {}", name); // 에러
        return "OK";
    }
}
