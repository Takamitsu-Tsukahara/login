package demo.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class AccountForm implements Serializable {
    private String email;
    private String password;
}