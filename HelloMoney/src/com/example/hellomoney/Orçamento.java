package com.example.hellomoney;

import java.text.DecimalFormat;

import android.widget.TextView;

public class Orçamento {
	public static double valor;


	public static double getValor(){
		
		return valor;
		
	}
	
	public static double setValor(double set_valor){
		valor=set_valor;
		return valor;
		
	}
	
	public static double addValor(double add_valor){
		
		valor+=add_valor;
		return valor;
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
		
		double textview;
		textview=Orçamento.getValor();
		tv.setText(String.format("%.2f €",textview));
	}

}




