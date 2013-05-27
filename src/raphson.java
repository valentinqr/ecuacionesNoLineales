import java.awt.EventQueue;

import de.congrace.exp4j.Calculable;
import de.congrace.exp4j.ExpressionBuilder;
import de.congrace.exp4j.UnknownFunctionException;
import de.congrace.exp4j.UnparsableExpressionException;


public class raphson {
	
	private static String function;
	
	    public static void main(String A[])
	    {
	    	EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Numerico window = new Numerico();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
	    	
	        
	    	
	    }
	    /**
	     * Aqui se hace el proceso iterativo para aproximar la raiz
	     * @param x0.- valor inicial
	     * @param Er.- error de paro
	     * @param MaxIt.- Maximo de iteracion que realiza
	     * @return raiz aproximada.
	     */
	    public static double Newton(double x0, double Er, int MaxIt)
	    {
	        double raiz=0,delta=0.0001,Error=1,raize=0;

	        for(int i=1; i<=MaxIt; i++)
	        {
	            raiz=x0 - F(x0)/dF(x0,delta);
	            Error=Math.abs((raiz - x0)/raiz);
	            if(Error<=Er)
	            {
	                raize=raiz;
	                break;
	            }
	            x0=raiz;
	            System.out.println("Iteracion: "+i+" \tEa = "+Error+" \t Raiz = "+raiz);
	        }
	        return raize;
	    }
	    /**
	     * Aqui se encuentra la funcion de la cual se calcula su raiz
	     * @param x: valor de x donde se evalua
	     * @return funcion evaluada en x.
	     */
	    public static double F(double x)
	    {
	    	Calculable calc = null;
			try {
		        double varY = 0;
				calc = new ExpressionBuilder(function)
				.withVariable("x", x)
				.withVariable("y", varY)
				.build();
			} catch (UnknownFunctionException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (UnparsableExpressionException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        return calc.calculate();
	    }
	    /**
	     * Aqui se calcula la derivada, haciendo uso de la definicion de limite
	     * es decir usando una diferencia finitta
	     * @param x: valor donde se evalua la derivada
	     * @param delta: espacio de evaluacion
	     * @return derivada evaluada en x
	     */
	    public static double dF(double x, double delta)
	    {
	        return (F(x+delta) - F(x))/delta;
	    }
	    
	    public static void setFunction(String textField){
	    	function = textField;
	    }
	    
}

