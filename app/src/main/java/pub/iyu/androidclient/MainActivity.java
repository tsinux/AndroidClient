package pub.iyu.androidclient;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.*;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import pub.iyu.androidclient.model.Student;
import pub.iyu.androidclient.util.NetTool;

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
    String serverIP = "http://192.168.0.114";

    private String txtUrl = serverIP + "/ServerForAndroidClient/SynTxtDataServlet";
    private String url = serverIP + "/ServerForAndroidClient/SynDataServlet";
    private String uploadUrl = serverIP + "/ServerForAndroidClient/UploadFileServlet";
    private String fileUrl = serverIP + "/ServerForAndroidClient/file.jpg";
    private String txtFileUrl = serverIP + "/ServerForAndroidClient/txtFile.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvData = (TextView) findViewById(R.id.tvData);
        btnTxt = (Button) findViewById(R.id.btnTxt);
        btnGet = (Button) findViewById(R.id.btnGet);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnHttpClient = (Button) findViewById(R.id.btnHttpClient);
        btnUploadFile = (Button) findViewById(R.id.btnUploadFile);
        btnReadTxtFile = (Button) findViewById(R.id.btnReadTxtFile);
        btnDownloadFile = (Button) findViewById(R.id.btnDownloadFile);

        btnTxt.setOnClickListener(btnListener);
        btnGet.setOnClickListener(btnListener);
        btnPost.setOnClickListener(btnListener);
        btnHttpClient.setOnClickListener(btnListener);
        btnUploadFile.setOnClickListener(btnListener);
        btnReadTxtFile.setOnClickListener(btnListener);
        btnDownloadFile.setOnClickListener(btnListener);

    }

    OnClickListener btnListener = new OnClickListener(){

        String retStr = "";

        public void onClick(View v){
            switch (v.getId()){
                case R.id.btnTxt:
                    Student student = new Student();
                    student.setId(1);
                    student.setName("张三");
                    student.setClasses("软工2班");

                    Gson gson = new Gson();
                    String jsonTxt = gson.toJson(student);
                    try {
                        retStr = NetTool.sendTxt(txtUrl,jsonTxt,"UTF-8");
                    }catch (Exception e2){
                        e2.printStackTrace();
                    }
                    break;
                case R.id.btnGet:
                    Map<String,String> map = new HashMap<String,String>();
                    map.put("name","李四");
                    map.put("age","26");
                    map.put("classes","计科1班");

                    try{
                        retStr = NetTool.sendGetRequest(url,map,"utf-8");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnPost:
                    Map<String,String> map2 = new HashMap<String,String>();
                    map2.put("name","王二");
                    map2.put("age","28");
                    map2.put("classes","网工1班");

                    try{
                        retStr = NetTool.sendPostRequest(url,map2,"utf-8");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnHttpClient:
                    Map<String ,String> map3 = new HashMap<String,String>();
                    map3.put("name","朱大");
                    map3.put("age","33");
                    map3.put("classes","教计2班");

                    try{
                        retStr = NetTool.sendHttpClientPost(url,map3,"utf-8");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnUploadFile:
                    //需要在sdcard中放一张image.jpg的图片才能正确运行
                    try{
                       retStr = NetTool.sendFile(uploadUrl,
                               "/sdcard/image.jpg","image1.jpg");
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnReadTxtFile:
                    try {
                        //服务器端的文件类型为UTF-8
                        retStr = NetTool.readTxtFile(txtFileUrl,"UTF-8");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case R.id.btnDownloadFile:
                    try{
                        NetTool.downloadFile(fileUrl,"/download","newfile.jpg");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    break;
            }
            tvData.setText(retStr);
        }
    };
}
