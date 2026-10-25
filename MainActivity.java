import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etMainMessage;
    private TextView tvReturnedData;
    private Button btnSendForward;

    // Launcher for handling data returned backward from SecondActivity
    private final ActivityResultLauncher<Intent> secondActivityLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String reply = result.getData().getStringExtra("EXTRA_REPLY_DATA");
                        tvReturnedData.setText("Returned Backward: " + reply);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "MainActivity: onCreate()", Toast.LENGTH_SHORT).show();

        etMainMessage = findViewById(R.id.etMainMessage);
        tvReturnedData = findViewById(R.id.tvReturnedData);
        btnSendForward = findViewById(R.id.btnSendForward);

        btnSendForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageToSend = etMainMessage.getText().toString();

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // 1. Forward Data Passing via Intent extra
                intent.putExtra("EXTRA_FORWARD_DATA", messageToSend);

                // Launch using the result launcher to receive data back later
                secondActivityLauncher.launch(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "MainActivity: onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "MainActivity: onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "MainActivity: onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "MainActivity: onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "MainActivity: onRestart()", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "MainActivity: onDestroy()", Toast.LENGTH_SHORT).show();
    }
}
