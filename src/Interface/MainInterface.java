package Interface;

public interface MainInterface {
    void print();


    default int something(){
        return 1;
    }
}
