package com.example.demo.DBO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "plumbing")
public class Plumbing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column(name = "nameTypeWork")
    private String nameTypeWork;
    @OneToMany(mappedBy = "plumbing")
    private List<CategoriesPlumbing> plumbingList;
}
