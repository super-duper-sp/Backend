package com.yash.yof.entity;

import com.yash.yof.constansts.UserAccountStatusTypes;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "yof_user")
public class User implements Serializable {

    @Column(name = "emp_id", unique = true, nullable = false)
    private Long empId;

    @Column(name = "full_name")
    private String fullName;

    @Id
    @Column(name = "email_add")
    private String emailAdd;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status")
    private UserAccountStatusTypes accountStatus;

    @ManyToOne
    @JoinColumn(name = "user_role")
    private UserRole userRole;
}