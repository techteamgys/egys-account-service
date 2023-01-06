package com.egys.account.service;

import com.egys.account.entity.Role;
import com.egys.account.entity.req.CreateRoleRequest;
import com.egys.account.repository.RoleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    public void createRole(final CreateRoleRequest createRoleRequest) {
        log.info("Create Role {}", createRoleRequest.getName());
        Role role = new Role();
        role.setName(createRoleRequest.getName());
        roleRepository.save(role);
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
