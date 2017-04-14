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

    ArrayList<ListItem> list;
    ArrayList<String> name, score;

    public Data(final Context context) {
        list = new ArrayList<>();
        name = new ArrayList<>();
        score = new ArrayList<>();
        final RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "http://bharath.myartsonline.com/c2c/rewards.php",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        for (int i = 0; i < 8; i++) {
                            try {
                                JSONArray arr = response.getJSONArray((i + 1) + "");
                                for (int j = 0; j < arr.length(); j++) {
                                    if (j == 1) {
                                        name.add(arr.getString(0));
                                    } else {
                                        Log.d("See this", i + " " + j);
                                        score.add(arr.getString(1));
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        for (int k=0;k<name.size();k++)
                        {
                            list.add(new ListItem(name.get(k),score.get(k),(k+1)+""));
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("See this", error.toString());
                queue.stop();
            }
        });
        queue.add(request);
        Log.d("Size is this ", name.size() + "");
    }

    public List<ListItem> getList() {
        return list;
    }
}
