import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Aapning extends HvitRute {

  public Aapning(int rad, int kolonne, Labyrint labyrint) {
    super(rad, kolonne, labyrint);
  }

  @Override
  public char tilTegn() {
    return '.';
  }

  @Override
  public void settNaboer(Rute nord, Rute sor, Rute vest, Rute ost) {
    super.settNaboer(nord,sor,vest,ost);
  }

  @Override
  public void gaa(Rute rute, ArrayList<Rute> sti) {
    ArrayList<Rute> nySti = new ArrayList<Rute>(sti);
    nySti.add(this);
    labyrint.leggTilUtvei(nySti);
  }

  @Override
  void initGUI() {
    super.initGUI();
    setBackground(Color.WHITE);
  }

  @Override
  public int hentRad() {
    return rad;
  }

  @Override
  public int hentKolonne() {
    return kolonne;
  }

  @Override
  public void gaaAapning() {
    setBackground(Color.GREEN);
  }
}
