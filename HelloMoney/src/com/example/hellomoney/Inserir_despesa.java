package com.example.hellomoney;


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
import java.io.*;
import java.nio.Buffer;
import java.util.Calendar;

import android.os.*;
import android.content.*;
import android.accounts.*;
import android.provider.*;

import android.widget.*;


public class Inserir_despesa extends Activity {
	
	TextView ct1,ct2,ct3;
	EditText et1,et2;
	Button bt1;
	public String desp;
	public double valor;
	public String Arquivo=  "Despesas.txt";
	Calendar cal = Calendar.getInstance();
	public String desc;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.inserir_despesa);
		ct1 = (TextView) findViewById(R.id.text_oraca_desp);
		ct2 = (TextView) findViewById(R.id.text_tipo_desp);
		bt1 = (Button) findViewById(R.id.bt_guarda_desp);
		et2 = (EditText) findViewById(R.id.editdesc_desp);
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
		et.setText(null);
		//ON CLICK LISTENER
		
		guarda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				desp = et.getText().toString(); //variavel orc com string proveniente da caixa de texto
				if(desp.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Tem de Inserir Valor", Toast.LENGTH_SHORT).show();
				}
				else
				{
				valor = Double.parseDouble(desp);
				if(valor <0.01 || valor>2000)
				{
					Toast.makeText(getApplicationContext(), "O valor tem de ser entre 0.1€ e 2000 €", Toast.LENGTH_SHORT).show();
					et.setText(null);
					et2.setText(null);
				}
				else
				{
				Despesa.setValor(valor);
				Orçamento.setValor(Orçamento.getValor()-Despesa.getValor());
				try {
					FileOutputStream arquivoGravar = openFileOutput("Orçameto.txt",MODE_PRIVATE);
					String primeiro
							= ""+Orçamento.getValor();
					arquivoGravar.write(primeiro.getBytes());
					arquivoGravar.close();}
				catch(IOException erro)
				{} 
				Toast.makeText(getApplicationContext(), "Despesa inserido = " + Despesa.getValor() + "€", Toast.LENGTH_SHORT).show();
				insere_arquivo();
				startActivity(new Intent(Inserir_despesa.this,DespesaActivity.class));
				}
				}
			}
		});
							}
	private void insere_arquivo()
	{
		desc=et2.getText().toString();
		int dia,ano,mes;
		dia=cal.get(Calendar.DAY_OF_MONTH);
		ano = cal.get(Calendar.YEAR);
		mes= cal.get(Calendar.MONTH)+1;
		try {
			FileOutputStream arquivoGravar = openFileOutput("Despesas.txt",MODE_APPEND);
			String primeiro
					= Despesa.getTipo()+" "+Despesa.getValor()+" "+dia+" "+mes+" "+ano+" "+desc;
			arquivoGravar.write(primeiro.getBytes());
			arquivoGravar.write("\n".getBytes());
			arquivoGravar.close();}
		catch(IOException erro)
		{}  
  
    }
  
    }


