import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HvitRute extends Rute {

  public HvitRute(int rad, int kolonne, Labyrint labyrint) {
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
    if (gatt) {
      return;
    }
    gatt = true;
    if (rute != nord) {
      ArrayList<Rute> nySti = new ArrayList<Rute>(sti);
      nySti.add(this);
      nord.gaa(this, nySti);
    }
    if (rute != ost) {
      ArrayList<Rute> nySti = new ArrayList<Rute>(sti);
      nySti.add(this);
      ost.gaa(this, nySti);
    }
    if (rute != sor) {
      ArrayList<Rute> nySti = new ArrayList<Rute>(sti);
      nySti.add(this);
      sor.gaa(this, nySti);
    }
    if (rute != vest) {
      ArrayList<Rute> nySti = new ArrayList<Rute>(sti);
      nySti.add(this);
      vest.gaa(this, nySti);
    }
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
