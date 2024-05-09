abstract class TiketKonser implements HargaTiket {
    public abstract double harga();

    @Override
    public String toString(){ //override method untuk mengembailkan nama kelas objek TiketKonser yang disederhanakan
        return getClass().getSimpleName();
    }
 }
 
