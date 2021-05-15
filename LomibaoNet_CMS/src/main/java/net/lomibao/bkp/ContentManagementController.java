package net.lomibao.bkp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.utils.SecurityService;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import java.util.Map;

@Slf4j
@Controller("/cms")
public class ContentManagementController {

    @Inject
    private SecurityService securityService;
@Inject
ObjectMapper objectMapper;

    @Secured("ROLE_ADMIN")
    @Get("/test")
    public Map<String,String> test(){

        try {
            log.info("auth={}",objectMapper.writeValueAsString(securityService.getAuthentication().get().getAttributes()));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return Map.of("test","goodbye");
    }
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/anon")
    public String anon(){
        //securityService.getAuthentication().get().
        log.info("anon");
        securityService.getAuthentication().ifPresent(x->log.info(String.valueOf(x)));
        return "anon";
    }
}
