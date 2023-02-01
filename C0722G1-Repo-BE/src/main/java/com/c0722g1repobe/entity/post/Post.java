package com.c0722g1repobe.entity.post;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPost;
    private String namePost;
    private Double area;
    private String note;
    private Double price;
    private boolean flagDeleted = false;
    private boolean approval;
    private LocalDate dateCreation;
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
    private String imageListURL;
}
