/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigıntegerthreadler;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Gizem Sarıtaş-B161210383
 * @author Naciye Merve Bacak-B161210050
 * 
 */
public class BigIntegerThreadler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BigInteger a=new BigInteger("180");
        BigInteger b=new BigInteger("24");
        long baslangic=System.nanoTime();
        new CarpmaIslemi(a,b);
        long bitis = System.nanoTime();
        double sure = (bitis-baslangic)/1000000.0;
        System.out.println("Threadsiz Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.");
        
        ExecutorService havuz = Executors.newFixedThreadPool(8);
        long baslangic2 = System.nanoTime(); //hesaplama başlıyor
        havuz.execute(new CarpmaIslemi(a,b));
        havuz.shutdown();
        while(!havuz.isTerminated()){ }
        long bitis2 = System.nanoTime();//hesaplama bitiyor
        double sure2= (bitis2-baslangic2)/1000000.0;
        System.out.println("Threadli Hesaplanma Süresi " + String.format("%.2f", sure2) + " milisaniye.");
        CarpmaIslemi or=new CarpmaIslemi(a, b);
        or.ToplamaVeDosyayaYazma(a, b);
        
    }
}
