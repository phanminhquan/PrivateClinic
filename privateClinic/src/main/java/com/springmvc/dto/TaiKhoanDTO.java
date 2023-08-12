package com.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

public class TaiKhoanDTO {
    private Long id;
    private String name;
    private String username;
    private String password;
    private String avatar;
    private Boolean isActive;
    private String userRole;
    private Long maNv;
    private Long tkRole;
    private String confirmPassword;
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Long getMaNv() {
        return this.maNv;
    }

    public void setMaNv(Long maNv) {
        this.maNv = maNv;
    }

    public Long getTkRole() {
        return this.tkRole;
    }

    public void setTkRole(Long tkRole) {
        this.tkRole = tkRole;
    }
}
