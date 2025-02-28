package service;

import java.sql.SQLException;
import java.util.List;

import dao.ProdutoDAO;
import model.Produto;

public class ProdutoService {
    private ProdutoDAO produtoDAO;

    public ProdutoService() {
        produtoDAO = new ProdutoDAO();
    }

    public void cadastrarProduto(Produto produto) throws SQLException {
        produtoDAO.cadastrarProduto(produto);
    }

    public List<Produto> listarProdutos() throws SQLException {
        return produtoDAO.listarProdutos();
    }

    public void editarProduto(Produto produto) throws SQLException {
        produtoDAO.editarProduto(produto);
    }

    public void deletarProduto(int id) throws SQLException {
        produtoDAO.deletarProduto(id);
    }
}

