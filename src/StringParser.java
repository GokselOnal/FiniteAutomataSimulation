import java.util.ArrayList;

public class StringParser {
    private int len_states;
    private int len_symbols;
    private int len_goal_states;
    public String states;
    public String goal_states;
    public String variables;
    public String transition;
    public String inputs;

    public StringParser(String text){
        String[] tokens = text.split(";");

        for (int i = 0; i < 3; i++)
            if(i == 0)
                this.len_states = Integer.parseInt(tokens[i]);
            else if(i == 1)
                this.len_symbols = Integer.parseInt(tokens[i]);
            else if(i == 2)
                this.len_goal_states = Integer.parseInt(tokens[i]);


        for(int i = 3; i < tokens.length; i++){
            if(i == 3)
               this.states = tokens[i];
            else if(i == 4)
                this.goal_states = tokens[i];
            else if(i == 5)
                this.variables = tokens[i];
        }

        int len_transition = this.len_states * this.len_symbols;

        this.transition = "";
        for(int i = 6; i < 6 + len_transition; i++){
            this.transition += tokens[i] + "#";
        }

        this.inputs = "";
        for(int i = 6 + len_transition ; i < tokens.length; i++){
            this.inputs += tokens[i] + "#";
        }
    }

    public ArrayList<String[]> getStrings(){
        ArrayList<String[]> list_strings = new ArrayList<String[]>();
        list_strings.add(this.states.split(" "));
        list_strings.add(this.variables.split(" "));
        list_strings.add(this.goal_states.split(" "));
        list_strings.add(this.transition.split("#"));
        list_strings.add(this.inputs.split("#"));
        return list_strings;
    }
}
