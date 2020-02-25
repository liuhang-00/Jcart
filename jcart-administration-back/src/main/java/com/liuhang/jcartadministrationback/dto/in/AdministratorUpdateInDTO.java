package com.liuhang.jcartadministrationback.dto.in;

public class AdministratorUpdateInDTO {
    private Integer AdministratorId;
    private String password;
    private String realName;
    private String email;
    private Byte status;

    public Integer getAdministratorId() {
        return AdministratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        AdministratorId = administratorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
