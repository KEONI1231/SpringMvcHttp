package spring_mvc_http.spring_mvc_http.basic.requestmapping;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@Slf4j
public class MappingController {

    @RequestMapping("/hello-basic")
    public String helloBasic() {
        log.info("!!LOG : hello basic!!");
        return "hello basic";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("LOG : MappingGetV1");
        return "Mapping Get V1";
    }

    /**
     * 편리한 축약 어노테이션
     *
     * @GetMapping
     * @PostMapping
     * @PutMapping
     * @DeleteMapping
     * @PatchMapping
     */
    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        log.info("LOG : MappingGetV2");
        return "MappingGetV2";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}") //경로의 일부를 변수로 사용할 때,
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("LOG : MappingPath userId = {}", data);
        return "MappingPathVariable data";
    }

    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("LOG : Mapping Path={}, orderId = {}", userId, orderId);
        return "MappingPathMultiVariable data";

    }

    /**
     * 파라미터로 추가 매핑
     * params = "mode"
     * params = "!mode"
     * params = "mode=debug"
     * params = "mode != debug"
     * params = {"mode = debug", "data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("LOG : MappingParam");
        return "MappingParam";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers = "mode"
     * headers = "!mode"
     * headers = "mode=debug"
     * headers = "mode!=debug ( != )"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("LOG : Mapping Header");
        return "MappingHeader";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes = "appocation/json
     * consumes = "!application/json
     * consumes = "application/*"
     * consumes = "*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     **/
    @PostMapping(value = "/mapping-consume", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("LOG : mappingConsumes");
        return "MappingConsumes";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces = "text/html"
     * produces = "!text/html"
     * produces = "text/*"
     * produces = "*\/*"
     */
    @PostMapping(value = "mapping-produce", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("LOG : mappingProduces");
        return "MappingProduces";
    }
}
