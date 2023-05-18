package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.model.User;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    private  UserRepository userRepository;

    private  RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User findUserById(Long id){
        return userRepository.getOne(id);
    }


    public User findUserByName(String name) throws UsernameNotFoundException {
        return userRepository.findUserByName(name);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void saveUser(User user, String role){
        user.setPassword(user.getPassword());
        user.setName(user.getName());
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(roleRepository.findRoleByRole(role));
        user.setRoles(roleSet);
        userRepository.save(user);
    }

    public void deleteById(Long id){
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findUserByName(s);
    }
}
