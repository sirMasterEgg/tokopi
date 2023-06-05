package com.mbokmu.tokopi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu extends BaseEntity {
    String name;
    String description;
    int price;
    String category;
    String image_url;

    @OneToMany(mappedBy = "menu")
    List<Dtrans> dtrans;

}
