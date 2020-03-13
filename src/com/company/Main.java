package com.company;

public class Main {

    public static void main(String[] args) {
        
    }

    // array - массив вероятностей, length - размер алфавита источника , codes - массив в который записываем кодировку каждого символа.
    public static void shanoCode(float[] array, int length, String[] codes) {
        //находим середину по которой делим массив на две части part1 и part2
        if (length > 1) {
            //find mid
            int mid = 0;
            boolean isMid = false;
            float sum1 = 0;

            for (int i = 0; i < length; i++) {
                if (!isMid) {
                    float sum2 = 0;
                    sum1 += array[i];
                    for (int j = i + 1; j < length; j++){
                        sum2 += array[j];
                    }
                    if (sum1 >= sum2) {
                        isMid = true;
                        mid = i + 1;
                    }
                }

            }
            //создаем два массива 1 и 2 часть
            float[] part1 = new float [mid];
            float[] part2 = new float [length-mid];
            // заполняем в 1 часть единицы и присваиваем значения
            for (int i = 0; i < mid; i++) {
                codes[i] += "1";
                part1[i] = array[i];
            }
            // заполняем в 2 часть нули и присваиваем значения
            for (int i = mid; i < length; i++) {
                codes[i] += "0";
                int j = 0;
                part2[j] = array[i];
                j++;
            }
            shanoCode(part1, part1.length, codes); // n-ая строчка
            shanoCode(part2, part2.length, codes);
            return;// k-ая строка
        }
    }
}
