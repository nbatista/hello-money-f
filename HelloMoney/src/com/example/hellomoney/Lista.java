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
import android.text.method.ScrollingMovementMethod;
import android.os.*;
import android.content.*;
import android.accounts.*;
import android.provider.*;

import android.widget.*;


public class Lista extends Activity {
	
	TextView ct1,ct2,ct3;
	EditText et1;
	Button bt1;
	public String desp;
	public float valor;
	public String Arquivo=  "Despesas.txt";
	public float total;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.lista);
		ct1 = (TextView) findViewById(R.id.textViewtipodespesa);
		ct2 = (TextView) findViewById(R.id.text_lista_orc);
		ct3 = (TextView) findViewById(R.id.textViewlista);
		ct3.setMovementMethod(new ScrollingMovementMethod());
		updateOrcamento(ct2);
		updateDespesa(ct1);
		
		File ler_arquivo = getFileStreamPath("Despesas.txt");	
		if(ler_arquivo.exists())
		{
			String str;
			try{
			FileInputStream le_arq = openFileInput("Despesas.txt");
			BufferedReader reader = new BufferedReader(new InputStreamReader(le_arq));
	        if (le_arq!=null) {                         
	            while ((str = reader.readLine()) != null) { 
	            	String[] separa = str.split(" ");
	            	total+=Float.parseFloat(separa[1]);
	            	if(separa[0].equals(Despesa.getTipo()))
	            	{
	            		ct3.append(separa[0]+"\t"+separa[1]+"€\t"+separa[2]+"/"+separa[3]+"/"+separa[4]);
	            		if(separa.length>4)
	            			ct3.append(" < ");
	            		for(int i=5;i<separa.length;i++)
	            		{
	            			ct3.append(" "+separa[i]);
	            		}
	            		if(separa.length>4)
	            			ct3.append(" >");
	            		ct3.append("\n");
	            	}
	            }       	
	        le_arq.close();
	        ct3.append("Total --> "+total+"€");
			}
			}
			catch(IOException erro){};
			}
		
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
		Button guarda = (Button) findViewById(R.id.btconc);
				
		guarda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(Lista.this,Listar_despesas.class));
			}
		});
	}
  
    }


