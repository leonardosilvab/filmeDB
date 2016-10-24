package Imdb;

import org.json.JSONException;

public class test {

	public static void main(String[] args) throws JSONException {
		// TODO Auto-generated method stub
		final Model model = new Model();
		Controller controller = new Controller(model);
		model.setarInfos("http://www.omdbapi.com/?t=evil+dead+II&plot=short&r=json");
	}

}

