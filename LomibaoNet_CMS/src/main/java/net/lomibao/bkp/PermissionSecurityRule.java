package net.lomibao.bkp;

import io.micronaut.core.annotation.AnnotationValue;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.micronaut.security.rules.SecurityRuleResult;
import io.micronaut.security.utils.SecurityService;
import io.micronaut.web.router.RouteMatch;
import lombok.extern.slf4j.Slf4j;
import net.lomibao.entity.User;
import net.lomibao.repository.UserRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Map;
import java.util.Optional;
@Slf4j
//@Singleton
public class PermissionSecurityRule  implements SecurityRule {
    @Inject
    private SecurityService securityService;

    @Inject
    private UserRepository users;

    @Override
    public SecurityRuleResult check(HttpRequest<?> request, @Nullable RouteMatch<?> routeMatch, @Nullable Map<String, Object> claims) {
        //String username=securityService.username().get();
        if(claims==null){
            log.error("no claims found");
            return SecurityRuleResult.UNKNOWN;
        }
        String email=(String) claims.get("email");
        Optional<User> user=users.findById(email);
        if(user.isPresent() && routeMatch.getAnnotation(Secured.class)!=null){
            log.info("user {} is found {}",email,user);
            User u=user.get();
            AnnotationValue<Secured> securedValue=routeMatch.getAnnotation(Secured.class);
            String[] roles=securedValue.get("value",String[].class).orElse(new String[0]);
            if(roles.length>0){
                boolean nonRole=false;
                for(String neededRole:roles){
                    if(neededRole.equalsIgnoreCase(String.format("ROLE_%s",u.getRole()))){
                        return SecurityRuleResult.ALLOWED;
                    }else{
                        nonRole=true;
                    }
                }
                if(!nonRole){
                    return SecurityRuleResult.REJECTED;
                }
            }
            return SecurityRuleResult.UNKNOWN;
        }
        log.warn("user {} is not found ",email);
        return SecurityRuleResult.UNKNOWN;
    }

    @Override
    public int getOrder() {
        return -500;
    }
}
