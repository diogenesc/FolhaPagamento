package folhapagamento;

import java.io.Serializable;

public class PorPeca extends Empregado implements Serializable {

    private float ganho;
    static private float valorpeca;

    //Define o valor pago por peça instalada, comum para todos os empregados que ganham por peca
    public static void setValorpeca(float valorpeca) {
        PorPeca.valorpeca = valorpeca;
    }
    
    //Construtor padrao
    public PorPeca(){
        
    }
    
    //Construtor com especificacoes que preencham a classe e superclasse
    public PorPeca(String nome, String cpf, String rg, String dataadmissao, String cargo, String funcao, float salariobase, int dependentes){
        super(nome,cpf,rg,dataadmissao,cargo,funcao, salariobase, dependentes);
    }
    
    //Calcula ganho especifico do empregado
    public float CalcularGanhos(int qtdpecas){
        this.ganho=(this.salariobase+(valorpeca*qtdpecas))-calc.calculaINSS(this.salariobase)-calc.calculaIRFF(this.salariobase,this.dependentes);
        return this.ganho;
    }
    
}
