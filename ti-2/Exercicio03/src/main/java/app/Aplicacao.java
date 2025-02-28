package app;

import static spark.Spark.*;
import com.google.gson.Gson;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import model.Produto;
import service.ProdutoService;

public class Aplicacao {
    public static void main(String[] args) {
        staticFiles.location("/");
        port(4567);
        
        Gson gson = new Gson();

        // Add exception handler for all routes
        exception(Exception.class, (e, req, res) -> {
            res.status(500);
            res.type("application/json");
            res.body(gson.toJson(new ErrorResponse(e.getMessage())));
        });

        // Rota para exibir o formulário
        get("/", (req, res) -> {
            res.type("text/html");
            return new String(Files.readAllBytes(Paths.get("src/main/resources/formulario.html")));
        });

        // Rota para cadastrar produto
        post("/produto", (req, res) -> {
            try {
                int id = Integer.parseInt(req.queryParams("id"));
                String nome = req.queryParams("nome");
                double preco = Double.parseDouble(req.queryParams("preco"));

                Produto produto = new Produto(id, nome, preco);
                ProdutoService produtoService = new ProdutoService();
                produtoService.cadastrarProduto(produto);
                
                res.status(200);
                return "Produto cadastrado com sucesso!";
            } catch (Exception e) {
                res.status(400);
                return "Erro ao cadastrar produto: " + e.getMessage();
            }
        });

        // Rota para listar produtos
        get("/produto", (req, res) -> {
            try {
                ProdutoService produtoService = new ProdutoService();
                List<Produto> produtos = produtoService.listarProdutos();
                res.type("application/json");
                String jsonResponse = gson.toJson(produtos);
                System.out.println("JSON Response: " + jsonResponse); // Debug line
                return jsonResponse;
            } catch (Exception e) {
                e.printStackTrace(); // Debug line
                res.status(500);
                return gson.toJson(new ErrorResponse(e.getMessage()));
            }
        });

        // Rota para editar produto
        post("/produto/editar", (req, res) -> {
            int id = Integer.parseInt(req.queryParams("id"));
            String nome = req.queryParams("nome");
            double preco = Double.parseDouble(req.queryParams("preco"));

            Produto produto = new Produto(id, nome, preco);
            ProdutoService produtoService = new ProdutoService();
            produtoService.editarProduto(produto);

            return "Produto atualizado com sucesso!";
        });

        // Rota para deletar produto
        post("/produto/deletar", (req, res) -> {
            int id = Integer.parseInt(req.queryParams("id"));

            ProdutoService produtoService = new ProdutoService();
            produtoService.deletarProduto(id);

            return "Produto deletado com sucesso!";
        });
    }
}

// Add this class at the end of the file
class ErrorResponse {
    public ErrorResponse(String message) {
    }
}

