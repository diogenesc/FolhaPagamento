package folhapagamento;

import java.io.Serializable;
import java.util.ArrayList;

public class Empregado implements Serializable {
    
    protected String nome,cpf,rg,dataadmissao,cargo,funcao;
    protected float salariobase;
    protected int dependentes;
    protected int fator;
    protected Calculos calc=new Calculos();
    
    //Construtor padrao
    public Empregado(){
    }
    
    //Contrutor para definir Nome, CPF, RG, data de admissão, cargo e função
    public Empregado(String nome, String cpf, String rg, String dataadmissao, String cargo, String funcao, float salariobase, int dependentes){
        this.nome=nome;
        this.cpf=cpf;
        this.rg=rg;
        this.dataadmissao=dataadmissao;
        this.cargo=cargo;
        this.funcao=funcao;
        this.salariobase=salariobase;
        this.dependentes=dependentes;
    }

    //Getter e Setter do numero de dependentes
    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }
    
    //Getter e Setter do salario base
    public float getSalariobase() {
        return salariobase;
    }

    protected void setSalariobase(float salariobase) {
        this.salariobase = salariobase;
    }

    public int getFator() {
        return fator;
    }

    public void setFator(int fator) {
        this.fator = fator;
    }
    
    /*protected String nome,cpf,rg,dataadmissao,cargo,funcao;
    protected float salariobase;
    protected int dependentes;*/
    
    public String[] getDados(){
        String []info=new String[8];
        info[0]=this.nome;
        info[1]=this.cpf;
        info[2]=this.rg;
        info[3]=this.dataadmissao;
        info[4]=this.cargo;
        info[5]=this.funcao;
        info[6]=String.valueOf(this.salariobase);
        info[7]=String.valueOf(this.dependentes);
        return info;
    }
    
    //Metodo padrao de calculo de ganhos
    protected float CalcularGanhos(){
        return 1;
    }
    
}
