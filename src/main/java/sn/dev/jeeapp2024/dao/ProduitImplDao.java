package sn.dev.jeeapp2024.dao;

import sn.dev.jeeapp2024.entity.Produit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduitImplDao implements IProduitDao{

    private SingletonConnection db = new SingletonConnection();
    private ResultSet rs;
    private int ok;

    @Override
    public Produit save(Produit produit) {
        String sql = "INSERT INTO produit_tb VALUES(null, ?, ?, ?)";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, produit.getDesignation());
            db.getPstm().setDouble(2, produit.getPrix());
            db.getPstm().setInt(3, produit.getQuantite());
            ok = db.executeMaj();
            if(ok == 1){
                String req = "SELECT MAX(id) as max_id FROM produit_tb";
                db.initPrepar(req);
                rs = db.executeSelect();
                if(rs.next()){
                    produit.setId(rs.getInt("max_id"));
                }
            }
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produit;
    }

    @Override
    public List<Produit> getProduitsByMC(String mc) {
        List<Produit> produits = new ArrayList<>();
        String sql = "SELECT * FROM produit_tb WHERE designation LIKE ? ORDER BY designation ASC";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, mc);
            rs = db.executeSelect();
            while (rs.next()){
                Produit p = new Produit(
                    rs.getInt("id"),
                    rs.getString("designation"),
                    rs.getDouble("prix"),
                    rs.getInt("quantite")
                );
                produits.add(p);
            }
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit getProduitById(int id) {
        Produit produit = null;
        String sql = "SELECT * FROM produit_tb WHERE id = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            rs = db.executeSelect();
            if (rs.next()){
                produit = new Produit(
                        rs.getInt("id"),
                        rs.getString("designation"),
                        rs.getDouble("prix"),
                        rs.getInt("quantite")
                );
            }
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produit;
    }

    @Override
    public int update(Produit produit) {
        String sql = "UPDATE produit_tb SET designation = ?, prix = ?, quantite = ? WHERE id = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setString(1, produit.getDesignation());
            db.getPstm().setDouble(2, produit.getPrix());
            db.getPstm().setInt(3, produit.getQuantite());
            db.getPstm().setInt(4, produit.getId());
            ok = db.executeMaj();
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public int delete(int id) {
        String sql = "DELETE FROM produit_tb WHERE id = ?";
        try {
            db.initPrepar(sql);
            db.getPstm().setInt(1, id);
            ok = db.executeMaj();
            db.closeConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return ok;
    }
}
