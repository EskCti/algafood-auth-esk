package com.eskcti.algafoodauthesk.auth.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tab_permissions")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permission {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false)
    private String description;
}
