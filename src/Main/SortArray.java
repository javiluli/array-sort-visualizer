/**
* @author javiluli (github)
*/

package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The Class SortArray.
 */
@SuppressWarnings("serial")
public class SortArray extends JPanel {

  /** El array de numeros principal. */
  public int[] n;

  /**
   * Numero de barras calculado con potencia en base 2 para optimizar el espacio
   * sobre el ancho y alto de la venatan.
   */
  public final int NUM_BARS = (int) Math.pow(2, 5);

  /** El ancho de la ventana. */
  public final int WIN_WIDTH = 1024;

  /** El alto de la ventana. */
  public final int WIN_HEIGHT = 512;

  /**
   * El ancho de cada barra segun el numero de barras y el ancho de la ventana.
   */
  final int BAR_WIDTH = WIN_WIDTH / NUM_BARS;

  /**
   * La altura minima de una barra segun la cantidad de barras y la altura de la
   * ventana.
   */
  final int BAR_MIN_HEIGHT = WIN_HEIGHT / NUM_BARS;

  /**
   * Marca la barra la cual esta en ese momentos ordenandose, irrelevante para el
   * fucionamiento de la aplicacion.
   */
  public int indicadorOrdenado = -1;

  /**
   * Constructor que inicia el array.
   */
  public SortArray() {
    n = new int[NUM_BARS];
    for (int i = 0; i < NUM_BARS; i++) {
      n[i] = i;
    }
    setBackground(new Color(25, 25, 25));
  }

  /**
   * Desordena un Array.
   *
   * @param jframe el JFrame principal/main
   */
  public void shuffleArray(JFrame jframe) {
    Random rng = new Random();
    for (int i = 0; i < NUM_BARS; i++) {
      int swapWidthIndex = rng.nextInt(NUM_BARS - 1);
      int temp = n[i];
      n[i] = n[swapWidthIndex];
      n[swapWidthIndex] = temp;
      Delay.delay(3);
      jframe.repaint();
    }
  }

  /**
   * Pinta las barras en pantalla.
   *
   * @param Graphics
   */
  @Override
  public void paintComponent(Graphics graphic) {
    Graphics2D graphics2d = (Graphics2D) graphic;
    super.paintComponent(graphics2d);

    for (int i = 0; i < NUM_BARS; i++) {
      int height = (n[i] * BAR_MIN_HEIGHT) + BAR_MIN_HEIGHT;
      int xBegin = i + (BAR_WIDTH - 1) * i;
      int yBegin = WIN_HEIGHT - height;

      graphics2d.setPaint(getGradientPaint(i, n[i], BAR_WIDTH));

      if (indicadorOrdenado == i)
        graphics2d.setColor(Color.white);

      graphics2d.fillRect(xBegin, yBegin, BAR_WIDTH, height);
    }
  }

  /**
   * Generacion de colores con el degradado efecto arcoiris usando el formato HSL.
   * 
   * @param posicion  la posicion
   * @param valor     el valor
   * @param barGrosor el grosor de la barra
   * @return el degradado final que se pinta
   */
  protected GradientPaint getGradientPaint(int posicion, int valor, int barGrosor) {
    float startH = valor / (NUM_BARS * 1f);
    float finishH = (valor + 1) / (NUM_BARS * 1f);
    float S = 1; // Saturacion
    float L = 1; // Brillo
    Color startColor = Color.getHSBColor(startH, S, L);
    Color finishColor = Color.getHSBColor(finishH, S, L);
    int x = 2 * BAR_WIDTH + barGrosor * posicion;
    return new GradientPaint(x, 0, startColor, x + barGrosor, 0, finishColor);
  }

  /**
   * Preferencia para el tama�o de la ventana.
   *
   * @return la preferencia del tama�o
   */
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(WIN_WIDTH, WIN_HEIGHT);
  }
}
