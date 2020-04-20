public class Main {
    static final int SIZE = 1_000_000;
    static final int H = SIZE / 2;
    static float[] array;

    static class MyThread extends Thread {
        private int start;
        private float[] arrayCopy;
        MyThread(float[] array, int start) {
            super();
            this.start = start;
            arrayCopy = array;
        }
        @Override
        public void run() {
            for (int i=0; i < arrayCopy.length; i++) {
                arrayCopy[i] = (float)(arrayCopy[i] * Math.sin(0.2f + (i+start) / 5) * Math.cos(0.2f + (i+start) / 5) * Math.cos(0.4f + (i+start) / 2));
            }
        }

        public float[] getArray() {
            return arrayCopy;
        }
    }

    public static void main(String[] args) {
        array = new float[SIZE];
        Arrays.fill(array, 1.0f);
        method1();

        Arrays.fill(array, 1.0f);
        method2();

    }

    public static void method1() {
        long a = System.currentTimeMillis();
        for (int i=0; i < SIZE; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время заполнения массива при помощи цикла: " + (System.currentTimeMillis() - a) + " мс");
    }

    public static void method2() {
        long a = System.currentTimeMillis();
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        System.arraycopy(array, 0, a1, 0, H);
        System.arraycopy(array,H,a2,0,H);
        MyThread thread1 = new MyThread(a1, 0);
        MyThread thread2 = new MyThread(a2, H);
        thread1.start();
        thread2.start();
        a1 = thread1.getArray();
        a2 = thread2.getArray();
        System.arraycopy(a1, 0, array, 0, H);
        System.arraycopy(a2, 0, array, H, H);
        System.out.println("Время заполнения массива при помощи двух потоков: " + (System.currentTimeMillis()-a) + " мс");
    }


}
