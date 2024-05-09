abstract class TiketKonser implements HargaTiket {
    public abstract double harga();

    @Override
    public String toString(){
        return getClass().getSimpleName();
    }
 }
 