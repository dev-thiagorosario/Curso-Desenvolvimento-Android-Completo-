import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.app1sorteio.R;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Criação de uma instância única de Random para ser reutilizada
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Renomeado para seguir convenções de nomenclatura e removida a passagem desnecessária de View
    public void sortearNumero() {
        TextView textoResultado = findViewById(R.id.textoResultado);
        int numero = random.nextInt(11); // Gera um número de 0 a 10
        // Uso de string resource para melhorar a localização e manutenção
        String resultado = getString(R.string.numero_sorteado, numero);
        textoResultado.setText(resultado);
    }

    // Método chamado pelo layout XML (se necessário manter a assinatura com View)
    public void onSortearNumeroClick(View view) {
        sortearNumero();
    }
}
