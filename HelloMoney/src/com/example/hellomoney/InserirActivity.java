package com.example.hellomoney;

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
	public float valor;
	
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
				valor = Float.parseFloat(orc); //variavel valor como float proveniente de orc
						 
				if(Orçamento.getValor() == 0){Orçamento.setValor(valor);
				Toast.makeText(getApplicationContext(), "Orçamento inserido = " + Orçamento.getValor() + "€", Toast.LENGTH_SHORT).show();}
				else {Orçamento.addValor(valor);
				Toast.makeText(getApplicationContext(), "Orçamento actual = " + Orçamento.getValor() + "€", Toast.LENGTH_SHORT).show();}
				finish();
			}
		});
		
		
	}
	

}
