package teoriagrafos;

public class Aluno {
    private String nome;
    private int ano;
    private Disciplina disciplina;

    public Aluno(String nome, int ano, Disciplina disciplina) {
        this.nome = nome;
        this.ano = ano;
        this.disciplina = disciplina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }   
}
