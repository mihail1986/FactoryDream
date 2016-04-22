/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.factorydream.sessions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import md.factorydream.constant.StatusCodeConst;
import md.factorydream.entites.RoleAccess;
import md.factorydream.entites.Users;
import md.factorydream.spring.service.UsersService;
import md.factorydream.util.FormatPassword;
import md.factorydream.util.UtilHashMD5;
import md.factorydream.validators.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author Zaițev.Victor
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired(required = true)
    @Qualifier(value = "usersService")
    private UsersService usersService;

    @Override
    public Authentication authenticate(@Validated Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        LoginFormValidator loginFormValidator = new LoginFormValidator();

        if (!loginFormValidator.isLoginValid(username)) {
            throw new BadCredentialsException("Numele de utilizator contine simboluri interzise");
        }

        if (!loginFormValidator.isValidPassword(password)) {
            throw new BadCredentialsException("Parola contine simboluri interzise");
        }

        Users users = usersService.findUserByLogin(username);

        if (users == null) {
            throw new UsernameNotFoundException("Asa utilizator nu exista in baza de date");
        }

        String hashPassword = UtilHashMD5.createMD5Hash(FormatPassword.CreatePassword(users.getId(), password));

        if (!hashPassword.equals(users.getPassword())) {
            throw new BadCredentialsException("Parola este gresita");
        }

        if (!StatusCodeConst.COD_NAME_ENABLE.equals(users.getStatusCod().getCodName())) {
            throw new AccountExpiredException("Nu aveti drept sa accesati acest serviciu");
        }

        Collection<? extends GrantedAuthority> authoritiesRoles = getAuthorities(users);

        return new UsernamePasswordAuthenticationToken(username, hashPassword, authoritiesRoles);

    }

    @Override
    public boolean supports(Class<?> type) {
        return true; //To change body of generated methods, choose Tools | Templates.
    }

    private List<GrantedAuthority> getAuthorities(Users users) {

        List<GrantedAuthority> authoritys = new ArrayList<>();

        for (RoleAccess roleAccess : users.getRoleAccesses()) {

            if (roleAccess.getRoles().getStatusCod().getCodName().equals(StatusCodeConst.COD_NAME_ENABLE)) {
                authoritys.add(new SimpleGrantedAuthority(roleAccess.getRoles().getName()));
            }
        }

        return authoritys;
    }

}
