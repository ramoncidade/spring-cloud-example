package br.com.store.proxy.filters;

import br.com.store.proxy.entities.Token;
import br.com.store.proxy.gateways.repository.TokenRepository;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by ramon.cidade on 16/05/2017.
 */
@Component
public class AuthenticationFilter extends ZuulFilter {
    private static Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);

    private TokenRepository tokenRepository;

    @Autowired
    public AuthenticationFilter(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        String tokenString = ctx.getRequest().getHeader("Authentication");
        if (tokenString != null && !tokenString.trim().isEmpty()) {
            Token token = tokenRepository.findOne(tokenString);
            if (token != null) {
                ctx.addZuulRequestHeader("email", token.getEmail());
                ctx.setResponseStatusCode(HttpStatus.OK.value());
                ctx.setSendZuulResponse(true);
            } else {
                ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                ctx.setSendZuulResponse(false);
            }
        } else {
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            ctx.setSendZuulResponse(false);
        }
        log.info(String.format("%s request to %s", ctx.getRequest().getMethod(), ctx.getRequest().getRequestURL().toString()));
        return null;
    }
}
