import controller.ControllerPessoa;
import models.Pessoa;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int opcao;
        int dataAtual;

        int idadeMinima;
        String comorbidades, profissoes;

        String nome, cpf, endereco, telefone, cartaoSUS, email, profissao, comorbidade;
        int idade;

        boolean encerrarSistema = false;

        System.out.println("Ola, bem-vinde ao sistema de cadastro de vacinacao!");

        do {
            System.out.println("Informe a idade minima para a campanha de vacinacao, e a data atual:");
            idadeMinima = sc.nextInt();
            dataAtual = sc.nextInt();
            ControllerPessoa controllerPessoa = new ControllerPessoa(dataAtual);
            controllerPessoa.cadastraIdadeMinima(idadeMinima);
            System.out.println("Escolha uma opção\n" +
                    "(1) Cadastrar pessoa ao sistema\n" +
                    "(2) Cadastrar comorbidade a fila de prioridade\n" +
                    "(3) Cadastrar profissao a fila de prioridade\n" +
                    "(4) Vacinar\n" +
                    "(5) Alterar dados do cadastro\n" +
                    "(6) Mudar o dia\n" +
                    "(7) Sair do sistema");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    System.out.print("Informe o nome completo: ");
                    nome = sc.nextLine();
                    System.out.print("Informe o cpf: ");
                    cpf = sc.nextLine();
                    System.out.print("Informe o endereco: ");
                    endereco = sc.nextLine();
                    System.out.print("Informe o numero do cartao do sus: ");
                    cartaoSUS = sc.nextLine();
                    System.out.print("Informe o email: ");
                    email = sc.nextLine();
                    System.out.print("Informe a profissao: ");
                    profissao = sc.nextLine();
                    System.out.print("Informe a idade: ");
                    idade = sc.nextInt();
                    System.out.print("Informe o telefone: ");
                    telefone = sc.nextLine();
                    System.out.println("Informe as comorbidades:");
                    comorbidade = sc.nextLine();
                    controllerPessoa.cadastraPessoa(nome, cpf, endereco, cartaoSUS, email, telefone, profissao, idade, comorbidade);
                    System.out.println("Pessoa cadastrada!");
                    break;
                case 2:
                    System.out.print("Informe a comorbidade: ");
                    comorbidades = sc.nextLine();
                    controllerPessoa.addComorbidades(comorbidades);
                    System.out.println("Comorbidade cadastrada!");
                    break;
                case 3:
                    System.out.print("Informe a profissao: ");
                    profissao = sc.nextLine();
                    controllerPessoa.addProfissoes(profissao);
                    System.out.println("Profissao cadastrada!");
                    break;
                case 4:
                	controllerPessoa.vacina();
                    System.out.println("Pessoas vacinadas!");
                    break;
                case 5:
                    System.out.println("Quais dados deseja alterar?\n" +
                            "(1) Nome\n" +
                            "(2) CPF\n" +
                            "(3) Endereco\n" +
                            "(4) Numero do cartao do SUS\n" +
                            "(5) Email\n" +
                            "(6) Profissao\n" +
                            "(7) Comorbidade\n");
                    opcao = sc.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.print("Informe o nome completo: ");
                            nome = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(nome)) {
                                    System.out.print("Digite o novo nome: ");
                                    nome = sc.nextLine();
                                    pessoa.setNome(nome);
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Informe o CPF: ");
                            cpf = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(cpf)) {
                                    System.out.print("Digite o novo CPF: ");
                                    cpf = sc.nextLine();
                                    pessoa.setCpf(cpf);
                                }
                            }
                            break;
                        case 3:
                            System.out.print("Informe o endereco: ");
                            endereco = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(endereco)) {
                                    System.out.print("Digite o novo endereco: ");
                                    endereco = sc.nextLine();
                                    pessoa.setEndereco(endereco);
                                }
                            }
                            break;
                        case 4:
                            System.out.print("Informe o numero do cartao do SUS: ");
                            cartaoSUS = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(cartaoSUS)) {
                                    System.out.print("Digite o novo numero: ");
                                    cartaoSUS = sc.nextLine();
                                    pessoa.setNumCartaoSUS(cartaoSUS);
                                }
                            }
                            break;
                        case 5:
                            System.out.print("Informe o email: ");
                            email = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(email)) {
                                    System.out.print("Digite o novo nome: ");
                                    email = sc.nextLine();
                                    pessoa.setEmail(email);
                                }
                            }
                            break;
                        case 6:
                            System.out.print("Informe a profissao: ");
                            profissao = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(profissao)) {
                                    System.out.print("Digite a nova profissao: ");
                                    profissao = sc.nextLine();
                                    pessoa.setProfissao(profissao);
                                }
                            }
                            break;
                        case 7:
                            System.out.print("Informe a comorbidade: ");
                            comorbidade = sc.nextLine();
                            for (Pessoa pessoa : controllerPessoa.getPessoas()) {
                                if (pessoa.getNome().equals(comorbidade)) {
                                    System.out.print("Digite as novas comorbidades: ");
                                    comorbidade = sc.nextLine();
                                    pessoa.addComorbidade(comorbidade);                                }
                            }
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + opcao);
                    }
                    break;
                case 6:
                    controllerPessoa.mudaDia();
                    break;
                case 7:
                    encerrarSistema = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + opcao);
            }
        } while (!encerrarSistema);
    }
}
