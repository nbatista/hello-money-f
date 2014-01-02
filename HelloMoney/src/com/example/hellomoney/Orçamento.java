package com.example.hellomoney;

import android.widget.TextView;

public class Orçamento {
	public static float valor;


	public static float getValor(){
		
		return valor;
		
	}
	
	public static float setValor(float set_valor){
		valor=set_valor;
		return valor;
		
	}
	
	public static float addValor(float add_valor){
		
		valor+=add_valor;
		return valor;
	}
	
	public static float resetValor(float reset_valor){
		
		valor=reset_valor;
		return valor;
	}
	
	public static float minusValor(float minus_valor){
		
		valor-=minus_valor;
		return valor;
	}
	
	public static void update(TextView tv){
		
		float textview;
		String resid;
		textview=Orçamento.getValor();
		resid = Float.toString(textview);
		tv.setText(resid + " €");
	}

}




