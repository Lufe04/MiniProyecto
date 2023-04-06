package MiniProyecto;
public class Inscripcion {
    private String codAsi, codEst, nomAsi, nomEst, creditos, nota1, nota2, nota3;

    public Inscripcion(String codAsi, String codEst, String nomAsi, String nomEst, String creditos, String nota1, String nota2, String nota3) {
        this.codAsi = codAsi;
        this.codEst = codEst;
        this.nomAsi = nomAsi;
        this.nomEst = nomEst;
        this.creditos = creditos;
        this.nota1=nota1;
        this.nota2=nota2;
        this.nota3=nota3;
    }

    public String getCodAsi() {
        return codAsi;
    }

    public String getCodEst() {
        return codEst;
    }

    public String getNomAsi() {
        return nomAsi;
    }

    public String getNomEst() {
        return nomEst;
    }

    public String getCreditos() {
        return creditos;
    }

    public String getNota1() {
        return nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public String getNota3() {
        return nota3;
    }
    
    public void setCodAsi(String codAsi) {
        this.codAsi = codAsi;
    }

    public void setCodEst(String codEst) {
        this.codEst = codEst;
    }

    public void setNomAsi(String nomAsi) {
        this.nomAsi = nomAsi;
    }

    public void setNomEst(String nomEst) {
        this.nomEst = nomEst;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }
    
    @Override
    public String toString() {
        return this.codAsi+","+this.nomAsi+","+this.creditos+","+this.codEst+","+this.nomEst+","+this.nota1+","+this.nota2+","+this.nota3;
    }
    
    
}
