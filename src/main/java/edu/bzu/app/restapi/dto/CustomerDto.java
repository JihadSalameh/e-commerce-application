package edu.bzu.app.restapi.dto;

import lombok.Data;

import javax.persistence.Column;

/**
 * Author: Mohammed Kharma
 */
@Data
public class CustomerDto {
    private String full_name;
    private String email;

    private String password;

    private String phone;

    private int id;

  /*  public CustomerDto() {
    }

    public CustomerDto(int id, String full_name, String email, String password, String phone) {
        this.
        this.full_name = full_name;
        this.email = email;
    }

    public String getfull_name() {
        return full_name;
    }

    public void setfull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }*/
}
