package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double kilo;
        double boy;
        double idealKilo;
        int yas;
        String cinsiyet;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Schofield Formülü ile İdeal Kilo Hesaplama Programına Hoş Geldiniz!");
        System.out.println("Lütfen kilonuzu girin (kg): ");
        kilo = scanner.nextDouble();

        System.out.println("Lütfen boyunuzu girin (cm): ");
        boy = scanner.nextDouble();

        System.out.println("Lütfen yaşınızı girin: ");
        yas = scanner.nextInt();

        System.out.println("Lütfen cinsiyetinizi girin (erkek/kadın): ");
        cinsiyet = scanner.next().toLowerCase();

        idealKilo = hesaplaBMR(kilo, boy, yas, cinsiyet);

        // Schofield formülü ile BMR hesaplandıktan sonra, ideal kilo tahmini yapmak için
        // belirli bir aktivite seviyesine göre günlük kalori ihtiyacı belirlenebilir.
        // Bu günlük kalori ihtiyacı, ideal kilo tahmini için temel bir veri olarak kullanılabilir.

        System.out.println("Schofield formülüne göre ideal kilo: " + idealKilo + " kg");

        scanner.close();
    }

    public static double hesaplaBMR(double kilo, double boy, int yas, String cinsiyet){
        double bmr;
        if (cinsiyet.equals("erkek")) {
            if (yas >= 10 && yas <= 17) {
                bmr = 658.2 + (17.686 * kilo);
            } else if (yas >= 18 && yas <= 29) {
                bmr = 692.2 + (15.057 * kilo);
            } else if (yas >= 30 && yas <= 59) {
                bmr = 873.1 + (11.472 * kilo);
            } else {
                bmr = 587.7 + (11.711 * kilo);
            }
        } else if (cinsiyet.equals("kadın")) {
            if (yas >= 10 && yas <= 17) {
                bmr = 692.6 + (13.384 * kilo);
            } else if (yas >= 18 && yas <= 29) {
                bmr = 486.6 + (14.818 * kilo);
            } else if (yas >= 30 && yas <= 59) {
                bmr = 845.6 + (8.126 * kilo);
            } else {
                bmr = 658.5 + (9.082 * kilo);
            }
        } else {
            System.out.println("Geçersiz cinsiyet girdisi!");
            return 0;
        }
        return bmr;

    }
}
/*           yaş               kadın                   erkek
            10-17           692,6 + 13,384 kg          658,2 + 17,686 kg
            18-29           486,6 + 14,818 kg          692,2 + 15,057 kg
            30-59           845,6 + 8,126 kg           873,1 + 11,472 kg
            60-             658,5 + 9,082 kg           587,7 + 11,711 kg


*/
