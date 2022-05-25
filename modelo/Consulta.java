package modelo;

import java.sql.Date;

public class Consulta {

    private long id;
    private long idmedico;
    private long idpaciente;
    private long idusuario;
    private Date dataEntrada;
    private Date dataSaida;
    private Double valorConsulta;
    private Date dataCadastro;

    public long getIdmedico() {
        return idmedico;
    }

    public void setIdmedico(long idmedico) {
        this.idmedico = idmedico;
    }

    public long getIdpaciente() {
        return idpaciente;
    }

    public void setIdpaciente(long idpaciente) {
        this.idpaciente = idpaciente;
    }

    public long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(long idusuario) {
        this.idusuario = idusuario;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    

}
