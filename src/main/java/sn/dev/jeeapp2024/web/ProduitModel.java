package sn.dev.jeeapp2024.web;

import lombok.Data;
import sn.dev.jeeapp2024.entity.Produit;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProduitModel {
    private String motCle;
    private double total;
    private List<Produit> produits = new ArrayList<>();
}
