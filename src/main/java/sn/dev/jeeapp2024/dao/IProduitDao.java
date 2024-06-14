package sn.dev.jeeapp2024.dao;

import sn.dev.jeeapp2024.entity.Produit;

import java.util.List;

public interface IProduitDao {
    public Produit save(Produit produit);
    public List<Produit> getProduitsByMC(String mc);
    public Produit getProduitById(int id);
    public int update(Produit produit);
    public int delete(int id);
}
