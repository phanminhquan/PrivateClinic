package com.springmvc.dto;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaiKhoanDTO {
    private Long id;
    @NotEmpty(message = "{taikhoan.hoten.notNullMsg}")
    @Size(min = 1, max = 50, message = "{taikhoan.hoten.size}")
    @NotBlank(message = "{formspace}")
    private String name;
    @NotEmpty(message = "{taikhoan.username.notNullMsg}")
    @Size(min = 1, max = 50, message = "{taikhoan.username.size}")
    @NotBlank(message = "{formspace}")
    private String username;
    @NotEmpty(message = "{taikhoan.password.notNullMsg}")
    @Size(min = 1, max = 250, message = "{taikhoan.password.size}")
    @NotBlank(message = "{formspace}")
    private String password;
    private String avatar;
    private Boolean isActive;
    private String userRole;
    @NotNull(message = "{taikhoan.manv.notNullMsg}")
    private Long maNv;
    @NotEmpty(message = "{taikhoan.confirm.notNullMsg}")
    @Size(min = 1, max = 250, message = "{nhanvien.hoten.size}")
    @NotBlank(message = "{formspace}")
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

}
