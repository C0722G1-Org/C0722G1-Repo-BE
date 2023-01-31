package com.c0722g1repobe.entity.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE post SET flag_deleted = true WHERE id_post=?")
@Where(clause = "flag_deleted=false")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String namePost;
    private Double area;
    private String note;
    private String descriptionPost;
    private Double price;
    private boolean flagDeleted = false;
    private int approval;
    private LocalDate dateCreation = LocalDate.now();
    @ManyToOne
    private Direction direction;
    @ManyToOne
    private StatusPost statusPost;
    @OneToOne
    private Address address;
    @ManyToOne
    private DemandType demandType;
    @ManyToOne
    private LandType landType;
    @OneToOne
    private ImageList imageList;
}
