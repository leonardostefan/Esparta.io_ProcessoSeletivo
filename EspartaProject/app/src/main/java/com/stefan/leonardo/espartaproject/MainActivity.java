package com.stefan.leonardo.espartaproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.*;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtValor;
    private EditText nbrExclude;

    private Button btnAdicionar;
    private Button btnExcluir;
    private Button btnAlterar;

    private ListView lstConcluido;
    private ListView lstPendente;


    private TaskList todo;
    private ArrayList<Task> pending;
    private ArrayList<Task> done;

    private ArrayAdapter<String> adpConcluido;
    private ArrayAdapter<String> adpPendente;

    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtValor        = (EditText)findViewById(R.id.edtValor);
        btnAdicionar    = (Button)findViewById(R.id.btnAdicionar);
        btnExcluir      = (Button)findViewById(R.id.btnExcluir);
        btnAlterar      = (Button)findViewById(R.id.btnAlterar);

        nbrExclude      = (EditText)findViewById(R.id.nbrExclude);
        lstConcluido    =  (ListView)findViewById(R.id.lstConcluido);
        lstPendente     =  (ListView)findViewById(R.id.lstPendente);


        btnExcluir.setOnClickListener(this);
        btnAdicionar.setOnClickListener(this);
        btnAlterar.setOnClickListener(this);
        AlertDialog.Builder builder= new AlertDialog.Builder(this);

        todo= new TaskList();


        adpConcluido = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adpPendente = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);

        lstConcluido.setAdapter(adpConcluido);
        lstPendente.setAdapter(adpPendente);



    }
    @Override
    public void onClick(View v) {


        if(v==btnAdicionar){
            String task =edtValor.getText().toString();
            Task t=new Task(task);
            todo.list.add(t);
            //     todo.adapterSet(adpConcluido,false);

        }else{
            if(v== btnExcluir){
                todo.removeId(Integer.parseInt(nbrExclude.getText().toString()));
                //todo.adapterSet(adpConcluido,true);
            }else {
                if(v==btnAlterar){
                    todo.changeStatus(Integer.parseInt(nbrExclude.getText().toString()));
                }
            }
        }
        String aux;
        adpPendente.clear();
        adpConcluido.clear();
        for (Task task : todo.list) {
            aux = task.id + " - " + task.taskName;
            if(task.isDone) {
                adpConcluido.add(aux);
            }
              else adpPendente.add(aux);
        }
    }

//
//    public void excluirTarefa(int id){
//        AlertDialog.Builder alerta =new AlertDialog.Builder(this);
//        alerta.setTitle("Confirmação");
//        alerta.setMessage("Deseja mesmo excluir o item " + id);
//        alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                MainActivity.todo.removeId(id);
//            }
//        });
//        alerta.setNegativeButton("Não", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//    }


}



