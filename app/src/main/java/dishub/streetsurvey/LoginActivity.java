package dishub.streetsurvey;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import dishub.streetsurvey.classumum.config;
import dishub.streetsurvey.classumum.database;
import dishub.streetsurvey.classumum.user;

/**
 * Created by 4741G on 06/12/2017.
 */

public class LoginActivity extends AppCompatActivity {
    String _Id = "null";
    String _Msg = "";
    TextView _Username;
    TextView _Password;
    Button _Button;

    //    ProgressDialog _progressDialog;
    ProgressBar _progressBar;

    public void onCreate(Bundle savedInstanceState) {
        config._Database = new database();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

//        _progressDialog = new ProgressDialog(LoginActivity.this,R.style.AppTheme_Dark_Dialog);
        _progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        _Button = (Button) findViewById(R.id.btn_login);
        _Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    _progressBar.setVisibility(View.VISIBLE);
                    Click();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if (!_Id.equals("null")) {
                    config._User = new user();
                    config._User.set_username(_Username.getText().toString());
                    config._User.set_password(_Password.getText().toString());
                    config._User.set_id(_Id);

                    _progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(getApplicationContext(), MenuDrawer.class);
                    startActivity(intent);
                } else {
                    _progressBar.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void Click() throws JSONException {
        if (!validate()) {
            onLoginFailed();
            return;
        }

//        _progressDialog.setIndeterminate(true);
//        _progressDialog.setMessage("Authenticating...");
//        _progressDialog.show();

        JSONObject ajsonobj;
        JSONObject bjsonobj;

        ajsonobj = new JSONObject();
        ajsonobj.put("username", _Username.getText().toString());
        ajsonobj.put("password", _Password.getText().toString());

        String aurl = config._BaseIP + "api/v1/cek-login";
        bjsonobj = config._Database.saveData(aurl, ajsonobj.toString());
        try {
            if (bjsonobj != null) {
                _Id = bjsonobj.getString("id");
                _Msg = bjsonobj.getString("msg");
            } else {
                Toast.makeText(getBaseContext(), "No Internet Connection", Toast.LENGTH_LONG).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _Button.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        _Username = (TextView) findViewById(R.id.input_username);
        _Password = (TextView) findViewById(R.id.input_password);

        if (_Username.getText().toString().isEmpty()) {
            _Username.setError("enter a valid username");
            valid = false;
        } else {
            _Username.setError(null);
        }

        if (_Password.getText().toString().isEmpty()) {
            _Username.setError("enter valid password");
            valid = false;
        } else {
            _Username.setError(null);
        }
        return valid;
    }
}
