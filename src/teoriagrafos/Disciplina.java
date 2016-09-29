package teoriagrafos;

public class Disciplina {
    private int anoDisciplina;
    private int periodoDisciplina;

    
    public Disciplina(int anoDisciplina, int periodoDisciplina) {
        this.anoDisciplina = anoDisciplina;
        this.periodoDisciplina = periodoDisciplina;
    }

    public int getAnoDisciplina() {
        return anoDisciplina;
    }

    public void setAnoDisciplina(int anoDisciplina) {
        this.anoDisciplina = anoDisciplina;
    }

    public int getPeriodoDisciplina() {
        return periodoDisciplina;
    }

    public void setPeriodoDisciplina(int periodoDisciplina) {
        this.periodoDisciplina = periodoDisciplina;
    }
}
