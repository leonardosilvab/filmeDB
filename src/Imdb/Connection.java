package Imdb;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.io.InputStreamReader;
import java.util.LinkedList;
import org.json.JSONObject;

public class Connection {
	
	public JSONObject getData(String s) throws JSONException {



		final StringBuilder result = new StringBuilder();

		URL url;
		HttpURLConnection urlConnection = null;
		try {
			url = new URL(s);

			urlConnection = (HttpURLConnection) url
					.openConnection();

			InputStream in = urlConnection.getInputStream();

			InputStreamReader isw = new InputStreamReader(in);



			int data = isw.read();
			while (data != -1) {
				char current = (char) data;
				data = isw.read();
				result.append(current);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				urlConnection.disconnect();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println(result);




		JSONObject jsonObj = new JSONObject(result.toString());
		return jsonObj;


	}

}
