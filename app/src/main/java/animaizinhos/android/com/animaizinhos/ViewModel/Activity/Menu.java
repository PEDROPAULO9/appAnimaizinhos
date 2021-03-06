package animaizinhos.android.com.animaizinhos.ViewModel.Activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import animaizinhos.android.com.animaizinhos.Model.DAO.SalvaAquivo;
import animaizinhos.android.com.animaizinhos.R;

public class Menu extends Activity {

    private TextView nome;

    GridLayout mainGrid;

    //private ImageView sonsAnimais;
    //private ImageView descricaoAnimais;
    //private ImageView idadeAnimais;
    //private ImageView nomeInglesAnimais;

    SalvaAquivo salvaAquivo = new SalvaAquivo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        nome = (TextView) findViewById(R.id.nomeId);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        setSingleEvent(mainGrid);


        // Recebe os dados enviados da tela anterior e trata.
        //Bundle bundle =  getIntent().getExtras();

        //if(bundle != null){
        // String nomeUsuario = bundle.getString("nome");
        //nome.setText(nomeUsuario);
        //}

        SharedPreferences sharedPreferences = getSharedPreferences(SalvaAquivo.ARQUIVO_PREFERENCES, 0);
        String pessoaName = sharedPreferences.getString("nome", null);
        nome.setText("OLÀ " + pessoaName.toUpperCase());



    }


    private void setSingleEvent(final GridLayout mainGrid) {
        //Loop all child item of Main Grid
        for (int i = 0; i < mainGrid.getChildCount(); i++) {
            //You can see , all child item is CardView , so we just cast object to CardView
            CardView cardView = (CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(finalI == 0){
                        Intent intent = new Intent(Menu.this, SonsAnimais.class);
                        startActivity(intent);
                    }
                    else if(finalI == 1){
                        Intent intent = new Intent(Menu.this, IdadeAnimais.class);
                        startActivity(intent);
                    }
                    else if(finalI == 2){
                        Intent intent = new Intent(Menu.this, DescricaoAnimais.class);
                        startActivity(intent);
                    }
                    else if(finalI == 3){
                        Intent intent = new Intent(Menu.this, NomeInglesAnimais.class);
                        startActivity(intent);
                    }

                }
            });
        }
    }

}

//sonsAnimais.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//  startActivity(new Intent(Menu.this, SonsAnimais.class));
//}
//});

//idadeAnimais.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View v) {
//    startActivity(new Intent(Menu.this, IdadeAnimais.class));
//}
//});

//descricaoAnimais.setOnClickListener(new View.OnClickListener() {
//  @Override
//public void onClick(View v) {
//  startActivity(new Intent(Menu.this, DescricaoAnimais.class));
//}
//});

//nomeInglesAnimais.setOnClickListener(new View.OnClickListener() {
//  @Override
//public void onClick(View v) {
//    startActivity(new Intent(Menu.this, NomeInglesAnimais.class));
//}
//});





