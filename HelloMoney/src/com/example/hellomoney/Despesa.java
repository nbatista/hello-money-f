package com.example.hellomoney;

import android.widget.TextView;

public class Despesa {
	static double valor;
	static String tipo;

public static double getValor(){
		
		return valor;
		
	}
public static String getTipo(){
	
	return tipo;
	
}
	
	public static double setValor(double set_valor){
		valor=set_valor;
		return valor;
		
	}
	public static String setTipo(String set_tipo){
		tipo=set_tipo;
		return tipo;
		
	}
	
	public static double resetValor(double reset_valor){
		
		valor=reset_valor;
		return valor;
	}
	
	public static double minusValor(double minus_valor){
		
		valor-=minus_valor;
		return valor;
	}
	
		public static void update(TextView tv){
		
		String textview;
		String resid;
		textview=getTipo();
		resid = textview;
		tv.setText("Despesa -> "+resid);
	}

}