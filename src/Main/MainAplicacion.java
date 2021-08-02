/**
* @author javiluli (github)
*/

package Main;

import javax.swing.JFrame;

import Sorts.Bubble;

/**
 * The Class MainAplicacion.
 */
public class MainAplicacion {

  /** The frame. */
  private JFrame frame;

  /** The sort array. */
  private SortArray sortArray = new SortArray();

  /** The bubble. */
  public Bubble bubble;

  /**
   * The main method.
   *
   * @param args the arguments
   */
  // Metodo main.
  public static void main(String[] args) {
    try {
      MainAplicacion visualizador = new MainAplicacion();
      visualizador.frame.setVisible(true);
    } catch (Exception e) {
    }
  }

  /**
   * Instancia un nuevo MainAplicacion().
   */
  public MainAplicacion() {
    initialize();

    sortArray = new SortArray();
    frame.add(sortArray);
    sortArray.repaint();

    frame.pack();
    frame.setVisible(true);

    Delay.delay(2000);
    sortArray.shuffleArray(frame);
    Delay.delay(2000);
    bubble = new Bubble(frame, sortArray);

  }

  /**
   * Elementos iniciados en el JFrame.
   */
  private void initialize() {
    frame = new JFrame("Visualizador del metodo Bubble Sort");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
  }
}
