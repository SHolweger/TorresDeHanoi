package com.mycompany.torresdehanoi;
/**
 * 
 * @author sebastianholweger
 */
public class TorresDeHanoi {
    public static void main(String[] args) {
    Principal obj = new Principal();
    obj.setVisible(true);
  }
    
 /* public static void main(String[] args) {
    TorresDeHanoi obj = new TorresDeHanoi();
    obj.torresHanoi(3, 1, 2, 3);
    //Mensaje de completado
  }
  //Metodo recursivo para solucionar las torres
  public void torresHanoi(int discos, int torre1, int torre2, int torre3) {
    //Caso base
    if (discos == 1) {
      //mover de torre inicial a final
    } else {
      torresHanoi(discos - 1, torre1, torre3, torre2);
      //mover de torre inicial a final
      torresHanoi(discos - 1, torre2, torre1, torre3);
    }
  } */
}