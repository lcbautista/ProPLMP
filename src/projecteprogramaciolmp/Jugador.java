/////////////////////////////////
///
///  Resoldre com cullons va el rol i el jugador i la carta
///  ¿ Com fer que per exemple en l'acció de rol del Rei, resti 3 monedes del Banc Nacional i les sumi al Rei ?
///
////////////////////////////////
package projecteprogramaciolmp;
import java.util.ArrayList;
public abstract class Jugador {
    // Atributs
    // --------------------
    Moneda _monedes; // Monedes de les que disposa el jugador
    private int _cartaJugada; // Carta que el Jugador utilitza en el torn
    private ArrayList<Carta> _cartesJugador;
    Accio _accion;
    // --------------------
    
     // ============================================================
    // Mètodes CONSTRUCTORS
    // ============================================================
    
    public Jugador(){
        _monedes= new Moneda();
        _cartaJugada=0;
        _accion = new Accio();
        _cartesJugador = new ArrayList<> (3);
    }
    
    public Jugador(int monedes){
        _accion= new Accio();
        _monedes= new Moneda(monedes);
        _cartesJugador = new ArrayList<> (3);
        _cartaJugada = 0;
    }
    
    // ============================================================
    // Mètodes CONSULTORS
    // ============================================================
       
     public Carta getCartaActual() {
         return _cartesJugador.get(_cartaJugada);
     }
    
     public void mostraEstadistiques(int j){
         System.out.println("Les monedes del jugador "+j+" són: "+_monedes.retornaQuantitat());
         for(int i=0; i < _cartesJugador.size(); i++){
             _cartesJugador.get(i).ensenya();
         }
     }
     
    // ============================================================
    // Mètodes MODIFICADORS
    // ============================================================
       public void pagarMulta(){
       // Pre: --
       // Post: Resta una moneda al jugador per afegir-la al Palau de Justicia
            _monedes.afegirMonedes(-1);
            // falta afegir la moneda al palau.
       }
       
       public void afegirMonedes (int mon) {
       // Pre: mon >=0 mon <=0
       // Post: Realitza la operació _monedes + mon
            _monedes.afegirMonedes(mon);
       }
       
       public Moneda retornaMonedes(){
           return _monedes;
       }
       public void esborrarCarta(int nCarta){
           _cartesJugador.remove(nCarta);
       }
       public void afegirCarta(Carta nova){
           _cartesJugador.add(nova);
       }
       public int nCartes(){
           int nC = _cartesJugador.size();
           System.out.println(nC);
           return _cartesJugador.size();
       }
       public boolean decidir(){
          return _accion.decidir();
       }
       
       public void ensenyaCartes(){
           for(int i=0; i<_cartesJugador.size(); i++){
               _cartesJugador.get(i).ensenya();
           }
       }
       
       public void accioDeRol(Partida p){
           _accion.accioDeRol(p);
       }
       
       public void nouRol (Rol r){
           _accion.nouRol(r);
       }
}
