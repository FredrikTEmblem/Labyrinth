import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class SortRute extends Rute {

  public SortRute(int rad, int kolonne, Labyrint labyrint) {
    super(rad, kolonne, labyrint);
  }

  @Override
  public char tilTegn() {
    return '#';
  }

  @Override
  public void settNaboer(Rute nord, Rute sor, Rute vest, Rute ost) {
    super.settNaboer(nord,sor,vest,ost);
  }

  @Override
  public void gaa(Rute rute, ArrayList<Rute> f){
    return;
  }

  @Override
  void initGUI() {
    super.initGUI();
    setBackground(Color.BLACK);
  }

  @Override
  public int hentRad() {
    return rad;
  }

  @Override
  public int hentKolonne() {
    return kolonne;
  }
}
