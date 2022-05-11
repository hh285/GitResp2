package myself;

public class Solution16 {
    private volatile static Solution16 instance;
    private Solution16() {
    }
    public Solution16 getInstance(){
        if(instance==null){
            synchronized (Solution16.class){
                if(instance==null){
                    instance=new Solution16();
                }
            }
        }
        return instance;
    }
}
