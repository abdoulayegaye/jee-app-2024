package sn.dev.jeeapp2024.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Produit {
    private int id;
    private String designation;
    private double prix;
    private int quantite;
}
