import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvReceivedData;
    private EditText etSecondReply;
    private Button btnSendBackward;

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

        tvReceivedData = findViewById(R.id.tvReceivedData);
        etSecondReply = findViewById(R.id.etSecondReply);
        btnSendBackward = findViewById(R.id.btnSendBackward);

        // 1. Receiving forward data passed from MainActivity
        Intent receivedIntent = getIntent();
        if (receivedIntent != null && receivedIntent.hasExtra("EXTRA_FORWARD_DATA")) {
            String receivedMessage = receivedIntent.getStringExtra("EXTRA_FORWARD_DATA");
            tvReceivedData.setText("Received Forward: " + receivedMessage);
        }

        // 2. Sending data backward to MainActivity
        btnSendBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String replyMessage = etSecondReply.getText().toString();

                Intent returnIntent = new Intent();
                returnIntent.putExtra("EXTRA_REPLY_DATA", replyMessage);
                setResult(RESULT_OK, returnIntent);

                // Finishes SecondActivity and navigates back to MainActivity
                finish();
            }
        });
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
