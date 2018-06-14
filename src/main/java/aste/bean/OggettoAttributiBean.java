package aste.bean;

import java.util.Map;

import aste.model.Oggetto;

public class OggettoAttributiBean {
	
	Oggetto oggetto;
	Map<Integer,String> attributiValore;
	
	public Oggetto getOggetto() {
		return oggetto;
	}
	public void setOggetto(Oggetto oggetto) {
		this.oggetto = oggetto;
	}
	public Map<Integer, String> getAttributiValore() {
		return attributiValore;
	}
	public void setAttributiValore(Map<Integer, String> attributiValore) {
		this.attributiValore = attributiValore;
	}
	
}
