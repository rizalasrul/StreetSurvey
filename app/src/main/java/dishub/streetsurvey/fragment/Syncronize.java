package dishub.streetsurvey.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.File;
import java.io.FileInputStream;
import java.io.InterruptedIOException;

import dishub.streetsurvey.R;

import static android.content.ContentValues.TAG;
import static java.lang.Thread.sleep;

/**
 * Created by 4741G on 11/11/2017.
 */

public class Syncronize extends Fragment {
    ProgressDialog progress;

    String _MSG = "";

    public Syncronize() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.syncronize_layout, container, false);
        Button button = (Button) view.findViewById(R.id.btnsyn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    progress = new ProgressDialog(getActivity());
                    progress.setMessage("Sinkronisasi...");
                    progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                    progress.setIndeterminate(false);
                    progress.setProgress(0);
                    progress.show();
                    final Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            _MSG = sendFotoFTP();
                        }
                    });
                    t.start();
                }
                else{
                    Toast.makeText(getActivity(), "No internet connection", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }

    public String sendFotoFTP() {
        String amsg = "";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("ftp.siapsejalan.com");

            ftpClient.setSoTimeout(10000);
            ftpClient.enterLocalPassiveMode();
            if (ftpClient.login("u611031925", "dishub2017")) {
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);

                if (ftpClient.changeWorkingDirectory("img/foto/")) {
                    final File folder = new File(Environment.getExternalStorageDirectory(), "dishub");
                    progress.setMax(folder.listFiles().length);

                    int i = 1;
                    for (final File fileEntry : folder.listFiles()) {
                        try {
                            FileInputStream fs = new FileInputStream(fileEntry);
                            if (!fileEntry.isDirectory()) {
                                String fileName = fileEntry.getName();
//                                fileEntry.delete();
                                ftpClient.storeFile(fileName, fs);
                                fs.close();
                                progress.setProgress(i);
                                i = i + 1;
                                Log.i(TAG, "sent");
                            }
                        } catch (Exception e) {
                            Log.i(TAG, "error uploading");
                        }
                    }
                }
            }
            progress.dismiss();
            amsg = "Sinkronisasi selesai";
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return amsg;
    }
}
