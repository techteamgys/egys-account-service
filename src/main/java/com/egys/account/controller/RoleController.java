package com.egys.account.controller;

import com.egys.account.entity.Role;
import com.egys.account.entity.req.CreateRoleRequest;
import com.egys.account.service.RoleService;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/role")
@AllArgsConstructor
@Slf4j
public class RoleController {

    private RoleService roleService;

    @PostMapping("")
    public void createRole(@RequestBody CreateRoleRequest createRoleRequest) {
        roleService.createRole(createRoleRequest);
    }

    @GetMapping("")
    public List<Role> getAllRole() {
        return roleService.getAllRole();
    }
}
