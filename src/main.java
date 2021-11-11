public class main {
    public static void main(String[] args) {

        ReadFile rf = new ReadFile();
        String text = rf.getText();
        StringParser sp = new StringParser(text);
        DFA dfa = new DFA(sp);
        Results result = new Results(dfa, dfa.inputs);
    }
}
