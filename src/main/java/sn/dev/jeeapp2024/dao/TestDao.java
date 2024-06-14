package sn.dev.jeeapp2024.dao;

import sn.dev.jeeapp2024.entity.Produit;

public class TestDao {
    public static void main(String[] args) {
        IProduitDao metier = new ProduitImplDao();
        int ok = metier.delete(8);
    }
}
