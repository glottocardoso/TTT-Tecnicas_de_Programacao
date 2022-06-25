package aula03streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>(Arrays.asList(
           new Aluno("joao",5, "M"),
                new Aluno("maria",10, "F"),
                new Aluno("pedro",8, "M"),
                new Aluno("jessica",6, "F"),
                new Aluno("alice",4.5, "F"),
                new Aluno("marcos",4.5, "M"),
                new Aluno("maria",10, "F"),
                new Aluno("hugo",4.5, "M"),
                new Aluno("higor",5, "M"),
                new Aluno("caio",10, "M"),
                new Aluno("matheus",8, "M"),
                new Aluno("henrique",6, "M")
        ));

        Stream<Aluno> alunoStream = alunos.stream();

        //Soma - Feminino:
        double notasFeminino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("F"))
                .mapToDouble(Aluno::getNota)
                .sum();

        System.out.println("Soma de notas - Feminino: "+ notasFeminino);

        //Média - Feminino:
        OptionalDouble mediaFeminino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("F"))
                .mapToDouble(Aluno::getNota)
                .average();

        if (mediaFeminino.isPresent()) {
            System.out.println("Média de notas - Feminino: " + mediaFeminino.getAsDouble());
        }

        //Reprovados - Feminino:
        System.out.println("Reprovados - Feminino:");
        List<Aluno> reprovadosFeminino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("F"))
                .filter(aluno -> aluno.getNota() < 5)
                .toList();

        reprovadosFeminino.forEach(System.out::println);

        //Soma - Masculino:
        double notasMasculino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("M"))
                .mapToDouble(Aluno::getNota)
                .sum();

        System.out.println("Soma de notas - Masculino: "+ notasMasculino);

        //Média - Masculino:
        OptionalDouble mediaMasculino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("M"))
                .mapToDouble(Aluno::getNota)
                .average();

        if (mediaMasculino.isPresent()) {
            System.out.println("Média de notas - Masculino: " + mediaMasculino.getAsDouble());
        }

        //Reprovados - Masculino:
        System.out.println("Reprovados - Masculino:");
        List<Aluno> reprovadosMasculino = alunos
                .stream()
                .filter(aluno -> aluno.getGenero().equals("M"))
                .filter(aluno -> aluno.getNota() < 5)
                .toList();

        reprovadosMasculino.forEach(System.out::println);
    }
}
