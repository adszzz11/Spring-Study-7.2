package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/hello-basic", "/hello-go"}, method = RequestMethod.GET)
    public String helloBasic() {
        log.info("hellobasic");

        return "OK";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        log.info("mappingGetV1");
        return "OK";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String mappingGetV2() {
        log.info("mappingGetV2");
        return "OK";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "OK";
    }

    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "OK";
    }

    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingparam");
        return "Ok";
    }

    @GetMapping(value = "/mapping-headers", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "Ok";
    }
    @PostMapping(value = "/mapping-consumes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String mappingConsumes() {
        log.info("mappingConsume");
        return "Ok";
    }


    @PostMapping(value = "/mapping-produces", produces = MediaType.TEXT_HTML_VALUE)
    public String mappingProduces() {
        log.info("mappingProduce");
        return "Ok";
    }
}
