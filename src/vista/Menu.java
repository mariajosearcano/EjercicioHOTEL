
package vista;

import java.util.HashSet;

import javax.swing.JOptionPane;

import bean.Hotel;
import logica.LHotel;

public class Menu {
    
    public void menuPrincipal( HashSet<Hotel> ctodo, LHotel lh){
        int opcion = 0;
        VHotel vh= new VHotel();
        do{
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                                        
                                                                        1. Ingreso
                                                                        2. conjunto de todos
                                                                        3. Rural
                                                                        4. Montaña
                                                                        5. Playa
                                                                        6. Rural-Montaña
                                                                        7. Rural-Playa
                                                                        8. Montaña- Playa
                                                                        9. Las 3 zonas
                                                                        0. salir
                                                                        
                                                                        """, "Menu Principal", JOptionPane.QUESTION_MESSAGE));
            
            switch(opcion){
                case 1: 
                	vh.ingreso(ctodo, lh);
                    break;
                case 2: 
                	for(Hotel H: ctodo)
                	{
                		System.out.println(H.toString());
                	}
                    
                    break;
                case 3: vh.mRural(lh);
                   
                    break;
                case 4: vh.mMontaña(lh);
                    
                    break;
                case 5: vh.mPlaya(lh);
                    
                    break;
                case 6: vh.mRuralMontaña(lh);
    
                	break;
                case 7: vh.mRuralPlaya(lh);
                    
                	break;
                case 8: vh.mMontañaPlaya(lh);
                    
                	break;
                case 9: vh.mtodo(lh);
                
            	break;
                case 0: 
                    JOptionPane.showMessageDialog(null, "Saldra del programa, hasta la proxima", "Advertencia", JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showInputDialog(null, "Por favor ingresa una opcion del menu: ", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }while(opcion != 0);
    }
    
}
