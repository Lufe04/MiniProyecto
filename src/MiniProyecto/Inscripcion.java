package MiniProyecto;
public class Inscripcion {
    private String codAsi, codEst, nomAsi, nomEst, creditos;

    public Inscripcion(String codAsi, String codEst, String nomAsi, String nomEst, String creditos) {
        this.codAsi = codAsi;
        this.codEst = codEst;
        this.nomAsi = nomAsi;
        this.nomEst = nomEst;
        this.creditos = creditos;
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

    @Override
    public String toString() {
        return this.codAsi+","+this.nomAsi+","+this.creditos+","+this.codEst+","+this.nomEst;
    }
    
    
}
