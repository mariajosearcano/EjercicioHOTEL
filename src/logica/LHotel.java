
package logica;

import bean.Hotel;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class LHotel {
    
    ArrayList<Hotel> arrayPlaya;
    ArrayList<Hotel> arrayMontana;
    ArrayList<Hotel> arrayRural;
    int i;

    public LHotel() {
        arrayPlaya = new ArrayList<>();
        arrayMontana = new ArrayList<>();
        arrayRural = new ArrayList<>();
        
    }

    public LHotel(ArrayList<Hotel> arrayPlaya, ArrayList<Hotel> arrayMontana, ArrayList<Hotel> arrayRural) {
        this.arrayPlaya = arrayPlaya;
        this.arrayMontana = arrayMontana;
        this.arrayRural = arrayRural;
    }

    public ArrayList<Hotel> getArrayPlaya() {
        return arrayPlaya;
    }

    public void setArrayPlaya(ArrayList<Hotel> arrayPlaya) {
        this.arrayPlaya = arrayPlaya;
    }

    public ArrayList<Hotel> getArrayMontana() {
        return arrayMontana;
    }

    public void setArrayMontana(ArrayList<Hotel> arrayMontana) {
        this.arrayMontana = arrayMontana;
    }

    public ArrayList<Hotel> getArrayRural() {
        return arrayRural;
    }

    public void setArrayRural(ArrayList<Hotel> arrayRural) {
        this.arrayRural = arrayRural;
    }
    
    public int consecutivo()
	{
		int cod=1;
		try
		{
			File archivo = new File("../registros/hoteles.txt");
			if(archivo.exists())
			{
			FileReader datosLeidos=new FileReader(archivo);
			BufferedReader buffer = new BufferedReader(datosLeidos);
			String cadena="";
			while(cadena!=null)	
			{
				cadena=buffer.readLine();
				if(cadena!=null)
				{
					cod++;
				}
			}
			
			buffer.close();
			datosLeidos.close();
			}
			
		}catch (Exception e) {System.out.println(e);
		}
		return cod;
		}
    
    public void leer(){
        BufferedReader leido = null;
        i=1;
        try {
            String linea = "";
            
            leido = new BufferedReader(new FileReader("./src/registros/hoteles.txt"));

            while ((linea = leido.readLine()) != null) {
                String[] Vlinea = linea.split("::");
                i++;
                guardar(Vlinea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (leido != null)
                    leido.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    public Hotel crear(String[] Vlinea){
        return new Hotel(Integer.parseInt(Vlinea[0]), Vlinea[1], Vlinea[2], Integer.parseInt(Vlinea[3]));
    }
    
    public void guardar(String[] Vlinea){
        switch(Vlinea[2]){
            case "Playa": arrayPlaya.add(crear(Vlinea));
                break;
            case "Montaña": arrayMontana.add(crear(Vlinea));
                break;
            case "Rural": arrayRural.add(crear(Vlinea));
                break;
            default: System.out.println("WTF");
                break;
        }
    }
    
    public void ingreso(String nombre, String precio, boolean rural, boolean montaña, boolean playa,HashSet ctodo) {
    	Hotel h=null;
    	
    	if (rural)
    	{
    		h= new Hotel(i, nombre, "Rural" ,Integer.parseInt(precio));
    		arrayRural.add(h);
                ctodo.add(h);
    		
    	}
    	if (montaña)
    	{
    		h= new Hotel(i, nombre, "Montaña" ,Integer.parseInt(precio));
    		arrayMontana.add(h);
                ctodo.add(h);
    		
    	}
    	if (playa)
    	{
    		h= new Hotel(i, nombre, "Playa" ,Integer.parseInt(precio));
    		arrayPlaya.add(h);
                ctodo.add(h);
    		
    	}
    	
    	i++;
    }
    
}
