package com.liuhang.jcartadministrationback.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.liuhang.jcartadministrationback.constant.ClientExceptionConstant;
import com.liuhang.jcartadministrationback.exception.ClientException;
import com.liuhang.jcartadministrationback.util.JWTUtil;
import com.liuhang.jcartadministrationback.vo.AdministratorLoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Set;

@Order(2)
@Component
public class LoginFilter implements Filter {
    private Logger logger= LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JWTUtil jwtUtil;

    @Value("${jwt.exclude.apiUrls}")
    private Set<String> excludeLoginApiUrls;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        final String method = request.getMethod();
        if(method.equals("OPTIONS")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        final String requestURL = request.getRequestURI();

        if(excludeLoginApiUrls.contains(requestURL)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        String token = request.getHeader("jcartToken");

        if(token == null || token.isEmpty()){
            throw new ClientException(ClientExceptionConstant.TOKEN_NOT_EXIST_ERRCODE,ClientExceptionConstant.TOKEN_NOT_EXIST_ERRMSG);
        }

        logger.info("verify login with token:{}",token);

        AdministratorLoginVo administratorLoginVo=null;

        try{
            administratorLoginVo = jwtUtil.verifyToken(token);
        }catch (JWTVerificationException ex){
            throw new ClientException(ClientExceptionConstant.TOKEN_INVALID_ERRCODE,ex.getMessage());
        }

        request.setAttribute("adminitratorId",administratorLoginVo.getAdministratorId());
        request.setAttribute("administratorUsername",administratorLoginVo.getUsername());

        filterChain.doFilter(servletRequest,servletResponse);
        return;
    }
}
