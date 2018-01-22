package dishub.streetsurvey.fragment.formA;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;


import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import dishub.streetsurvey.R;
import dishub.streetsurvey.classumum.PhotoPath;
import dishub.streetsurvey.classumum.database;
import dishub.streetsurvey.classutama.InspeksiA1Class;
import dishub.streetsurvey.fragment.CameraTaken;
import dishub.streetsurvey.classumum.config;

import static android.R.attr.accessibilityEventTypes;
import static android.R.attr.bitmap;
import static android.R.attr.cacheColorHint;

/**
 * Created by 4741G on 08/10/2017.
 */

public class InspeksiFormA1 extends CameraTaken {

    //umum
    WebView myWebView;
    public static InspeksiA1Class _InspeksiA1;

    //GPS
    LocationManager locationManager;
    double _Latitude;
    double _Longitude;
    boolean _aflag = false;

    //notifikasi
    Uri ring_uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    //camera
    private String[] _Bitmap = new String[3];
    private int _Idcam;

    public InspeksiFormA1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_layout, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        myWebView = (WebView) getView().findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(getActivity()), "JSIAndroid");
        myWebView.loadUrl("file:///android_asset/html/form.html");

        _InspeksiA1 = new InspeksiA1Class();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
                addPhotoToGallery();
                _Bitmap[_Idcam] = "file://" + _PhotoPath.get_path();
                String afilename = _PhotoPath.get_filename();
                myWebView.loadUrl("javascript:_Form.JSIAddPhoto('" + _Bitmap[_Idcam] + "','" + afilename + "');");
                //String apath = "file:///storage/emulated/0/dishub/Testing_20171027_204543_-573191647.jpg";
//            myWebView.loadUrl("javascript:_Form.JSIAddPhoto('" + _Bitmap[_Idcam] + "')");
            } else {
                Toast.makeText(getActivity(), "Image Capture Failed", Toast.LENGTH_SHORT).show();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
        else {
            if (requestCode == REQUEST_TAKE_PHOTO && resultCode == Activity.RESULT_OK) {
                addPhotoToGallery();
                _Bitmap[_Idcam] = "file://" + _PhotoPath.get_path();
                String afilename = _PhotoPath.get_filename();
                myWebView.loadUrl("javascript:_Form.JSIAddPhoto('" + _Bitmap[_Idcam] + "','" + afilename + "');");
                //String apath = "file:///storage/emulated/0/dishub/Testing_20171027_204543_-573191647.jpg";
//            myWebView.loadUrl("javascript:_Form.JSIAddPhoto('" + _Bitmap[_Idcam] + "')");
            } else {
                Toast.makeText(getActivity(), "Image Capture Failed", Toast.LENGTH_SHORT).show();
            }
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public JSONObject testFuncion() {
        StringBuffer asb = new StringBuffer("");
        JSONObject ajsonobj = null;
        try {
            String aurl = "http://localhost/dishub/config.php?id=1";
            URL url = new URL(aurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("User-Agent", "");
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.connect();

            InputStream inputStream = connection.getInputStream();

            BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while ((line = rd.readLine()) != null) {
                asb.append(line);
            }
            ajsonobj = new JSONObject(asb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ajsonobj;
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        //untuk menampilkan data tiap menuA1 dan yang lainnya
        @JavascriptInterface
        public String showForm() {
            return config._Database._JsonObj.toString();
        }

        @JavascriptInterface
        public void setGPS() {
            find_Location();
        }

        @JavascriptInterface
        public double getLat() {
            return _Latitude;
        }

        @JavascriptInterface
        public double getLong() {
            return _Longitude;
        }


        @JavascriptInterface
        public void getCamera() {
            _Idcam = 1;
            dispatchTakePictureIntent();
        }

        @JavascriptInterface
        public void saveData(String ijson) {
            _InspeksiA1.saveData(ijson);
            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    myWebView.loadUrl("javascript: getNotification('" + _InspeksiA1._Code + "','" + _InspeksiA1._Msg + "')");
                }
            });
        }

        @JavascriptInterface
        public void vibrate() {
            Ringtone r = RingtoneManager.getRingtone(getActivity(), ring_uri);
            r.play();

            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }

        @JavascriptInterface
        public void ringtone() {
            Ringtone r = RingtoneManager.getRingtone(getActivity(), ring_uri);
            r.play();
        }
    }

    public void find_Location() {

        Log.d("Find Location", "in find_location");

        String location_context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager) getActivity().getApplicationContext().getSystemService(location_context);

        List<String> providers = locationManager.getProviders(true);
        for (String provider : providers) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                        && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
                    return;
                }
            }
            locationManager.requestLocationUpdates(provider, 0, 0, new LocationListener() {
                public void onLocationChanged(final Location location) {
                    if (!_aflag) {
                        _Latitude = location.getLatitude();
                        _Longitude = location.getLongitude();
                        _aflag = true;
                    }
                }

                public void onProviderDisabled(String provider) {
                    Toast.makeText(getActivity().getApplicationContext(), "Gps Disabled",
                            Toast.LENGTH_SHORT).show();
                }

                public void onProviderEnabled(String provider) {
                    Toast.makeText(getActivity().getApplicationContext(), "Gps Enabled",
                            Toast.LENGTH_SHORT).show();
                }

                public void onStatusChanged(String provider, int status, Bundle extras) {
                }
            });
        }
    }
}
