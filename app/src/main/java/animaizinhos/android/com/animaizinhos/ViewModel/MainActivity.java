package animaizinhos.android.com.animaizinhos.ViewModel;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import animaizinhos.android.com.animaizinhos.R;

public class MainActivity extends Activity {


    private Button botao;
    private EditText nomeUsuario;

    SalvaAquivo salvaAquivo = new SalvaAquivo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        botao = (Button) findViewById(R.id.botaoId);
        nomeUsuario = (EditText) findViewById(R.id.caixaNomeId);


        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(salvaAquivo.toString(),0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(nomeUsuario.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Por favor,preencha o nome", Toast.LENGTH_SHORT).show();
                } else {
                    editor.putString("nome", nomeUsuario.getText().toString());
                    editor.commit();
                    editor.apply();
                }


                // Criando uma intent para receber os valores da caixa nome e envialos pra outra tela.
                Intent i = new Intent(MainActivity.this, Home.class);
                i.putExtra("nome",nomeUsuario.getText().toString()); // putExtra com a chave recebe os dados do campo EditText.
                startActivity(i);
            }
        });


    }



}
