package com.rlds.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {
    private Context context;
    private  final String  NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";
    private SharedPreferences preferences;
    private  SharedPreferences.Editor editor; // salvar anotacoes

    public AnotacaoPreferencias(Context c) {
        this.context = c;
        preferences = context.getSharedPreferences(NOME_ARQUIVO,0);
        editor = preferences.edit();

    }

    public void SalvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    public  String recuperAnotacao(){

        return preferences.getString(CHAVE_NOME,"");


    }
}
