package vista;

import java.util.HashSet;

import bean.Hotel;
import logica.LHotel;

public class Inicio {

    public static void main(String[] args) {
        
    	LHotel lh= new LHotel();
    	lh.leer();
    	
    	
    	HashSet<Hotel> ctodo= new HashSet();
    	for(Hotel h: lh.getArrayMontana())
    	{
    		ctodo.add(h);
    	}
    	for(Hotel h: lh.getArrayPlaya())
    	{
    		ctodo.add(h);
    	}
    	for(Hotel h: lh.getArrayRural())
    	{
    		ctodo.add(h);
    	}
    	Menu menu = new Menu();
        
        menu.menuPrincipal(ctodo, lh);
    }
    
}
