package cn.boxfish.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by undancer on 15/8/16.
 */
@RestController
@RequestMapping("/")
public class IndexController {
    @RequestMapping(method = RequestMethod.GET)
    public void home() throws Exception {
        throw new Exception("e");
    }
}
