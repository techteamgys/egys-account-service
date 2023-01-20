package com.egys.account.service;

import com.egys.account.entity.Role;
import com.egys.account.entity.req.CreateRoleRequest;
import com.egys.account.repository.RoleRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoleService {

    private final RoleRepository roleRepository;
    public void createRole(final CreateRoleRequest createRoleRequest) {
        log.info("Create role {}", createRoleRequest);
        Optional<Role> existingRole = roleRepository.findByCode(createRoleRequest.getCode());
        if(existingRole.isPresent()) {
            //throw exception user already exist
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        Role role = Role.builder()
                .code(createRoleRequest.getCode())
                .name(createRoleRequest.getName())
                .status(createRoleRequest.getStatus())
                .createdId(999)
                .createdTime(LocalDateTime.now())
                .build();
        roleRepository.save(role);
        log.info("Success create role {}", createRoleRequest.getName());
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }
}
