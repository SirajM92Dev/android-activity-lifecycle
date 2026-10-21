import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private void showCenteredToast(String message) {
        Toast toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        showCenteredToast("SecondActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        showCenteredToast("SecondActivity: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        showCenteredToast("SecondActivity: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        showCenteredToast("SecondActivity: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        showCenteredToast("SecondActivity: onStop()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        showCenteredToast("SecondActivity: onRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showCenteredToast("SecondActivity: onDestroy()");
    }
}
