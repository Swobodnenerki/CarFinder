package org.kozak.carfinder.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserDetailsImplementation implements UserDetails {
    private String login;
    private String password;
    private boolean enabled;
    private SimpleGrantedAuthority authority;
    private AccountEntity accountEntity;

    public UserDetailsImplementation(AccountEntity account, String role) {

        this.login = account.getLogin();
        this.password = account.getPassword();
        if(role.equals("USER"))
            enabled=false;
        else
            enabled=true;

        this.authority = new SimpleGrantedAuthority(role);
        this.accountEntity = account;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public AccountEntity getUserAccountsEntity() {
        return accountEntity;
    }

    public void setUserAccountsEntity(AccountEntity accountEntity) {
        this.accountEntity = accountEntity;
    }
}
