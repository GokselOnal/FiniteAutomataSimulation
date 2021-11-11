import java.util.*;

public class Results {

    public DFA automata;
    public HashMap<String, String> t_table;

    public Results(DFA dfa, String[] inputs){
        this.t_table =  dfa.transition_table.getTable();

        this.automata = dfa;
        //info for inputs
        given_inputs();
        String current_state = this.automata.initial_state;
        System.out.println();
        System.out.println("~~~~~~~~~~~cs410~~~~~~~~~~~");


        for(int i = 0; i < inputs.length; i++) {
            //final state = inital state and given input is e(represents empty string)
            if ((Arrays.asList(this.automata.final_states).contains(this.automata.initial_state)) && (inputs[i].length() == 1) && (inputs[i].charAt(0) == 'e')){
                System.out.println("{e} (route taken)");
                System.out.println("Accepted");
                System.out.println("--------------------------");
            } else {
                int len = inputs[i].length();
                for (int j = 0; j < len; j++) {
                    char current_char = inputs[i].charAt(j);
                    String next_state = this.t_table.get(current_state + " " + current_char);
                    // if the given char is not in set of symbols table return null,
                    // for safety
                    if(next_state == null) {
                        current_state = null;
                        System.out.print("Invalid Symbol! ");
                    }
                    else {
                        current_state = next_state;
                        System.out.print(current_state + " ");
                    }
                }
                System.out.println("(route taken)");
                if (Arrays.asList(this.automata.final_states).contains(current_state)) {
                    System.out.println("Accepted");
                    System.out.println("--------------------------");
                }else {
                    System.out.println("Rejected");
                    System.out.println("--------------------------");
                }
                current_state = this.automata.initial_state;
            }
        }
    }
    public void given_inputs(){
        System.out.println();
        System.out.print("Given inputs: ");
        System.out.print(this.automata.inputs[0]);
        for(int i = 1; i < this.automata.inputs.length; i++)
            System.out.print(", " + this.automata.inputs[i]);
        System.out.println();
    }

}
