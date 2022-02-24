import java.util.Stack;

public class StackSjekk implements Parentessjekker{
    @Override
    public boolean erVenstreparentes(char p) {
        return (p == '{' || p == '[' || p == '(');
    }

    @Override
    public boolean erHogreparentes(char p) {
        return (p == '}' || p == ']' || p == ')');

    }

    @Override
    public boolean erParentes(char p) {
        return erVenstreparentes(p) || erHogreparentes(p);
    }

    @Override
    public boolean erPar(char venstre, char hogre) {
        if(erParentes(venstre) == false || erParentes(hogre)) return false;
        return hogre == finnHogere(venstre);
    }

    @Override
    public boolean erBalansert(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(erVenstreparentes(c)){
                stack.add(c);
            }
            if(erHogreparentes(c)){
                if(stack.empty()) return false;
                char v = stack.pop();
                if(!erPar(v, c)){
                    return false;
                }
            }
        }
        return true;
    }

    char finnHogere(char p){
        switch(p){
            case('{'):
                return '}';
            case('['):
                return ']';
            case('('):
                return ')';
        }
        return ' ';
    }
}
