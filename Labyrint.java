import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;

public class Labyrint {

  private Rute[][] labyrint;
  private int rader;
  private int kolonner;
  protected char tegn;
  protected ArrayList<ArrayList<Rute>> utveier;

  public Labyrint(File fil) throws FileNotFoundException {
    lesInnFil(fil);
  }

  public void lesInnFil(File nyFil) throws FileNotFoundException {
    Scanner lesFil = new Scanner(nyFil);

    String[] labyrintStorrelse = lesFil.nextLine().split(" ");
    rader = Integer.parseInt(labyrintStorrelse[0]);
    kolonner = Integer.parseInt(labyrintStorrelse[1]);
    labyrint = new Rute[rader][kolonner];
    Rute[][] brett = new Rute[rader][kolonner];

    for (int rad = 0; rad < rader; rad++) {
      String linje = lesFil.nextLine();
      for (int kolonne = 0; kolonne < kolonner; kolonne++) {
        tegn = linje.charAt(kolonne);
        if (kolonne == 0 && tegn == '.') {
          Aapning aapning = new Aapning(rad, kolonne, this);
          brett[rad][kolonne] = aapning;
          aapning.initGUI();
        }
        else if (kolonne == kolonner - 1 && tegn == '.') {
          Aapning aapning = new Aapning(rad, kolonne, this);
          brett[rad][kolonne] = aapning;
          aapning.initGUI();
        }
        else if (rad == rader - 1 && tegn == '.') {
          Aapning aapning = new Aapning(rad, kolonne, this);
          brett[rad][kolonne] = aapning;
          aapning.initGUI();
        }
        else if (rad == 0 && tegn == '.') {
          Aapning aapning = new Aapning(rad, kolonne, this);
          brett[rad][kolonne] = aapning;
          aapning.initGUI();
        }
        else if (tegn == '#') {
          SortRute sort = new SortRute(rad, kolonne, this);
          brett[rad][kolonne] = sort;
          sort.initGUI();
        }
        else {
          HvitRute hvit = new HvitRute(rad, kolonne, this);
          brett[rad][kolonne] = hvit;
          hvit.initGUI();
        }
      }
    }
    labyrint = brett;
    finnNabo();
  }

  public void finnNabo() throws NullPointerException, ArrayIndexOutOfBoundsException {
    for (int rad = 0; rad < rader; rad++) {
      for (int kolonne = 0; kolonne < kolonner; kolonne++) {
        Rute nord, sor, vest, ost;
        try{
          Rute paaBestemtRute = labyrint[rad][kolonne];
          nord = labyrint[rad-1][kolonne];
          sor = labyrint[rad+1][kolonne];
          vest = labyrint[rad][kolonne-1];
          ost = labyrint[rad][kolonne+1];
          paaBestemtRute.settNaboer(nord, sor, vest, ost);
          } catch(ArrayIndexOutOfBoundsException e) {
            if (rad == 0) {
              nord = null;
            }if (rad == rader -1) {
              sor = null;
            }if (kolonne == 0) {
              vest = null;
            }if (kolonne == kolonner - 1) {
              ost = null;
            }
          }
        }
      }
  }
  public ArrayList<ArrayList<Rute>> finnUtveiFra(int rad, int kolonne){
    utveier = new ArrayList<ArrayList<Rute>>();
    labyrint[rad][kolonne].finnUtvei();
    return utveier;
  }

  public String toString() {
      String retur = "";
      for (Rute[] rad : labyrint) {
        for (Rute rute : rad) {
          retur += rute.tilTegn();
        }
        retur += "\n";
      }
      return retur;
  }

  public void leggTilUtvei(ArrayList<Rute> a) {
    utveier.add(a);
  }

  public int hentAntRader() {
    return rader;
  }

  public int hentAntKolonner() {
    return kolonner;
  }

  public Rute[][] hentLabyrint() {
    return labyrint;
  }

  public static void visUtveListe(ArrayList<ArrayList<Rute>> list) {
    ArrayList<Rute> visKortest;
    visKortest = kortesteUtvei(list);
    for (Rute boks : visKortest) {
      boks.gaaAapning();
    }
  }


  public static ArrayList<Rute> kortesteUtvei(ArrayList<ArrayList<Rute>> kortest) {
    int str = 0;
    ArrayList<Rute> kort = new ArrayList<>();
    for (ArrayList<Rute> liste : kortest) {
      for (Rute rute : liste) {
        str++;
        if (str < kortest.size()) {
          kort = liste;
        }
      }
    }
    return kort;
  }
}
