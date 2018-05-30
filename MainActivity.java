package hk.ust.cse.comp107x.timegreetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button greetButton;
    int hour, minute, second;
    String greetingTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        greetButton = (Button) findViewById(R.id.greetButton);
        greetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView textMessage = (TextView) findViewById(R.id.textMessage);
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);
        String friendName = editFriendName.getText().toString();
        Calendar currentCalendar = Calendar.getInstance();
        hour = currentCalendar.get(Calendar.HOUR_OF_DAY);
        minute = currentCalendar.get(Calendar.MINUTE);
        second = currentCalendar.get(Calendar.SECOND);
        float time = hour+((float)minute/60)+(float)second/(60*60);
        if(time>=6 && time<12+1.0/60)
        {
            //greetingTime = "Good Morning";
            textMessage.setText(getString(R.string.goodmorning) + friendName + "!");
        }
        else if(time>12 && time<17+1.0/60)
        {
            //greetingTime = "Good Afternoon";
            textMessage.setText(getString(R.string.goodafternoon) + friendName + "!");
        }
        else if(time>17 && time<21+1.0/60)
        {
            //greetingTime = "Good Evening";
            //greetingTime = getString(R.string.goodevening);
            textMessage.setText(getString(R.string.goodevening) + friendName + "!");
        }
        else if(time>21 && time<24+1.0/60 || time>=0 && time<6)
        {
            //greetingTime = "Good Night";
            textMessage.setText(getString(R.string.goodnight) + friendName + "!");
        }
        //textMessage.setText(greetingTime + " " + friendName + "! ");
        /*
        switch(v.getId()){
            case R.id.greetingButton:
                textMessage.setText("Good Day " + friendName + "!");
                break;
            default:
                break;
        }
        */
    }
}
