package sn.dev.jeeapp2024.web;

import sn.dev.jeeapp2024.dao.IProduitDao;
import sn.dev.jeeapp2024.dao.ProduitImplDao;
import sn.dev.jeeapp2024.entity.Produit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ps", urlPatterns = {"*.do"})
public class ProduitServlet extends HttpServlet {

    private IProduitDao metier;

    @Override
    public void init(ServletConfig config) throws ServletException {
        metier = new ProduitImplDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equalsIgnoreCase("/index.do")){
            List<Produit> produits = metier.getProduitsByMC("%%");
            ProduitModel model = new ProduitModel();
            model.setMotCle("");
            model.setTotal(getTotal(produits));
            model.setProduits(produits);
            request.setAttribute("prodModel", model);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        }
        else if (path.equalsIgnoreCase("/search.do")){
            String motCle = request.getParameter("motCle");
            List<Produit> produits = metier.getProduitsByMC("%"+motCle+"%");
            ProduitModel model = new ProduitModel();
            model.setMotCle(motCle);
            model.setTotal(getTotal(produits));
            model.setProduits(produits);
            request.setAttribute("prodModel", model);
            request.getRequestDispatcher("list.jsp").forward(request, response);
        } else if (path.equalsIgnoreCase("/add.do")){
            request.getRequestDispatcher("add.jsp").forward(request, response);
        } else if (path.equalsIgnoreCase("/create.do") && request.getMethod().equalsIgnoreCase("POST")) {
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit produit = new Produit();
            produit.setDesignation(designation);
            produit.setPrix(prix);
            produit.setQuantite(quantite);
            produit = metier.save(produit);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("detail.jsp").forward(request, response);
        }  else if (path.equalsIgnoreCase("/edit.do")){
            int id = Integer.parseInt(request.getParameter("id"));
            Produit produit = metier.getProduitById(id);
            request.setAttribute("produit", produit);
            request.getRequestDispatcher("edit.jsp").forward(request, response);
        } else if (path.equalsIgnoreCase("/update.do")  && request.getMethod().equalsIgnoreCase("POST")){
            int id = Integer.parseInt(request.getParameter("id"));
            String designation = request.getParameter("designation");
            double prix = Double.parseDouble(request.getParameter("prix"));
            int quantite = Integer.parseInt(request.getParameter("quantite"));
            Produit produit = new Produit();
            produit.setId(id);
            produit.setDesignation(designation);
            produit.setPrix(prix);
            produit.setQuantite(quantite);
            int ok = metier.update(produit);
            if (ok == 1)
                request.getRequestDispatcher("list.jsp").forward(request, response);
        } else if (path.equalsIgnoreCase("/delete.do")){
            int id = Integer.parseInt(request.getParameter("id"));
            int ok = metier.delete(id);
            if (ok == 1)
                request.getRequestDispatcher("confrimation.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    public double getTotal(List<Produit> produits){
        double total = 0.0;
        for (Produit p : produits) {
            total += p.getPrix() * p.getQuantite();
        }
        return total;
    }

}
