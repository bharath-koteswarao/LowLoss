package com.myartsonline.bharath.lowloss.RewardsRecyclerView;

import android.app.DownloadManager;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.myartsonline.bharath.lowloss.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bk on 14-04-2017.
 */

public class Data {
    ArrayList<ListItem> list=new ArrayList<>();
    ArrayList<String> name=new ArrayList<>();
    ArrayList<String> score=new ArrayList<>();
    public Data(final Context context)
    {
        Toast.makeText(context, "Working", Toast.LENGTH_SHORT).show();
        final RequestQueue queue= Volley.newRequestQueue(context);
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.POST, "http://bharath.myartsonline.com/c2c/rewards.php",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        for (int i=0;i<8;i++)
                        {
                            try {
                                JSONArray arr=response.getJSONArray((i+1)+"");
                                for (int j=0;j<arr.length();j++)
                                {
                                    if(j==1)
                                    {
                                        Log.d("See this",i+" "+j);
                                        name.add(arr.getString(0));
                                    }
                                    else
                                    {
                                        Log.d("See this",i+" "+j);
                                        score.add(arr.getString(1));
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("See this",error.toString());
                queue.stop();
            }
        });
        queue.add(request);
    }
    public List<ListItem> getList()
    {
//        for (int i=0;i<name.size();i++)
//        {
//            list.add(new ListItem("a","b","c"));
//        }
        list.add(new ListItem("a","b","c"));
        Log.d("Size is ",name.size()+"");
        return list;
    }
}
