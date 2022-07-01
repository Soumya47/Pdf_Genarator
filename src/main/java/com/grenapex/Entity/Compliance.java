package com.grenapex.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Compliance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;
    private BigDecimal percentage;

    public String START_DATE;
    public String END_DATE;
    public Integer ASSESSMENTS;
    public String DIVISION;
    public String OR_PROJECT;
    public String OR_SITE;
    public String OR_SUBSITE;
    public String OR_DEPARTMENT;
    public String TASK;
}
