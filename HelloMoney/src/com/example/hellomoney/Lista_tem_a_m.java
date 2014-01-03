package com.example.hellomoney;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashMap;

import android.R.string;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;

public class Lista_tem_a_m extends Activity{
	TextView t1,t2,t3;
	EditText et;
	Button bt1,bt2;
	public float total;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_tempo_a_m);
		bt1 = (Button) findViewById(R.id.bt_aceita_lista);
		bt2 = (Button) findViewById(R.id.btlista_m_a_conc);
		t1 = (TextView) findViewById(R.id.textlista_m_a);
		t2 = (TextView) findViewById(R.id.texttipolista);
		t3 = (TextView) findViewById(R.id.textViewlistaam);
		et = (EditText) findViewById(R.id.editdesc_desp);
		t3.setMovementMethod(new ScrollingMovementMethod());
		updateOrcamento(t1);
		updateLista(t2);
		Listar();
		Concluir();
	}
	
	public void Listar()
	{
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				t3.setText(null);
				String orc = et.getText().toString(); 
				if(orc.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Tem de Inserir Valor", Toast.LENGTH_SHORT).show();
				}
				else
				{
				float valor = Float.parseFloat(orc);
				if(Despesa.getTipo().equals("Ano"))
				{
					if(valor >= 2014)
					{
						File ler_arquivo = getFileStreamPath("Despesas.txt");	
						if(ler_arquivo.exists())
						{
							String str;
							try{
							FileInputStream le_arq = openFileInput("Despesas.txt");
							BufferedReader reader = new BufferedReader(new InputStreamReader(le_arq));
					        if (le_arq!=null) { 
					        	total=0;
					            while ((str = reader.readLine()) != null) { 
					            	String[] separa = str.split(" ");
					            	total += Float.parseFloat(separa[1]);
					            	float val_c = Float.parseFloat(separa[4].toString());
					            	if(val_c == valor){
					            		t3.append(separa[0]+"\t"+separa[1]+"€\t"+separa[2]+"/"+separa[3]+"/"+separa[4]);
					            		if(separa.length>5)
					            		{
					            			t3.append("  <");
					            		for(int i=5;i<separa.length;i++)
					            		{
					            			t3.append(" "+separa[i]);
					            		}
					            		t3.append(">");
					            		}
					            		t3.append("\n");
					            	}
					            }       	
					        le_arq.close();
					        t3.append("Total --> "+total+"€");
							}
							}
							catch(IOException erro){};
							}
					}
					else
					{Toast.makeText(getApplicationContext(), "Valor igual ou acima de 2014", Toast.LENGTH_SHORT).show();}
				}
				if(Despesa.getTipo().equals("Mes"))
				{
					if(valor >= 1 && valor <=12)
					{
						File ler_arquivo = getFileStreamPath("Despesas.txt");	
						if(ler_arquivo.exists())
						{
							String str;
							try{
							FileInputStream le_arq = openFileInput("Despesas.txt");
							BufferedReader reader = new BufferedReader(new InputStreamReader(le_arq));
							total =0;
							if (le_arq!=null) {                         
					            while ((str = reader.readLine()) != null) { 
					            	String[] separa = str.split(" ");
					            	total += Float.parseFloat(separa[1]);
					            	float val_c = Float.parseFloat(separa[3]);
					            	if(val_c==valor)
					            		t3.append(separa[0]+"\t"+separa[1]+"€\t"+separa[2]+"/"+separa[3]+"/"+separa[4]);
				            				if(separa.length>5)
				            				{
				            					t3.append("  <");
				            						for(int i=5;i<separa.length;i++)
				            						{
				            							t3.append(" "+separa[i]);
				            						}
				            						t3.append(">");
				            				}
				            				t3.append("\n");
					            }       	
					        le_arq.close();
					        t3.append("Total --> "+total+"€");
							}
							}
							catch(IOException erro){};
							}
					}
					else
					{Toast.makeText(getApplicationContext(), "Valor entre 1 e 14", Toast.LENGTH_SHORT).show();}
				}
				
			}
			}
		});
	}
	public void Concluir()
	{
			bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(Lista_tem_a_m.this,lista_tempo.class));
				
			}
		});
	}
	
	private void updateOrcamento(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Orçamento.update(tv);
	}
	private void updateLista(TextView tc)
	{
		tc.setText("Tipo -> "+Despesa.getTipo());
	}

}
