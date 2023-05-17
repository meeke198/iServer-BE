package com.IServerBE.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Float price;
    Integer star;
    Float calo;
    Float discount;
    Integer usage;
    String image;
    String description;
//    Long menu_id;

}
