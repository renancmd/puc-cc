package maven.demo;

import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProdutoDAO dao = new ProdutoDAO();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1 - Listar Produtos");
            System.out.println("2 - Inserir Produto");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Excluir Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    List<Produto> produtos = dao.listar();
                    produtos.forEach(System.out::println);
                    break;
                case 2:
                    System.out.print("Nome do produto: ");
                    String nome = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    dao.inserir(new Produto(0, nome, preco));
                    System.out.println("Produto inserido!");
                    break;
                case 3:
                    System.out.print("ID do produto: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Novo nome: ");
                    nome = sc.nextLine();
                    System.out.print("Novo preço: ");
                    preco = sc.nextDouble();
                    dao.atualizar(new Produto(id, nome, preco));
                    System.out.println("Produto atualizado!");
                    break;
                case 4:
                    System.out.print("ID do produto a excluir: ");
                    id = sc.nextInt();
                    dao.excluir(id);
                    System.out.println("Produto excluído!");
                    break;
                case 5:
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

