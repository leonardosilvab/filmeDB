package Imdb;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

public class Model implements Subject{
	
	
	private JSONObject bd;
	private Connection con = new Connection();
	private ArrayList observers;
	Filme filme = new Filme();
	
	public Model() {
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {                //
		observers.add(o);
		notifyObservers();
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers() {                      //
		                                                 
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer)observers.get(i);
			observer.update(filme.getTitulo(), filme.getDiretor(), filme.getAno(),filme.getSinopse());
		}
	}	
	
	
	public void setarInfos(String url) throws JSONException{
		bd = con.getData(url);
		
		filme.setTitulo(bd.getString("Title"));
		filme.setDiretor(bd.getString("Director"));         //
		filme.setAno(bd.getString("Released"));
		filme.setSinopse(bd.getString("Plot"));
		
		
	}
	
	
	

}
