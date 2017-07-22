package folhapagamento;

import java.io.Serializable;

public class Calculos implements Serializable {

    public float calculaINSS(float salariobase){
        float result=0;
        if(salariobase<=1659.38){
            return (float) (salariobase*0.08);
        }
        else if(salariobase>=1659.39 && salariobase<=2765.66){
            return (float) (salariobase*0.09);
        }else if(salariobase>=2765.67 && salariobase<=5531.31){
            return (float) (salariobase*0.11);
        }
        return result;
    }
    
    public float calculaFGTS(float salariobase){
        return (float) (salariobase*0.08);
    }
    
    public float calculaIRFF(float salariobase, int dependentes){
        float result=0;
        float base=(float) (salariobase-calculaINSS(salariobase)-(dependentes*189.59));
        if(base<=1903.98){
            return result;
        }
        else if(base>=1903.99 && base<=2826.65){
            return (float) ((base*0.075)-142.8);
        }else if(base>=2826.66 && base<=3751.05){
            return (float) ((base*0.15)-354.8);
        }else if(base>=3751.06 && base<=4664.68){
            return (float) ((base*0.225)-636.13);
        }else if(base>=4664.68){
            return (float) ((base*0.275)-869.36);
        }
        return result;
    }
        
}
