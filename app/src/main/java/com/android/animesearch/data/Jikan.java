package com.android.animesearch.data;

import android.net.Uri;
import android.util.Log;

import com.android.animesearch.Anime;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Jikan {

    public List<Anime> animeList = new ArrayList<>();

    private static final String TAG = "Jikan";

    public byte[] getUrlBytes(String urlSpec) throws IOException {
        URL url = new URL(urlSpec);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            InputStream in = connection.getInputStream();
            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new IOException(connection.getResponseMessage() +
                        ": with " + urlSpec);
                }
            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = in.read(buffer)) > 0) {
                out.write(buffer, 0, bytesRead);
            }
            out.close();
            return out.toByteArray();
        } finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws IOException {
        return new String(getUrlBytes(urlSpec));
    }

    public List<Anime> fetchItems(String searchText) {
        try {
            String url = Uri.parse("https://api.jikan.moe/v3/search/anime")
                    .buildUpon()
                    .appendQueryParameter("q", searchText)
                    .appendQueryParameter("format", "json")
                    .appendQueryParameter("nojsoncallback", "1")
                    .appendQueryParameter("extras", "url_s")
                    .build().toString();
            String jsonString = getUrlString(url);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONObject jsonBody = new JSONObject(jsonString);
            parseItems(animeList, jsonBody);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch anime", ioe);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        }
        return animeList;
    }

    private void parseItems(List<Anime> animeList, JSONObject jsonBody) throws JSONException {

        JSONArray resultsJsonArray = jsonBody.getJSONArray("results");

        for (int i = 0; i < resultsJsonArray.length(); i++) {

            JSONObject animeJsonObject = resultsJsonArray.getJSONObject(i);

            Anime anime = new Anime("random", "random", "random", "random","random");
            animeList.add(anime);
            anime.setTitleName(animeJsonObject.getString("title"));
            anime.setTitleSubjectId(animeJsonObject.getString("synopsis"));
            anime.setTitleScore(animeJsonObject.getString("score"));
            anime.setTitleStartDate(animeJsonObject.getString("start_date"));
            anime.setTitlePicture(animeJsonObject.getString("image_url"));

        }
    }
}
