package aste.service;

import java.util.List;

import aste.model.Attributo;
import aste.model.OggAtt;

public interface OggAttService {
	     
	    public void addOggAtt(OggAtt oggatt);
	    
	    public List<Attributo> findAttributiByOggetto(Integer idOggetto);
	 
	    public void deleteOggAtt(Integer oggattId);  
}
