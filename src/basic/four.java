package basic;

class Singleton{
    private static class SingletonInstanceHolder{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstanceHolder.INSTANCE;
    }
}

public class four {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        if(a==b){
            System.out.println(true);
        }
    }
}

