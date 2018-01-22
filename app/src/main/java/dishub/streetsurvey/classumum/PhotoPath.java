package dishub.streetsurvey.classumum;

import android.net.Uri;

/**
 * Created by it-aris on 06/02/2017.
 */

public class PhotoPath {
    String _path;
    String _filename;
    Uri _uri;


    public void set_filename(String ifilename){
        this._filename = ifilename;
    }

    public String get_filename() {
        return _filename;
    }

    public void set_path(String ipath) {
        this._path = ipath;
    }

    public String get_path() {
        return _path;
    }

    public void set_uri(Uri _uri) {
        this._uri = _uri;
    }

    public Uri get_uri() {
        return _uri;
    }
}
