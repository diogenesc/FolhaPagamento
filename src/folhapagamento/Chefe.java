package folhapagamento;

import java.io.Serializable;

public class Chefe extends Empregado implements Serializable {
    
    private float ganho;

    //Construtor padrao
    public Chefe(){
        
    }
    
    //Construtor com especificacoes que preencham a classe e superclasse
    public Chefe(String nome, String cpf, String rg, String dataadmissao, String cargo, String funcao, float salariobase, int dependentes){
        super(nome,cpf,rg,dataadmissao,cargo,funcao, salariobase, dependentes);
    }
    
    @Override
    public float CalcularGanhos(){
        this.ganho=this.salariobase-calc.calculaINSS(this.salariobase)-calc.calculaIRFF(this.salariobase,this.dependentes);
        return this.ganho;
    }
    
}
