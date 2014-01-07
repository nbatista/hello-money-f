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
	EditText et,et2;
	Button bt1,bt2;
	public float total;
	public String orc;
	public float mes,ano;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_tempo_a_m);
		bt1 = (Button) findViewById(R.id.bt_aceita_lista);
		bt2 = (Button) findViewById(R.id.btlista_m_a_conc);
		t1 = (TextView) findViewById(R.id.textlista_m_a);
		t2 = (TextView) findViewById(R.id.texttipolista);
		t3 = (TextView) findViewById(R.id.textViewlistaam);
		et = (EditText) findViewById(R.id.editdesc_desp);
		et2 =(EditText) findViewById(R.id.editTextano);
		t3.setMovementMethod(new ScrollingMovementMethod());
		if(Despesa.getTipo().equals("Ano"))
			et.setVisibility(View.GONE);
		if(Despesa.getTipo().equals("Mes"))
			et.setVisibility(View.VISIBLE);
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
				if(Despesa.getTipo().equals("Ano"))
				{
					orc = et2.getText().toString();
					if(orc.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Tem de Inserir Valor", Toast.LENGTH_SHORT).show();
					}
					else
					{
					ano = Float.parseFloat(orc);
					if(ano >= 2014)
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
					            	float val_c = Float.parseFloat(separa[4].toString());
					            	if(val_c == ano){
					            		total += Float.parseFloat(separa[1]);
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
					{
						Toast.makeText(getApplicationContext(), "Ano tem de ser superior a 2014", Toast.LENGTH_SHORT).show();
					}
				}
				}
				if(Despesa.getTipo().equals("Mes"))
				{
					orc = et2.getText().toString();
					String orc1 = et2.getText().toString();
					orc1 = et.getText().toString();
					if(orc.equals("") || orc1.equals(""))
					{
						Toast.makeText(getApplicationContext(), "Tem de inserir ano e mes", Toast.LENGTH_SHORT).show();
					}
					else
					{
						ano = Float.parseFloat(orc);
						mes = Float.parseFloat(orc1);
					if(mes >= 1 && mes <=12 && ano >= 2014)
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
					            	float val_c = Float.parseFloat(separa[3]);
					            	float val_ca=Float.parseFloat(separa[4]);
					            	if(val_c==mes && val_ca==ano)
					            	{
					            		total += Float.parseFloat(separa[1]);
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
					{Toast.makeText(getApplicationContext(), "Valor mes entre 1 e 12 e ano maior que 2014", Toast.LENGTH_SHORT).show();}
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
