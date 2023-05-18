package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.model.Role;
import web.repository.RoleRepository;
import web.repository.UserRepository;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
    }
    public List<Role> findAll(){
        return roleRepository.findAll();
    }
    public Role findRoleByAuthority(String authority){
        return roleRepository.findRoleByRole(authority);
    }
}
