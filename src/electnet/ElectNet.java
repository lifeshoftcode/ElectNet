
package electnet;
import electnet.ui.main.MenuPrincipal;

public class ElectNet {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true); // Mostrar la ventana principal.
            }
        });
    }
    
}
