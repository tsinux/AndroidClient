package pub.iyu.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tvData = null;
    private Button btnTxt = null;
    private Button btnGet = null;
    private Button btnPost = null;
    private Button btnHttpClient = null;
    private Button btnUploadFile = null;
    private Button btnReadTxtFile = null;
    private Button btnDownloadFile = null;

    //将下面的IP改成服务器端IP
    String serverIP = "http://192.168.0.188";

    private String txtUrl = serverIP + "/AppServer/SynTxtDataServlet";
    private String url = serverIP + "/AppServer/SynDataServlet";
    private String uploadUrl = serverIP + "/AppServer/UploadFileServlet";
    private String fileUrl = serverIP + "/AppServer/file.jpg";
    private String txtFileUrl = serverIP + "/AppServer/txtFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = (TextView) findViewById(R.id.tvData);
        btnTxt = (Button) findViewById(R.id.btnTxt);


    }
}
