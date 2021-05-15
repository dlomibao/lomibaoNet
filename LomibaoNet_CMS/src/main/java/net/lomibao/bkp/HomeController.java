package net.lomibao.bkp;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.authentication.Authentication;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.views.View;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class HomeController {
//    @Get("/login")
//    public Map<String,String> login(@QueryValue String authorizationCode){
//
//    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @View("home")
    @Get
    public Map<String,Object> index(){

        return new HashMap<>();
    }
//    @Secured(SecurityRule.IS_AUTHENTICATED)
//    @Get("/authenticated")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Authentication authenticated(Authentication authentication) {
//        return authentication;
//        //return authentication.getName() + " is authenticated";
//    }
}
