package aula03streams;

public class Aluno {
    private String nome;
    private double nota;
    private String genero;

    public Aluno(String nome, double nota, String genero) {
        this.nome = nome;
        this.nota = nota;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", nota=" + nota +
                ", genero='" + genero + '\'' +
                '}';
    }
}

