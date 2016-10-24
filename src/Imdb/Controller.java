package Imdb;

public class Controller {
	private View view;
	private Subject model;
	String url;
	
	public Controller(Subject mo){          //
		this.model = mo;
		view = new View(url, model, this);
		view.createView();
		
	}
	public void exibe(){                  //
		model.registerObserver(view);
		
	}
}
