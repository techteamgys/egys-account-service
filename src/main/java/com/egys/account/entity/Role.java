package com.egys.account.entity;

import com.egys.account.enums.RoleStatus;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Table(name="role")
@Setter
@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private RoleStatus status;
    @Column(name = "createdid")
    private Integer createdId;
    @Column(name = "createdtime")
    private LocalDateTime createdTime;
    @Column(name = "editedid")
    private Integer editedId;
    @Column(name = "editedtime")
    private LocalDateTime editedTime;
    @Column(name = "deletedid")
    private Integer deletedId;
    @Column(name = "deletedtime")
    private LocalDateTime deletedTime;
}
