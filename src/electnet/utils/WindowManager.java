/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package electnet.utils;

/**
 *
 * @author jonat
 */
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class WindowManager {

    // Método para mostrar una ventana
    public static void showWindow(final JFrame frame) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocationRelativeTo(null); // Esto centrará la ventana
            }
        });
    }

    // Método para ocultar una ventana
    public static void hideWindow(final JFrame frame) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.dispose(); // Cerrará y liberará los recursos del JFrame
                // Si solo quieres ocultar la ventana, puedes usar frame.setVisible(false); en lugar de frame.dispose();
            }
        });
    }

    // Puedes agregar más métodos según lo necesites, por ejemplo, para cerrar ventanas, etc.
}
