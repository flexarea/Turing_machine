import java.util.ArrayList;

public class Tape {
    
    // Instance variables
    protected char current;
    protected ArrayList<Character> left;
    protected ArrayList<Character> right;

    
    // Constructor initializes instance variables
    public Tape() {
        left = new ArrayList<Character>();
        right = new ArrayList<Character>();
        current = '*';
    }
    
 
 //store character c on the tape   
    public void store(char c) {
        // TODO: fill this in
        this.current = c;
    }
    
// Move the tape head of this tape one cell to the left
    public void left() {
        // process left when moving to left
            this.right.add(this.current);
            if(this.left.size() == 0){
                this.current = '*';
            }else{
                this.current = this.left.get(this.left.size()-1);
                this.left.remove(this.left.size()-1);
            }    
    }
    //Move the tape head of this tape one cell to the right
    public void right() {
        // process tape when moving to right
        this.left.add(this.current);
        if(this.right.size() == 0){
            this.current = '*';
        }else{
            this.current = this.right.get(this.right.size()-1);
            this.right.remove(this.right.size()-1);
        }   
    }
    //Display (i.e., print) the contents of all cells in this tape ever visited by the tape head.
    public void display() {
        //display the value in the tape
        String tape = "";
        String tapeLeft="";
        String tapeRight = "";
        for(int i=0; i<this.left.size(); i++){
            tapeLeft += String.valueOf(this.left.get(i)) + " ";
        }
        for(int i=this.right.size()-1; i>=0; i--){
            tapeRight += String.valueOf(this.right.get(i)) + " ";
        }
        tape += tapeLeft+"["+this.current+"] "+tapeRight;
        System.out.println(tape);
    }
    //process a whole input on the tape
    public void processInput(String str){

        for(int i=0; i<str.length(); i++){
            switch(str.charAt(i)){
                case '>':right();
                break;
                case '<':left();
                break;
                case '?':display();
                break;
                default:
                store(str.charAt(i));

            }
        }
    }
    // main can be modified for testing
    public static void main (String[] args) {
        Tape t = new Tape();
        t.display();    // show current tape contents (empty tape)
        t.store('a');
        t.left();
        t.left();
        t.right();
        t.store('c');
        t.display();    // show current tape contents
        t.right();
        t.right();
        t.store('t');
        t.display();    // show current tape contents
    //processInput display instructions' output after commenting out the lines above
        String input = "abc>def?";
        t.processInput(input);
        
        // TODO: complete this definition with more testing as in the write-up
    }     
    
}
