package dishub.streetsurvey.classumum;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 4741G on 14/10/2017.
 */

public class webserviceJsonArray extends AsyncTask<String, Void, JSONArray>{
    public JSONArray _JsonArr;

    public JSONArray get_JsonArray(){
        return  _JsonArr;
    }

    @Override
    protected JSONArray doInBackground(String... iparams) {
        try {
            String aurl = iparams[0];
            _JsonArr = connection(aurl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _JsonArr;
    }

    public JSONArray connection(String iurl){
        StringBuffer asb = new StringBuffer("");
        try {
            URL aurl = new URL(iurl);
            HttpURLConnection connection = (HttpURLConnection) aurl.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream ainputStream  = connection.getInputStream();

            BufferedReader ard = new BufferedReader(new InputStreamReader(ainputStream));
            String aline = "";
            while ((aline = ard.readLine()) != null) {
                asb.append(aline);
            }
            _JsonArr = new JSONArray(asb.toString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return _JsonArr;
    }
}
