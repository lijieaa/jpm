package com.jpm.config;


import com.jpm.sys.entity.SysUserEntity;
import com.jpm.sys.service.SysUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final Log logger = LogFactory.getLog(MyUserDetailService.class);


    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        SysUserEntity user = sysUserService.findByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }
        Collection<? extends GrantedAuthority> authorities=new ArrayList<>();
        return new User(user.getUsername()
                ,user.getPassword()
                ,true
                ,true
                ,true
                ,true
                ,authorities);
    }
}
