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

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
	private Handler handler;
	private boolean Running = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final TextView tv = (TextView) findViewById(R.id.text_orc_desp);
		butInserir();
		butDespesa();
		butLista();
		butGrafico();
		butAbout();
	/*	try {
			file();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		updateOrcamento(tv);
		
		
		
		handler = new Handler();
		Runnable runnable = new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(Running){
					try{
						Thread.sleep(1000);
						}
					catch(InterruptedException e){
						e.printStackTrace();
					}
					handler.post(new Runnable(){

						@Override
						public void run() {
							// TODO Auto-generated method stub
							tv.setText(String.valueOf(Or�amento.getValor()) + " �");
						}
						
				});
			}
			}
		};
		
		new Thread(runnable).start();
		}

	/*private void file() throws IOException {
		// TODO Auto-generated method stub
		String FILENAME = "hello_file";
		int value = 666;

		FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
		fos.write(value);
		fos.close();
		
	}*/

	private void updateOrcamento(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Or�amento.update(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void butInserir(){
		Button botao = (Button) findViewById(R.id.but_inserir);
		
		botao.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				startActivity(new Intent(MainActivity.this,InserirActivity.class));
				
			}
		});
		
			
		}
		
	private void butDespesa() {
			Button despesa = (Button) findViewById(R.id.but_despesa);
			despesa.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(MainActivity.this,DespesaActivity.class));
					//Toast.makeText(getApplicationContext(), "Fun��o n�o implementada!", Toast.LENGTH_SHORT).show();
				}
				
			});
		}
	
	private void butLista() {
		Button lista = (Button) findViewById(R.id.but_lista);
		lista.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//startActivity(new Intent(MainActivity.this,ListarActivity.class));
				Toast.makeText(getApplicationContext(), "Fun��o n�o implementada!", Toast.LENGTH_SHORT).show();
			}
			
		});
	}
	
	private void butGrafico() {
		Button graf = (Button) findViewById(R.id.but_graf);
		graf.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//startActivity(new Intent(MainActivity.this,GrafActivity.class));
				Toast.makeText(getApplicationContext(), "Fun��o n�o implementada!", Toast.LENGTH_SHORT).show();
			}
			
		});
	}
	
	private void butAbout(){
		Button ajuda = (Button) findViewById(R.id.but_about);
		ajuda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent(MainActivity.this,AjudaActivity.class));
				showOneButtonDialog();
			}
			
		});
	}
	
	
	private void showOneButtonDialog(){
		AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
		dialogBuilder.setTitle("Hello Money V0.1");
		dialogBuilder.setMessage("ISEC\n - Engenharia Inform�tica\n - Gest�o Projecto Software\n - Trabalho desenvolvido por Tiago Pereira e Cristiano Malaquias");
		dialogBuilder.setPositiveButton("Voltar. .",new DialogInterface.OnClickListener(){
			
				public void onClick(DialogInterface dialog, int which){
					Toast.makeText(getApplicationContext(), "Vamos poupar...", Toast.LENGTH_SHORT).show();
				}
		});
		AlertDialog alertDialog = dialogBuilder.create();
		alertDialog.show();
	}
	}

	
		


