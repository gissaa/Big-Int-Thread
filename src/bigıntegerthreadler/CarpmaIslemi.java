/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigıntegerthreadler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;

/**
 *
 * @author Gizem Sarıtaş-B161210383
 * @author Naciye Merve Bacak-B161210050
 * 
 */
public class CarpmaIslemi implements Runnable{
    public  BigInteger[]sonuclar;        
    public CarpmaIslemi(BigInteger s1,BigInteger s2){
        BigInteger sonuc;
        int sayiuzunlugu= s2.toString().length();      //BigInteger'ı stringe dönüştürüp uzunluğunu alıyor
        sonuclar=new BigInteger[sayiuzunlugu];        //s2'nin boyutu kadar biginteger dizisi oluşturuyor 
        for(int i=0;i<sayiuzunlugu;i++)
        {
            char a=s2.toString().charAt(i);    //s2'yi tekrar stringe dönüştürüp chara dönüştürüyor
            int hane=a-48;  //char int dönüşümünden 
            sonuc=s1.multiply(BigInteger.valueOf(hane));  //s1 ile s2'nin bir parçası olan hane (int türü)çarpılıyor
            sonuclar[i]=sonuc;  //sonuclar dizisine atılıyor
        }
    }
    public void ToplamaVeDosyayaYazma(BigInteger s1,BigInteger s2) throws IOException {
        int sayiuzunlugu= s2.toString().length();       //sayı uzunluğunu tekrar buluyoruz
        BigInteger toplam = BigInteger.ZERO;            
        for(BigInteger i:sonuclar) 
        {
            toplam=toplam.add(i);     //Toplam=toplam+sonuclar[i] değerini elde ettik
        }
        String dosyayaYazilacak=toplam.toString();   //Toplam sonucunu dosyaya yazma işlemi yapıyor
        File file = new File("Sonuc.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, false);
        try (BufferedWriter bWriter = new BufferedWriter(fileWriter)) {
            bWriter.write(dosyayaYazilacak);
        }
        System.out.println("Sonuc Dosyaya Yazildi");
    }
    @Override
    public void run() {
       
    }
}
