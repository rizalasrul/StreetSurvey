package dishub.streetsurvey.classumum;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Objects;

/**
 * Created by 4741G on 14/10/2017.
 */

public class database {
    public String _Url;
    public JSONObject _JsonObj;
    public JSONArray _JsonArr;

    webservice _WebService;
    webserviceJsonArray _WebServiceJsonArray;
    webservicePOST _WebServicePOST;

    public String _Errmsg;
    public String _Dispmsg;

    public void getDataForm(String iurl) {
        _Url = iurl;
        try {
            _WebService = new webservice();
            _JsonObj = _WebService.execute(_Url).get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void getDataMenu(String iurl) {
        _Url = iurl;
        try {
            _WebServiceJsonArray = new webserviceJsonArray();
            _JsonArr = _WebServiceJsonArray.execute(_Url).get();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public JSONObject saveData(String iurl, String ijson) {
        String ahasil = "";
        JSONObject ajsonobj = null;
        _Url = iurl;
        try {
            _WebServicePOST = new webservicePOST();
            ahasil = _WebServicePOST.execute(_Url, ijson).get();
            ajsonobj = new JSONObject(ahasil);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ajsonobj;
    }
}
