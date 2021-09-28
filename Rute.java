import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// Hver rute blir et JPanel, hvor jeg legger knappene oppå ruten. Slipper da å opprette JPanel i Oblig7 siden hver rute er et JPanel..
abstract class Rute extends JPanel {

  protected Labyrint labyrint;
  protected Rute nord;
  protected Rute sor;
  protected Rute vest;
  protected Rute ost;
  protected int kolonne;
  protected int rad;
  boolean gatt = false;

  public Rute(int rad, int kolonne, Labyrint labyrint) {
    this.rad = rad;
    this.kolonne = kolonne;
    this.labyrint = labyrint;
  }

  public abstract char tilTegn();

  public void settNaboer(Rute nord, Rute sor, Rute vest, Rute ost) {
    this.nord = nord;
    this.sor = sor;
    this.vest = vest;
    this.ost = ost;
  }

  public abstract void gaa(Rute rute, ArrayList<Rute> t);

  public void finnUtvei() {
    ArrayList<Rute> sti = new ArrayList<Rute>();
    sti.add(this);
    gaa(this, sti);
  }

  @Override
  public String toString() {
    return String.format("(%d, %d)" , rad, kolonne);
  }

  void initGUI() {
    setPreferredSize(new Dimension(50,50));
    setOpaque(true);
  }

  public int hentRad() {
    return rad;
  }

  public int hentKolonne() {
    return kolonne;
  }

  public Labyrint hentLabyrintFraRute() {
    return labyrint;
  }

  public abstract void gaaAapning();

  public static void visAlleUtveier(ArrayList<ArrayList<Rute>> visAlle) {
    for (ArrayList<Rute> vei : visAlle) {
      for (Rute punkt : vei) {
        punkt.gaaAapning();
      }
    }
  }

}
