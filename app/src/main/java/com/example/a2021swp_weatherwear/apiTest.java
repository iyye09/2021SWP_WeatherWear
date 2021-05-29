//package com.example.a2021swp_weatherwear;
//
//import android.widget.TextView;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class apiTest extends Thread{
//
//
//    TextView weatherTemp;
//
//    public JSONObject s;
//    BufferedReader bufferedReader;
//
//    long now = System.currentTimeMillis();
//    Date mDate = new Date(now);
//    SimpleDateFormat simpleDate = new SimpleDateFormat("hh00");
//    String getTime = simpleDate.format(mDate);
//
//    //public void func(String year, String month, String day) throws IOException, JSONException
//    public void func(String year, String month, String day) throws IOException, JSONException
//    {
//        System.out.println(getTime);
//        // 기상청 동네예보 api에서 동네예보조회 요청에 필요한 매개변수들
//        String endPoint = "http://apis.data.go.kr/1360000/VilageFcstInfoService/";
//        String serviceKey = "sCyFo%2FDKOLW9l1EHk%2BlA0zwanD%2FpAjUbgIhgU5erOQKEcKoh6PUjl%2B%2FQ1WARH4AksQh3sl6FU%2Ff9buPEMK20Rw%3D%3D";
//        String pageNo = "1";
//        String numOfRows = "10";
//        String baseDate = year + month + day; // 원하는 날짜
//        String baseTime1 = getTime;
//        String nx = "81"; // 위경도임.
//        String ny = "75"; // 위경도 정보는 api 문서 볼 것
//        // endpoint와 원하는 정보(동네예보조회:getVilageFcst), 서비스키와 기타 요청 매개변수들을 다 합친 쿼리 스트링이다.
//        String s = endPoint + "getUltraSrtNcst?serviceKey=" + serviceKey
//                + "&pageNo=" + pageNo
//                + "&numOfRows=" + numOfRows
//                + "+&dataType=JSON"
//                + "&base_date=" + baseDate
//                + "&base_time=" + baseTime1
//                + "&nx=" + nx
//                + "&ny=" + ny;
//
//        // Http연결을한다. 호출 Method는 "GET"이다.
//        URL url1 = new URL(s);
//
//        HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
//        conn.setRequestMethod("GET");
//
//
//        // BufferedReader를 이용해서 리턴값을 받고 StringBuilder를 이용해서 라인마다 한줄씩 추가하여 저장한다.
//
//        if(conn.getResponseCode() == 200) {
//            bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//        } else {
//
//        }
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        bufferedReader.close();
//        String result = stringBuilder.toString();
//        conn.disconnect();
//        JSONObject mainObject = new JSONObject(result);
//        System.out.println(mainObject);
//        JSONArray itemArray = mainObject.getJSONObject("response").getJSONObject("body").getJSONObject("items").getJSONArray("item");
//
//        for (int i = 0; i < itemArray.length(); i++) {
//            JSONObject item = itemArray.getJSONObject(i);
//            String category = item.getString("category");
//            String value = item.getString("obsrValue");
//            System.out.println(category + "  " + value);
//        }
//    }
//}