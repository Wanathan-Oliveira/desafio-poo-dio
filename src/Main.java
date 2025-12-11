import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);


        //---- INTERFACE

        int opcao;
        Dev dev = new Dev();
        Scanner scanner = new Scanner(System.in);


        //---- WHILE


        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menu de Progressao ===");
            System.out.println("1. Cadastrar Dev.");
            System.out.println("2. Progredir.");
            System.out.println("3. Exibir Conteudos Inscritos.");
            System.out.println("4. Exibir Conteudos Concluidos.");
            System.out.println("5. Exibir XP Total.");
            System.out.println("6. Sair.");
            System.out.print("Escolha uma opcao: ");


            //---- FUNCAO NO BROKEN


            String entrada = scanner.nextLine();
            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite apenas números.");
                continue;
            }


            //---- CASE


            switch (opcao) {

                case 1:
                    System.out.print("Digite o nome do Dev: ");
                    String nomeDev = scanner.nextLine();
                    dev.setNome(nomeDev);
                    dev.inscreverBootcamp(bootcamp);
                    System.out.println("Conteúdos Inscritos "+ dev.getNome() +": " + dev.getConteudosInscritos());
                    break;

                case 2:
                    if (!dev.getConteudosInscritos().isEmpty()) {
                        dev.progredir();
                        System.out.println("Progresso realizado.\n");
                    } else {
                        System.out.println("Você não tem mais conteúdos inscritos.\n");
                    }
                    break;

                case 3:
                    System.out.println("Conteúdos Inscritos: \n" + dev.getConteudosInscritos() );
                    break;

                case 4:
                    System.out.println("Conteúdos Concluídos: \n" + dev.getConteudosConcluidos());
                    break;

                case 5:
                    System.out.println("XP:" + dev.calcularTotalXp());
                    break;

                case 6:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        }

    }

}
