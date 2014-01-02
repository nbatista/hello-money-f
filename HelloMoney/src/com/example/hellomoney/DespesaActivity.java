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

public class DespesaActivity extends Activity {
	
	String [] despesas ={"Habitação","Alimentação","Vicios"};
	Button bt1,bt2,bt3,bt4,bt5,bt6;
	TextView t1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.despesa_activity);
		bt1 = (Button) findViewById(R.id.btalim);
		bt2 = (Button) findViewById(R.id.bthab);
		bt3 = (Button) findViewById(R.id.btnaopre);
		bt4 = (Button) findViewById(R.id.btvia);
		bt5= (Button) findViewById(R.id.btvic);
		bt6 = (Button)findViewById(R.id.bt_menu_inical);
		t1 = (TextView) findViewById(R.id.text_orc);
		bt_viagem();
		bt_vicios();
		bt_alimentacao();
		bt_habitacao();
		bt_nao_predefinido();
		bt_menu_inical();
		updateOrcamento(t1);
		
		//setListAdapter(new ArrayAdapter<string>(this, android.R.layout.simple_list_item_1));
		
		/*lv = (ListView) findViewById(R.id.listView1);
		
		constroiLista();
	
		registerClickCallback();*/
	}
	public void bt_viagem()
	{
		bt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Viagem");
				startActivity(new Intent(DespesaActivity.this,Inserir_despesa.class));
			}
		});
	}
	public void bt_vicios()
	{
		bt5.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Vicios");
				startActivity(new Intent(DespesaActivity.this,Inserir_despesa.class));
			}
		});
	}
	public void bt_alimentacao()
	{
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Alimentação");
				startActivity(new Intent(DespesaActivity.this,Inserir_despesa.class));
				
			}
		});
	}
	public void bt_habitacao()
	{
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Habitação");
				startActivity(new Intent(DespesaActivity.this,Inserir_despesa.class));
			}
		});
	}
	public void bt_nao_predefinido()
	{
		bt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Não Pré-Definido");
				startActivity(new Intent(DespesaActivity.this,Inserir_despesa.class));
				
			}
		});
	}
	public void bt_menu_inical()
	{
		bt6.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Despesa.setTipo("Não Pré-Definido");
				startActivity(new Intent(DespesaActivity.this,MainActivity.class));
				
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

	/*private void registerClickCallback() {
		// TODO Auto-generated method stub
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				finish();
				
				
			}});
	}
	private void constroiLista() {
		// TODO Auto-generated method stub
		// todo CRIAR LISTA
		String [] despesas = {"Habitação", "Alimentação","Vicios","Automovel"};
		
		//TODO construir adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				this, 
				R.layout.despesa_activity,
				despesas);
		//
		ListView list = (ListView) findViewById(R.id.listView1);
		list.setAdapter(adapter);
		
		
	}*/
	



	
}
