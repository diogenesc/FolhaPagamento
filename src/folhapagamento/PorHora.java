package folhapagamento;

import java.io.Serializable;

public class PorHora extends Empregado implements Serializable {

    private float ganho;
    static private float valorhora;

    //Define o valor pago por hora trabalhada, comum para todos os empregados que ganham por hora
    public static void setValorhora(float valorhora) {
        PorHora.valorhora = valorhora;
    }
    
    //Construtor padrao
    public PorHora(){
        
    }
    
    //Construtor com especificacoes que preencham a classe e superclasse
    public PorHora(String nome, String cpf, String rg, String dataadmissao, String cargo, String funcao, float salariobase, int dependentes){
        super(nome,cpf,rg,dataadmissao,cargo,funcao, salariobase, dependentes);
    }
    
    //Calcula ganho especifico do empregado
    public float CalcularGanhos(int qtdhora){
        this.ganho=(this.salariobase+(valorhora*qtdhora))-calc.calculaINSS(this.salariobase)-calc.calculaIRFF(this.salariobase,this.dependentes);
        return this.ganho;
    }
    
}
