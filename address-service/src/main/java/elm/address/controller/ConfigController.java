package elm.address.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class ConfigController {

    @Value("${server.port}")
    String port;


    @RequestMapping(value = "/port")
    public String getPort(){
        return port;
    }
}
