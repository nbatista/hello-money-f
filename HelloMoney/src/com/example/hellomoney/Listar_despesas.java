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

public class Listar_despesas extends Activity
{
	Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
	TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lista_despesas);
		bt1 = (Button) findViewById(R.id.bt_l_ali);
		bt2 = (Button) findViewById(R.id.bt_l_hab);
		bt3 = (Button) findViewById(R.id.bt_l_nao);
		bt4 = (Button) findViewById(R.id.bt_l_viagens);
		bt5= (Button) findViewById(R.id.bt_l_vicios);
		bt6 = (Button)findViewById(R.id.bt_l_m_i);
		t1 = (TextView) findViewById(R.id.listar_desp_orc);
		bt_viagem();
		bt_vicios();
		bt_alimentacao();
		bt_habitacao();
		bt_nao_predefinido();
		bt_menu_inical();
		updateOrcamento(t1);
		
	
		
	}
		
	public void bt_viagem()
	{
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Viagem");
				startActivity(new Intent(Listar_despesas.this,Lista.class));
			}
		});
	}
	public void bt_vicios()
	{
		bt5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Vicios");
				startActivity(new Intent(Listar_despesas.this,Lista.class));
			}
		});
	}
	public void bt_alimentacao()
	{
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Alimentação");
				startActivity(new Intent(Listar_despesas.this,Lista.class));
				
			}
		});
	}
	public void bt_habitacao()
	{
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Habitação");
				startActivity(new Intent(Listar_despesas.this,Lista.class));
			}
		});
	}
	public void bt_nao_predefinido()
	{
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Não Pré-Definido");
				startActivity(new Intent(Listar_despesas.this,Lista.class));
				
			}
		});
	}
	public void bt_menu_inical()
	{
		bt6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Não Pré-Definido");
				startActivity(new Intent(Listar_despesas.this,MainActivity.class));
				
			}
		});
	}
	public void onListItemClick(ListView parent, View v,int position, long id ){
		
		
		
	}
	private void setListAdapter(ArrayAdapter<string> arrayAdapter) {
		// TODO Auto-generated method stub
		
	}
	
	
	private void updateOrcamento(TextView tv) {
		// TODO VERIFICAR SE A FICHEIRO E SE TEM VALOR
		
		Orçamento.update(tv);
	}
}
