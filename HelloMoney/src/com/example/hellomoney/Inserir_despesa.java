package com.example.hellomoney;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.*;


public class Inserir_despesa extends Activity {
	
	TextView ct1,ct2;
	EditText et1;
	Button bt1;
	public String desp;
	public float valor;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.inserir_despesa);
		ct1 = (TextView) findViewById(R.id.text_oraca_desp);
		ct2 = (TextView) findViewById(R.id.text_tipo_desp);
		bt1 = (Button) findViewById(R.id.bt_guarda_desp);
		updateOrcamento(ct1);
		updateDespesa(ct2);
		
		butGuardar();
	}
	
	private void updateOrcamento(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Orçamento.update(tv);
	}
	private void updateDespesa(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Despesa.update(tv);
	}
	
	private void butGuardar() {
		// TODO VARIAVEIS
		//final TextView tv = (TextView) findViewById(R.id.textView1);
		Button guarda = (Button) findViewById(R.id.bt_guarda_desp);
		final EditText et = (EditText) findViewById(R.id.text_desp);
		//ON CLICK LISTENER
		
		guarda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				desp = et.getText().toString(); //variavel orc com string proveniente da caixa de texto
				valor = Float.parseFloat(desp); //variavel valor como float proveniente de orc
				
				Despesa.setValor(valor);
				Orçamento.setValor(Orçamento.getValor()-Despesa.getValor());
				Toast.makeText(getApplicationContext(), "Despesa inserido = " + Despesa.getValor() + "€", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(Inserir_despesa.this,DespesaActivity.class));
			}
		});
}
}
