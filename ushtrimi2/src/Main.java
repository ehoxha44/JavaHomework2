public class Main {
    public static void main(String[] args) {
        int[] vargu1 = new int[] {1,2,3};
        vargu1 = MenaxhimiIVargut.shtoNjeAnetarNeVarg(vargu1, 4);
        MenaxhimiIVargut.printo(vargu1);
        vargu1 = MenaxhimiIVargut.largoNjeAnetarNgaVargu(vargu1, 2);
        MenaxhimiIVargut.printo(vargu1);
        int[] vargu2 = new int[] {5,6,7};
        vargu1 = MenaxhimiIVargut.shtoVargunNeVarg(vargu1, vargu2);
        MenaxhimiIVargut.printo(vargu1);
    }
}

class MenaxhimiIVargut{
    public static int NULL_VALUE = Integer.MIN_VALUE;
    public static int[] shtoNjeAnetarNeVarg(int[] vargu, int anetariIRi){
        int[] varguIRi = new int[vargu.length + 1];
        for (int i = 0; i < vargu.length; i++){
            varguIRi[i] = vargu[i];
        }
        varguIRi[varguIRi.length - 1] = anetariIRi;
        return varguIRi;
    }

    public int [] shtoAnetarNeVarg(int[] vargu, int anetariIRi){
        int pozitaELire = MenaxhimiIVargut.gjejHapesire(vargu);

        if (pozitaELire == MenaxhimiIVargut.NULL_VALUE){
            int[] varguIRi = MenaxhimiIVargut.createArrayWithInitValues(vargu.length*2, MenaxhimiIVargut.NULL_VALUE);
            for (int i = 0; i < vargu.length; i++){
                varguIRi[i] = vargu[i];
            }
            varguIRi[vargu.length] = anetariIRi;
            vargu = varguIRi;
        } else{
            vargu[pozitaELire] = anetariIRi;
        }
        return vargu;
    }

    public static int gjejHapesire(int[] vargu){
        for (int i = 0; i < vargu.length; i++){
            if (vargu[i] == MenaxhimiIVargut.NULL_VALUE){
                return i;
            }
        }
        return MenaxhimiIVargut.NULL_VALUE;
    }

    public static int[] createArrayWithInitValues(int sizeOfArray, int initValue){
        int[] newArray = new int[sizeOfArray];
        for (int i = 0; i<sizeOfArray; i++){
            newArray[i] = initValue;
        }
        return newArray;
    }

    public static int[] shtoVargunNeVarg(int[] vargu, int[] shto){
        int gjatesiaVargut = vargu.length + shto.length;
        int[] varguShto = new int[gjatesiaVargut];
        int pozita = 0;
        for (int elementi : vargu){
            varguShto[pozita] = elementi;
            pozita++;
        }
        for (int elementi : shto){
            varguShto[pozita] = elementi;
            pozita++;
        }
        return varguShto;
    }

    public static int[] largoNjeAnetarNgaVargu(int[] vargu, int index){
        int[] varguIRi = new int[vargu.length - 1];
        for (int i = 0, k = 0; i < vargu.length; i++) {
            if (i == index) {
                continue;
            }
            varguIRi[k++] = vargu[i];
        }
        return varguIRi;
    }

    public static void printo(int[] vargu){
        System.out.printf("[ ");
        for (int numri: vargu){
            if (numri != MenaxhimiIVargut.NULL_VALUE) {
                System.out.printf("%d ", numri);
            }
        }
        System.out.printf("]\n");
    }
}