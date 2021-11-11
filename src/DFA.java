import java.util.ArrayList;
import java.util.HashMap;

public class DFA {

    public String[] states;
    public String[] symbols;
    public String[] transitions;
    public String initial_state;
    public String[] final_states;
    public String[] inputs;
    public Transitions transition_table;
    public StringParser parser;
    private ArrayList<String[]> parsed_text;

    public DFA(StringParser sp){
        this.parser = sp;
        this.parsed_text =  this.parser.getStrings();
        this.states = parsed_text.get(0);
        this.symbols = parsed_text.get(1);
        this.final_states = parsed_text.get(2);
        this.initial_state = parsed_text.get(0)[0]; // first given state in text file is initial state
        this.transitions = parsed_text.get(3);
        this.inputs = parsed_text.get(4);
        this.transition_table = new Transitions(transitions);
        info();
    }

    private void makeTransition(){
        ArrayList<String> v = new ArrayList<String>();
        HashMap<String, String> table = this.transition_table.getTable();

        for (String k : table.keySet()) {
            v.add(k);
        }

        //info
        System.out.println("\u03b4(Transition Table):");
        for(int i = 0; i < v.size(); i++){
            System.out.println("\t" + v.get(i) + " -> " + table.get(v.get(i)));
        }
    }

    private void info(){
        System.out.println();
        System.out.println("~DETERMINISTIC FINITE AUTOMATA~");
        System.out.println();

        System.out.println("(Q,\u2211,\u03b4,q0,F) Formal Definition: ");
        System.out.print("Q(States): ");
        for(String state : states)
            System.out.print(state + " ");
        System.out.println();

        System.out.print("\u2211(Symbols): ");
        for(String symbol : symbols)
            System.out.print(symbol + " ");
        System.out.println();

        makeTransition();

        System.out.print("q0(Initial state): " + initial_state);

        System.out.println();

        System.out.print("F(Final states): ");
        for(String goal : final_states)
            System.out.print(goal + " ");
        System.out.println();

    }

    public HashMap<String, String> getTransition(){
        return this.transition_table.getTable();
    }
}
