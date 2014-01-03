package com.example.hellomoney;

import java.util.ArrayList;

import java.util.HashMap;

import android.R.string;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

public class lista_tempo extends Activity
{
	Button bt1,bt2,bt3,bt4;
	TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_tempo);
		bt2 = (Button) findViewById(R.id.bt_lista_t_mes);
		bt3 = (Button) findViewById(R.id.bt_lista_t_ano);
		bt4 = (Button) findViewById(R.id.bt_lista_t_menuini);
		t1 = (TextView) findViewById(R.id.orc_lista_t);
		bt_mes();
		bt_ano();
		bt_menu_inical();
		updateOrcamento(t1);
		
	
		
	}
		
	public void bt_mes()
	{
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Mes");
				startActivity(new Intent(lista_tempo.this,Lista_tem_a_m.class));
			}
		});
	}
	
	public void bt_ano()
	{
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Ano");
				startActivity(new Intent(lista_tempo.this,Lista_tem_a_m.class));
			}
		});
	}
	
	public void bt_menu_inical()
	{
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(lista_tempo.this,MainActivity.class));
				
			}
		});
	}
	
	
	private void updateOrcamento(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Orçamento.update(tv);
	}
}
