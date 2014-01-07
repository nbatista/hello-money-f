package com.example.hellomoney;

import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import com.example.hellomoney.Orçamento;
import com.example.hellomoney.MainActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InserirActivity extends Activity {
	
	public String orc;
	public double valor;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inserir_activity);

		//EditText et = (EditText) findViewById(R.id.editText1);
		butGuardar();
	}



	private void butGuardar() {
		// TODO VARIAVEIS
		//final TextView tv = (TextView) findViewById(R.id.textView1);
		Button guarda = (Button) findViewById(R.id.but_guardar_desp);
		final EditText et = (EditText) findViewById(R.id.text_orc);
		//ON CLICK LISTENER
		
		guarda.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				orc = et.getText().toString(); //variavel orc com string proveniente da caixa de texto
				if(orc.equals(""))
				{
					Toast.makeText(getApplicationContext(), "Tem de Inserir Valor", Toast.LENGTH_SHORT).show();
				}
				else
				{

				valor = Double.parseDouble(orc); //variavel valor como Double proveniente de orc
				if(valor <= 0.1 || valor >= 4000 )
				{
					Toast.makeText(getApplicationContext(), "O valor tem de ser entre 0.1€ e 4000 €", Toast.LENGTH_SHORT).show();
					et.setText(null);
				}
				else
				{
				if(Orçamento.getValor() == 0){Orçamento.setValor(valor);
				Toast.makeText(getApplicationContext(), "Orçamento inserido = " + Orçamento.getValor() + "€", Toast.LENGTH_SHORT).show();
				}
				else {Orçamento.addValor(valor);
				Toast.makeText(getApplicationContext(), "Orçamento actual = " + Orçamento.getValor() + "€", Toast.LENGTH_SHORT).show();}
				try {
					FileOutputStream arquivoGravar = openFileOutput("Orçameto.txt",MODE_PRIVATE);
					String primeiro
							= ""+Orçamento.getValor();
					arquivoGravar.write(primeiro.getBytes());
					arquivoGravar.close();}
				catch(IOException erro)
				{} 
				finish();
				}
				}
			}
		});
		
		
	}
	

}
