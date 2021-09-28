public class Tuppel {
  int rad, kol;

  public Tuppel(int rad, int kol) {
    this.rad = rad;
    this.kol = kol;
  }

  @Override
  public String toString() {
    return String.format("(%d, %d)" , rad, kol);
  }
}
