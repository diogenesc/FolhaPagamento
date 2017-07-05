package folhapagamento;

import java.io.Serializable;

public class Vendedor extends Empregado implements Serializable {

    private float ganho;
    static private float porvenda;

    //Define o valor por venda, comum para todos os vendedores
    public static void setPorvenda(float porvenda){
        Vendedor.porvenda=porvenda;
    }
    
    //Construtor padrao
    public Vendedor(){
        
    }
    
    //Construtor com especificacoes que preencham a classe e superclasse
    public Vendedor(String nome, String cpf, String rg, String dataadmissao, String cargo, String funcao, float salariobase, int dependentes){
        super(nome,cpf,rg,dataadmissao,cargo,funcao, salariobase, dependentes);
    }
   
    //Calculo de ganhos especifico do vendedor
    public float CalcularGanhos(int qtdvendas){
        this.ganho=(this.salariobase+(qtdvendas*porvenda))-calc.calculaINSS(this.salariobase)-calc.calculaIRFF(this.salariobase,this.dependentes);
        return ganho;
    }
    
}
