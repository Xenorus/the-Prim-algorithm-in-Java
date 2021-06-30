package com.company;

public class Main {

    public static void main(String[] args) {

        //у нас есть 4 точки, пронумерованные от 0 до 3
        //расстояния между ними описаны в таблице:
                       //0  1  2  3
        int[][] array ={{0, 2, 8, 0}, //0
                        {2, 0, 4, 3}, //1
                        {8, 4, 0, 0}, //2
                        {0, 3, 0, 0}};//3


        //точки, с которых мы начинаем выполнение алгоритма
        int first = 0;
        int second = 0;

        int number_of_points = 4; //количество точек
        int counter=0;
        boolean finality = false;
        int all_dist = 0;
        int[] arr_result = {0, 0, 0};

        while (!finality) {
            counter++;
            finality = true;
            if (counter != number_of_points) {
                arr_result = small_integer(array, first, second, 4);
                first = arr_result[0];
                second = arr_result[1];
                if (arr_result[2] != -1) {
                    finality = false;
                    System.out.println(arr_result[0] + " - " + arr_result[1] + " :" + arr_result[2]);
                    all_dist += arr_result[2];
                }
            }

        }

        System.out.println("Кратчайшее расстояние равняется " + all_dist);

    }

    public static int[] small_integer (int[][]array, int first, int second, int arr_length) {
        int[] result = new int[3];
        int small_int = 2147483647;

        for (int i=0; i<arr_length; i++) {
            if (array[first][i]<small_int && (array[first][i]!=0)) {
                small_int=array[first][i];
                result[0]=first;
                result[1]=i;
                result[2]=small_int;
            }
        }

        for (int j=0; j<arr_length; j++) {
            if (array[second][j]<small_int && (array[second][j]!=0)) {
                small_int=array[second][j];
                result[0] = second;
                result[1] = j;
                result[2]=small_int;
            }
        }

        //удаляем ячейку с расстоянием между двумя использованными точками,
        //тк связь между ними уже существует
        array[result[0]][result[1]] = 0;
        array[result[1]][result[0]] = 0;

        if (small_int == 2147483647) {
            result[2] = -1;
        }
        //мы возвращаем массив с данными, в которых мы указываем,
        //какие две следующие линии нужно проверить
        //и найденное расстояние
        return result;
    }
}
