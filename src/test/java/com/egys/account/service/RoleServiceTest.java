package com.egys.account.service;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.egys.account.entity.Role;
import com.egys.account.entity.req.CreateRoleRequest;
import com.egys.account.enums.RoleStatus;
import com.egys.account.repository.RoleRepository;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void should_SUCCESS_create_role() {
        CreateRoleRequest createRoleRequest = new CreateRoleRequest();
        createRoleRequest.setName("SUPER_ADMIN");
        createRoleRequest.setCode("SA");
        createRoleRequest.setStatus(RoleStatus.ACTIVE);
        Optional<Role> emptyRole = Optional.empty();
        when(roleRepository.findByCode(createRoleRequest.getCode())).thenReturn(emptyRole);
        roleService.createRole(createRoleRequest);
        verify(roleRepository).save(any());
    }

    @Test
    public void should_FAIL_create_role_with_existing_code() {
        CreateRoleRequest createRoleRequest = new CreateRoleRequest();
        createRoleRequest.setName("SUPER_ADMIN");
        createRoleRequest.setCode("SA");
        createRoleRequest.setStatus(RoleStatus.ACTIVE);
        Role existingRole = new Role();
        existingRole.setCode("SA");
        Optional<Role> existingOptionalRole = Optional.of(existingRole);
        when(roleRepository.findByCode(createRoleRequest.getCode())).thenReturn(existingOptionalRole);
        assertThatExceptionOfType(ResponseStatusException.class)
                .isThrownBy(() -> roleService.createRole(createRoleRequest));
    }
}
