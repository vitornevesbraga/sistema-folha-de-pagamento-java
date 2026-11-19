
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Colaborador> colaboradores = new ArrayList<>();

        int opcao;

        do {
            System.out.println("==== MENU ====");
            System.out.println("1 - Cadastrar Colaborador Padrão");
            System.out.println("2 - Cadastrar Colaborador Comissionado");
            System.out.println("3 - Cadastrar Colaborador Produção");
            System.out.println("4 - Gerar Folha de Pagamento");
            System.out.println("5 - Exibir Resumo da Folha");
            System.out.println("0 - Sair do Programa");
            System.out.println("Selecione uma opção:");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Matrícula:");
                    int matriculaPadrao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome:");
                    String nomePadrao = scanner.nextLine();

                    if (matriculaPadrao > 0 && !nomePadrao.trim().isEmpty()) {
                        colaboradores.add(new ColaboradorPadrao(matriculaPadrao, nomePadrao));
                        System.out.println("Colaborador cadastrado!");
                    } else {
                        System.out.println("Dados inválidos.");
                    }
                    break;

                case 2:
                    System.out.println("Matrícula:");
                    int matriculaComissionado = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome:");
                    String nomeComissionado = scanner.nextLine();

                    System.out.println("Valor das vendas:");
                    double valorVendas = scanner.nextDouble();

                    System.out.println("Percentual de comissão:");
                    double percentualComissao = scanner.nextDouble();

                    if (matriculaComissionado > 0 &&
                            !nomeComissionado.trim().isEmpty() &&
                            valorVendas >= 0 &&
                            percentualComissao >= 0) {

                        colaboradores.add(new ColaboradorComissionado(
                                matriculaComissionado,
                                nomeComissionado,
                                valorVendas,
                                percentualComissao
                        ));

                        System.out.println("Colaborador cadastrado!");
                    } else {
                        System.out.println("Dados inválidos.");
                    }
                    break;

                case 3:
                    System.out.println("Matrícula:");
                    int matriculaProducao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Nome:");
                    String nomeProducao = scanner.nextLine();

                    System.out.println("Quantidade de peças:");
                    int quantidadePecas = scanner.nextInt();

                    System.out.println("Valor por peça:");
                    double valorPorPeca = scanner.nextDouble();

                    if (matriculaProducao > 0 &&
                            !nomeProducao.trim().isEmpty() &&
                            quantidadePecas >= 0 &&
                            valorPorPeca >= 0) {

                        colaboradores.add(new ColaboradorProducao(
                                matriculaProducao,
                                nomeProducao,
                                quantidadePecas,
                                valorPorPeca
                        ));

                        System.out.println("Colaborador cadastrado!");
                    } else {
                        System.out.println("Dados inválidos.");
                    }
                    break;

                case 4:
                    if (colaboradores.isEmpty()) {
                        System.out.println("Nenhum colaborador cadastrado.");
                    } else {
                        double totalFolha = 0;

                        System.out.println("==== FOLHA DE PAGAMENTO ====");

                        for (Colaborador colaborador : colaboradores) {
                            colaborador.exibirDados();
                            System.out.println("----------------------");

                            totalFolha += colaborador.calcularSalarioFinal();
                        }

                        System.out.println("Total da folha: R$ " + totalFolha);
                    }
                    break;

                case 5:
                    System.out.println("==== RESUMO DA FOLHA ====");
                    System.out.println("Total de colaboradores: " + colaboradores.size());

                    double totalResumo = 0;

                    for (Colaborador colaborador : colaboradores) {
                        totalResumo += colaborador.calcularSalarioFinal();
                    }

                    System.out.println("Valor total da folha: R$ " + totalResumo);
                    break;

                case 0:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Informe uma opção válida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
