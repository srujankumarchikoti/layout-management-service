package com.example.layoutmanagementservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String groupName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "layout_id", referencedColumnName = "id")
    private Layout layout;
}
