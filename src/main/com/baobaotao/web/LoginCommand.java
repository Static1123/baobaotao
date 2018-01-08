package com.baobaotao.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Static
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginCommand {
    private String userName;
    private String password;
}