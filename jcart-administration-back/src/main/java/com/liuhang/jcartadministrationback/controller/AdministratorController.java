package com.liuhang.jcartadministrationback.controller;

import com.liuhang.jcartadministrationback.dto.in.AdministratorLoginInDTO;
import com.liuhang.jcartadministrationback.dto.in.AdministratorResetPwdInDTO;
import com.liuhang.jcartadministrationback.dto.in.AdministratorUpdateProfileInDTO;
import com.liuhang.jcartadministrationback.dto.out.AdministratorGetProfileOutDTO;
import com.liuhang.jcartadministrationback.dto.out.AdministratorListOutDTO;
import com.liuhang.jcartadministrationback.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/administrator")
public class AdministratorController {

    @GetMapping("/login")
    public String login(AdministratorLoginInDTO administratorLoginInDTO){
        return null;
    }

    @GetMapping("/getProfile")
    public AdministratorGetProfileOutDTO getProfile(Integer adminstratorId){
        return null;
    }

    @PostMapping("/updateProdfile")
    public void updateProdfile(@RequestBody AdministratorUpdateProfileInDTO administratorUpdateProfileInDTO){

    }

    @GetMapping("/getPwdRestCode")
    public String getPwdRestCode(@RequestParam String email){
        return  null;
    }


    @PostMapping("/resetPwd")
    public void resetPwd(@RequestBody AdministratorResetPwdInDTO administratorResetPwdInDTO){

    }
    @GetMapping("/getList")
    public PageOutDTO<AdministratorListOutDTO> getList(@RequestParam Integer pageNum){
        return null;
    }

}
