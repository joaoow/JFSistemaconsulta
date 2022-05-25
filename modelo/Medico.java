package modelo;

import java.sql.Date;

public class Medico {

    
    private long id;
    private long idEspecialidades;
    private String nomeCompleto;
    private String numCrm;
    private String cpf;
    private Date dataNascimento;
    private String sexo;
    private String ddd;
    private String telefone;
    private String email;
    private Date dataCadastro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEspecialidades() {
        return idEspecialidades;
    }

    public void setIdEspecialidades(long idEspecialidades) {
        this.idEspecialidades = idEspecialidades;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNumCrm() {
        return numCrm;
    }

    public void setNumCrm(String numCrm) {
        this.numCrm = numCrm;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    @Override
    public String toString(){
        return this.getNomeCompleto();
    }
    
}
