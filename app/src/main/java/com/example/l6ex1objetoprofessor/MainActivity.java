package com.example.l6ex1objetoprofessor;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.l6ex1objetoprofessor.model.Professor;
import com.example.l6ex1objetoprofessor.model.ProfessorHorista;
import com.example.l6ex1objetoprofessor.model.ProfessorTitular;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {//Foram mantidos os campos nome, matricula
    // e idade devido ao diagrama apresentado, apesar de não serem relevantes à atividade

    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private TextView tvInt;
    private TextView tvDouble;
    private TextView tvResultado;
    private EditText etNome;
    private EditText etMatricula;
    private EditText etIdade;
    private EditText etInt;
    private EditText etDouble;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbHorista);
        tvInt = findViewById(R.id.tvInt);
        tvDouble = findViewById(R.id.tvDouble);
        tvResultado = findViewById(R.id.tvResultado);
        etNome = findViewById(R.id.etNome);
        etMatricula = findViewById(R.id.etMatricula);
        etIdade = findViewById(R.id.etIdade);
        etInt = findViewById(R.id.etInt);
        etDouble = findViewById(R.id.etDouble);
        Button btnCalcular = findViewById(R.id.btnCalcular);
        atualizaActivity();

        for (RadioButton radioButton : Arrays.asList(rbTitular, rbHorista)) {
            radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    MainActivity.this.atualizaActivity();
                }
            });
        }
        btnCalcular.setOnClickListener(op -> calc());

    }

    private void calc() {
        Professor prof;
        String nome = etNome.getText().toString();
        String matricula = etMatricula.getText().toString();
        int idade = Integer.parseInt(etIdade.getText().toString());
        int valor1 = Integer.parseInt(etInt.getText().toString());
        double valor2 = Double.parseDouble(etDouble.getText().toString());
        if (rbTitular.isChecked()){
            prof = new ProfessorTitular();
        }
        else {
            prof = new ProfessorHorista();
        }
        prof.setNome(nome);
        prof.setMatricula(matricula);
        prof.setIdade(idade);
        double sal = prof.calcSalario(valor1, valor2);
        BigDecimal salario = BigDecimal.valueOf(sal).setScale(2, RoundingMode.HALF_UP);
        String res = getString(R.string.resultado)+salario;
        tvResultado.setText(res);
    }

    private void atualizaActivity() {
        if (rbTitular.isChecked()){
            tvInt.setText(getString(R.string.anos));
            tvDouble.setText(getString(R.string.salario));
        }
        if (rbHorista.isChecked()){
            tvInt.setText(getString(R.string.horas));
            tvDouble.setText(getString(R.string.valor));
        }
    }
}