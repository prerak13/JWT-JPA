package io.javabrains.springsecurityjwt;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.javabrains.springsecurityjwt.repo.MyUserDetail;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    io.javabrains.springsecurityjwt.repo.UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<io.javabrains.springsecurityjwt.repo.UserBean> user = userRepository.findByUname(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + userName));

        return user.map(MyUserDetail::new).get();
    }
}