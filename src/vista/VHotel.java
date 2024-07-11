
package vista;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.regex.Pattern;

import javax.swing.JCheckBox;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import bean.Hotel;
import logica.LHotel;

public class VHotel {
    
    public void ingreso( HashSet ctodo, LHotel lHot)
    {
    	JTextField nombres = new JTextField(), precio = new JTextField();
    	JCheckBox rural= new JCheckBox("Rural"), montaña= new JCheckBox("Montaña"), playa= new JCheckBox("Playa"); 
       
        
        Object[] mensaje = {
            "Nombres", nombres,
             "Precio", precio,
             "Tipo", rural,
              montaña,
              playa
        };
        
        boolean f=false;
        do {
        	
        	
        	int opcion= JOptionPane.showConfirmDialog(null, mensaje, "Formulario de registro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        	if(opcion != JOptionPane.OK_OPTION){
        		 JOptionPane.showMessageDialog(null, "Ingreso cancelado", "Advertencia", JOptionPane.WARNING_MESSAGE);
                 f=true;
                 break;}
        }while(validacion(precio.getText()));
        if(!f) {
        	
        	lHot.ingreso(nombres.getText(), precio.getText(), rural.isSelected(), montaña.isSelected(), playa.isSelected(),ctodo);
        	
        }
        
    
    
    }
    
    public boolean validacion(String precio)
    {
    	String regex ="^(4[0-9]|[5-9][0-9]|1[0-4][0-9]|150)$";
    	 
    	if(!Pattern.matches(regex, precio)){
             JOptionPane.showMessageDialog(null, "El precio debe de ser entre 40 y 150" , "Advertencia", JOptionPane.WARNING_MESSAGE);
             
             return true;
         }
    	
    	return false;
    	
    }
    
    public void mRural(LHotel lh)
    {
    	
    	TreeSet<Hotel> cRural= new TreeSet(lh.getArrayRural());
    	System.out.println("\nConjunto Rural");
    	for(Hotel h: cRural)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    public void mMontaña(LHotel lh)
    {
    	
    	TreeSet<Hotel> cMontaña= new TreeSet(lh.getArrayMontana());
    	   System.out.println("\nConjunto Montaña");
    	for(Hotel h: cMontaña)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    
    public void mPlaya(LHotel lh)
    {
    	
    	TreeSet<Hotel> cPlaya= new TreeSet(lh.getArrayPlaya());
    	System.out.println("\nConjunto Playa");
    	for(Hotel h: cPlaya)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    
    public void mRuralMontaña(LHotel lh)
    {
    	
    	TreeSet<Hotel> cRural= new TreeSet(lh.getArrayRural());
    	TreeSet<Hotel> cMontaña= new TreeSet(lh.getArrayMontana());
    	TreeSet<Hotel> intersection = new TreeSet<>(cRural);
        intersection.retainAll(cMontaña);
        System.out.println("\nInterseccion Rural Montaña");
    	for(Hotel h: intersection)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    
    public void mRuralPlaya(LHotel lh)
    {
    	
    	TreeSet<Hotel> cRural= new TreeSet(lh.getArrayRural());
    	TreeSet<Hotel> cPlaya= new TreeSet(lh.getArrayPlaya());
    	TreeSet<Hotel> intersection = new TreeSet<>(cRural);
        intersection.retainAll(cPlaya);
          System.out.println("\nInterseccion Rural Playa");
    	for(Hotel h: intersection)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    
    public void mMontañaPlaya(LHotel lh)
    {
    	
    	TreeSet<Hotel> cMontaña= new TreeSet(lh.getArrayRural());
    	TreeSet<Hotel> cPlaya= new TreeSet(lh.getArrayPlaya());
    	TreeSet<Hotel> intersection = new TreeSet<>(cMontaña);
        intersection.retainAll(cPlaya);
          System.out.println("\nInterseccion Montaña Playa");
    	for(Hotel h: intersection)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
    public void mtodo(LHotel lh)
    {
    	
    	TreeSet<Hotel> cMontaña= new TreeSet(lh.getArrayRural());
    	TreeSet<Hotel> cPlaya= new TreeSet(lh.getArrayPlaya());
    	TreeSet<Hotel> intersection = new TreeSet<>(cMontaña);
        intersection.retainAll(cPlaya);
        TreeSet<Hotel> cRural= new TreeSet(lh.getArrayRural());
        intersection.retainAll(cRural);
         System.out.println("\nInterseccion Rural Montaña Playa");
    	for(Hotel h: intersection)
    	{
    		System.out.println(h.toString());
    	}
    	
    }
}
