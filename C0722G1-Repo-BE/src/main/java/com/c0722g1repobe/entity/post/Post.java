package com.c0722g1repobe.entity.post;

import com.c0722g1repobe.entity.customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
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
    private String descriptionPost;
    private Double price;
    private boolean flagDeleted = false;
    @ManyToOne
    private Approval approval;
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
    @ManyToOne
    private Customer customer;

}
