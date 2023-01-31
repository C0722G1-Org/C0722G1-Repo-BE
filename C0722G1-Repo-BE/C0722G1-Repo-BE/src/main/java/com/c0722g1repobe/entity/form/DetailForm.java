package com.c0722g1repobe.entity.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailForm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetailForm;
    private String urlDetailForm;
}
