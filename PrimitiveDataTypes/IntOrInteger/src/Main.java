public class Main {
    public static void main(String[] args) {
        Container container = new Container(100);
        container.addCount(5672);
        System.out.println(container.getCount());
        System.out.println();

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.


//     Вариант с правильной последовательностью букв в алфавите:

        for (int i = 1040; i <= 1045; i++) {
            char c = (char) i;
            System.out.println(i + " - " + c);
            continue;
        }
        for (int j = 1025; j <= 1025; j++) {
            char d = (char) j;
            System.out.println(j + " - " + d);
            continue;
        }
        for (int k = 1046; k <= 1071; k++) {
            char f = (char) k;
            System.out.println(k + " - " + f);
        }

        System.out.println();

        for (int p = 1072; p <= 1077; p++) {
            char s = (char) p;
            System.out.println(p + " - " + s);
            continue;
        }
        for (int m = 1105; m <= 1105; m++) {
            char l = (char) m;
            System.out.println(m + " - " + l);
            continue;
        }
        for (int t = 1078; t <= 1103; t++) {
            char w = (char) t;
            System.out.println(t + " - " + w);
        }

//     Вариант без верной последовательности букв в алфавите:

//        for (int j = 1025; j <= 1025; j++) {
//            char d = (char) j;
//            System.out.println(j + " - " + d);
//        }
//        for (int i = 1040; i <= 1103; i++) {
//            char c = (char) i;
//            System.out.println(i + " - " + c);
//        }
//        for (int k = 1105; k <= 1105; k++) {
//            char f = (char) k;
//            System.out.println(k + " - " + f);
//        }
    }
}
