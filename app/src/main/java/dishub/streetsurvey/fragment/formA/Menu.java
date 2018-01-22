package dishub.streetsurvey.fragment.formA;

import android.content.Context;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

import dishub.streetsurvey.R;
import dishub.streetsurvey.classumum.config;
import dishub.streetsurvey.classumum.database;

/**
 * Created by 4741G on 22/10/2017.
 */

public class Menu extends Fragment {
    WebView myWebView;
    Fragment _fragment = null;
    String _Url_code = "";

    Uri ring_uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

    public Menu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_layout, container, false);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        _Url_code = getArguments().getString("url_code");

        myWebView = (WebView) getView().findViewById(R.id.webview);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.addJavascriptInterface(new WebAppInterface(getActivity()), "JSIAndroid");
        myWebView.loadUrl("file:///android_asset/html/menu.html");
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context c) {
            mContext = c;
        }

        @JavascriptInterface
        public String showFormMenu() {
            String aurl = config._BaseIP+"api/v1/menu/" + _Url_code;
            config._Database.getDataMenu(aurl);

            return config._Database._JsonArr.toString();
        }

        @JavascriptInterface
        public void menu(String iparam){
            String aurl = config._BaseIP+"/api/v1/form/" + iparam;
            config._Database.getDataForm(aurl);
            Fragment fragment = new InspeksiFormA1();
            if (fragment != null) {
                android.support.v4.app.FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.act_main_content_frame, fragment);
                fragmentTransaction.commit();
            }
        }

        @JavascriptInterface
        public void vibrate() {
            Vibrator v = (Vibrator) getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            v.vibrate(100);
        }

        @JavascriptInterface
        public void ringtone() {
            Ringtone r = RingtoneManager.getRingtone(getActivity(), ring_uri);
            r.play();
        }
    }
}
