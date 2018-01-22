package dishub.streetsurvey.classutama;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

import dishub.streetsurvey.classumum.config;

/**
 * Created by 4741G on 14/10/2017.
 */

public class InspeksiA1Class extends AppCompatActivity {
    public String _Msg = "";
    public String _Code = "";

    public String _Latitude = "";
    public String _Longitude = "";
    LocationManager _locationManager;

    public void saveData(String ijson) {
        JSONObject ajsonobj;
        String aurl = config._BaseIP + "api/v1/form";
        ajsonobj = config._Database.saveData(aurl, ijson.toString());
        try {
            _Code = ajsonobj.getString("code");
            _Msg = ajsonobj.getString("msg");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void find_Location(final Context iContext) {
        _Latitude = "";
        _Longitude = "";
        try {
            Log.d("Find Location", "in find_location");

            String location_context = Context.LOCATION_SERVICE;
            _locationManager = (LocationManager) iContext.getSystemService(location_context);

//            if ( !_locationManager.isProviderEnabled( LocationManager.GPS_PROVIDER )) {
//                buildAlertMessageNoGps(iContext);
//            }

            List<String> providers = _locationManager.getProviders(true);
            for (String provider : providers) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        this.requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 100);
                        return;
                    }
                }
                _locationManager.requestLocationUpdates(provider, 0, 0, new LocationListener() {
                    public void onLocationChanged(final Location location) {
                        //panggil js di onlocation change
                        _Latitude = String.valueOf(location.getLatitude());
                        _Longitude = String.valueOf(location.getLongitude());

                    }

                    public void onProviderDisabled(String provider) {
                        Toast.makeText(iContext, "Gps Disabled",
                                Toast.LENGTH_SHORT).show();
                    }

                    public void onProviderEnabled(String provider) {
                        Toast.makeText(iContext, "Gps Enabled",
                                Toast.LENGTH_SHORT).show();
                    }

                    public void onStatusChanged(String provider, int status, Bundle extras) {
                        Toast.makeText(iContext, "testing",
                                Toast.LENGTH_SHORT).show();
                    }
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void buildAlertMessageNoGps(final Context iContext) {
        android.app.AlertDialog.Builder alertDialog = new android.app.AlertDialog.Builder(iContext);

        alertDialog.setTitle("GPS is settings");

        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                iContext.startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }
}
