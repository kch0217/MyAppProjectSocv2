package hk.ust.cse.comp4521.eventmaker.User;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import hk.ust.cse.comp4521.eventmaker.Constants;
import hk.ust.cse.comp4521.eventmaker.R;
import hk.ust.cse.comp4521.eventmaker.SearchMain;

public class UserRegistration extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        Spinner spinner = (Spinner) findViewById(R.id.RegInterestGroup);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.interest_array, R.layout.spinner_layout);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        EditText phone_no = (EditText) findViewById(R.id.PhoneNo);
        phone_no.setText(UserModel.getUserModel().getPhoneNumber());

        Button confirmButton = (Button) findViewById(R.id.RegConfirmButton);
        Button resetButton = (Button) findViewById(R.id.RegResetButton);
        confirmButton.setOnClickListener(new pressButton());
        resetButton.setOnClickListener(new pressButton());

        Log.i(null, "onCreate of UserRegistration");

        if (getIntent().getIntExtra("Context", -1) == Constants.MODIFY_REG){

            loadInfo();


        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_registration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void loadInfo(){
        Map<String, Object> data = UserModel.getUserModel().getAllInfo();
        ((EditText) findViewById(R.id.NameText)).setText((String)data.get("Name"));
        ((EditText) findViewById(R.id.AgeText)).setText(Integer.toString((Integer) data.get("Age")));
        RadioButton maleButton = (RadioButton) findViewById((R.id.MaleButton));
        RadioButton femaleButton = (RadioButton) findViewById((R.id.FemaleButton));
        if (((String)data.get("Gender")).equals("M")){
            maleButton.setChecked(true);
        }
        else {
            femaleButton.setChecked(true);
        }
        Spinner spinner = (Spinner) findViewById(R.id.RegInterestGroup);
        spinner.setSelection(((ArrayAdapter)spinner.getAdapter()).getPosition((String) data.get("Interest")));
        ((EditText) findViewById(R.id.PhoneNo)).setText((String)data.get("Phone"));
    }

    public void saveInfo(){
        Map<String,Object> data = new HashMap<>();
        data.put("Name", ((EditText) findViewById(R.id.NameText)).getText().toString());
        data.put("Age", Integer.parseInt(((EditText) findViewById(R.id.AgeText)).getText().toString()));
        RadioGroup genderGroup = (RadioGroup) findViewById(R.id.GenderradioGroup);
        if (genderGroup.getCheckedRadioButtonId() == R.id.MaleButton) //M as male
            data.put("Gender", "M");
        else
            data.put("Gender", "F");
        data.put("Interest", ((Spinner) findViewById(R.id.RegInterestGroup)).getSelectedItem().toString());
        data.put("Phone", ((EditText) findViewById(R.id.PhoneNo)).getText().toString());
        UserModel.getUserModel().saveAllInfo(data);
    }

    public class pressButton implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.RegConfirmButton){
                saveInfo();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();
                if (getIntent().getIntExtra("Context", -1) ==Constants.NEW_REGISTRATION) {

                    Intent intent = new Intent(getApplicationContext(), SearchMain.class);
                    startActivity(intent);
                    finish();
                }
                else if (getIntent().getIntExtra("Context",-1)==Constants.MODIFY_REG){
                    Intent intent = new Intent(getApplicationContext(), SearchMain.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP );
                    startActivity(intent);
                    finish();
                }
            }
        }
    }
}
