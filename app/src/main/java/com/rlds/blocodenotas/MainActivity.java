package com.rlds.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private AnotacaoPreferencias preferencias;
    private EditText editAnotacoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fbSalvar = findViewById(R.id.fb_salvar);
        editAnotacoes = findViewById(R.id.editAnotacao);
        preferencias = new AnotacaoPreferencias(getApplicationContext());


        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtREcuperado = editAnotacoes.getText().toString();

                if(txtREcuperado.equals("")){
                    Toast.makeText(
                            getApplicationContext(),
                            "Preencha a anotação",
                            Toast.LENGTH_SHORT
                    ).show();

                }else {
                    // salvar anotacoes
                    preferencias.SalvarAnotacao(txtREcuperado);
                    Toast.makeText(
                            getApplicationContext(),
                            "Anotação salva com sucesso!",
                            Toast.LENGTH_SHORT
                    ).show();

                }


            }
        });

        // recuperar anotação
        String anotacao = preferencias.recuperAnotacao();

        if(!anotacao.equals("")){
            editAnotacoes.setText(anotacao);
        }
    }
}