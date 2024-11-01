package com.ra.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;
    @Column(name = "category_name",length = 50,unique = true)
    @NotBlank
    private String categoryName;
    @Column(name = "description")
    @NotBlank
    private String description;
    @Column(name = "status")
    private Boolean status;


}
