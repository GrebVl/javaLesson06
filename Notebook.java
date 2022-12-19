class Notebook {
    int id;
    String nameNB;
    String nameOS;
    String colourNB;
    int RAM;
    int HDD;

    static int count = 0;

    public Notebook(){
        count++;
        this.id = count;
    }

    public Notebook(String nNB){
        count++;
        this.id = count;
        this.nameNB = nNB;
    }

    void infoNB(){
        System.out.println();
        System.out.printf("Марка %s:\n", nameNB);
        System.out.printf("ОС %s\n", nameOS);
        System.out.printf("цвет %s\n", colourNB);
        System.out.printf("ОЗУ %d Gb\n", RAM);
        System.out.printf("объем ЖД %d Gb\n", HDD);
        System.out.println();
    }

    @Override
    public String toString() {
        String res = String.format("Марка %s: ОС %s, цвет %s, ОЗУ %d Gb, объем ЖД %d Gb", nameNB, nameOS, colourNB, RAM, HDD);
        return res;
    }

    public boolean IntRam(int n){
        if(this.RAM >= n){
            return true;
        }else{
            return false;
        }
    }

    public boolean IntHdd(int n){
        if(this.HDD >= n){
            return true;
        }else{
            return false;
        }
    }

    public boolean colour(String col){
        if(this.colourNB == col){
            return true;
        }else{
            return false;
        }
    }

    public boolean nameNotbook(String name){
        if(this.nameNB == name){
            return true;
        }else{
            return false;
        }
    }

    public boolean nameOpSyst(String OpSyst){
        if(this.nameOS == OpSyst){
            return true;
        }else{
            return false;
        }
    }
}

