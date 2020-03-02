package com.liuhang.jcartadministrationback.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.liuhang.jcartadministrationback.dto.out.AdministratorLoginOutDTO;
import com.liuhang.jcartadministrationback.po.Administrator;
import com.liuhang.jcartadministrationback.vo.AdministratorLoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${jwt.valid.duration}")
    private Long jwtValidDuration;

    @Value("${jwt.issuer}")
    private String issuer;

    private Algorithm algorithm;

    public JWTUtil(@Value("${jwt.HS256.secret}")String jwtHS256Secret){
        logger.info("init jwt util");
        algorithm=Algorithm.HMAC256(jwtHS256Secret);
    }

    public AdministratorLoginOutDTO issueToken(Administrator administrator){
        Date now =new Date();
        long nowTimestamp = now.getTime();
        long expireTimestamp = nowTimestamp+jwtValidDuration;
        Date expireTime = new Date(expireTimestamp);
        Integer administratorId= administrator.getAdministratorId();
        String username = administrator.getUsername();

        String token = JWT.create().withIssuer(issuer)
                .withIssuedAt(now).withSubject(username)
                .withClaim("administratorId",administratorId)
                .withExpiresAt(expireTime).sign(algorithm);

        logger.info("jwt token:{}",token);
        logger.info("jwt expire date:{}",expireTimestamp);
        AdministratorLoginOutDTO administratorLoginOutDTO  = new AdministratorLoginOutDTO();
        administratorLoginOutDTO.setToken(token);
        administratorLoginOutDTO.setExpireTimestamp(expireTimestamp);

        return administratorLoginOutDTO;
    }

    public AdministratorLoginVo verifyToken(String token){
        JWTVerifier verifier = JWT.require(algorithm).withIssuer(issuer)
                .build();
        DecodedJWT jwt;
        jwt = verifier.verify(token);

        AdministratorLoginVo administratorLoginVo= new AdministratorLoginVo();
        administratorLoginVo.setAdministratorId(jwt.getClaim("administratorId").asInt());
        administratorLoginVo.setUsername(jwt.getSubject());
        return administratorLoginVo;
    }
}
