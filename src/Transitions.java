import java.util.HashMap;

public class Transitions {
    public HashMap<String, String> table;

    public Transitions(String[] transitions){
        this.table = new HashMap();
        addItem(transitions);
    }

    //trasition q1 1 q2
    //hashtable -> {"q1 1": "q2"} (key,value)
    public void addItem(String[] transitions){
        for(String rules : transitions){
            String[] item = rules.split(" ");
            String from_with = item[0] + " " + item[1];
            this.table.put(from_with,item[2]);
        }
    }

    public HashMap<String, String> getTable(){
        return this.table;
    }
}
