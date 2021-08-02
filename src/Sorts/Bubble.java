/**
* @author javiluli (github)
*/

package Sorts;

import javax.swing.JFrame;

import Main.Delay;
import Main.SortArray;

/**
 * The Class BubbleSort.
 */
public class Bubble {

  /**
   * Instantiates a new bubble sort.
   *
   * @param jframe    the jframe
   * @param sortArray the sort array
   */
  public Bubble(JFrame jframe, SortArray sortArray) {
    boolean needNextPass = true;
    for (int i = 0; i < sortArray.NUM_BARS && needNextPass; i++) {
      needNextPass = false;
      for (int j = 0; j < sortArray.NUM_BARS - 1 - i; j++) {
        if (sortArray.n[j] > sortArray.n[j + 1]) {
          int temp = sortArray.n[j];
          sortArray.n[j] = sortArray.n[j + 1];
          sortArray.n[j + 1] = temp;
          needNextPass = true;
        }
        sortArray.indicadorOrdenado = j + 1; // pinta la barra en ordenacion
        Delay.delay(50);
        jframe.repaint();
      }
    }
    sortArray.indicadorOrdenado = -1; // evita que pinte barras al final del sort
  }
}
