package at.fhv.ssc.Stack;

public class Stack {
	public int[] _stack;
	public int _pointer;

	public Stack (int size) {
		if (size > 0) {
			_stack = new int[size];
			_pointer = -1;
		}
	}

	public boolean isEmpty() {
		if (_pointer == -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isFull() {
		if (_pointer < _stack.length) {
			return false;
		} else {
			return true;
		}
	}

	public boolean push(int newItem) {
		if (!isFull()) {
			_pointer++;
			_stack[_pointer] = newItem;
			return true;
		} else {
			return false;
		}
	}

	public int pop() {
		int item = top();
		_pointer--;
		return item;
	}

	public int top() {
		if (!isEmpty()) {
			return _stack[_pointer];
		}  else {
			return 0;
		}
	}
	/**4 Methoden add, sub, multiply, devide für die 4 Grundrechnungsarten.
     * add addiert die zwei Werte im Stack.
     * sub subtrahiert sie, tauscht über ein temp die Reihenfolge.
     * multiply multipliziert die zwei Werte im Stack.
     * devide dividiert sie, tauscht über ein temp die Reihenfolge.**/
	public void add(){
		push(pop() + pop());
	}

	public void sub(){
		int temp = pop();
		push(pop() - temp);
	}

	public void multiply (){
		push(pop() * pop());
	}

	public void devide(){
		int temp = pop();
		push(pop() / temp);
	}

    /**Die Methode calculate kombiniert die vorherigen 4 Methoden.
     * Das Leerzeichen wird als splitter festgelegt, die Einzelnen Zeichen
     * (Zahlen und Rechenoperationen) werden abgefragt bis vor das letzte LZ und den ;
     * Durch eine switchcase werden die 4 möglichen Operationen unterschieden und
     * dann die jeweilige Methode add, sub, mutliply, devide verwendet um das (Zwischen)ergebnis zu berechnen.
     * Zum Schluss wird das Ergebnis (Top of Stack) ausgegeben. **/
    public static int calculate(String str){

        String[] strArray = str.split(" ");
        Stack stack = new Stack(2);
       	stack.push(Integer.parseInt(strArray[0]));

        for(int i = 1; i< ((strArray.length)-2); i++){

            stack.push(Integer.parseInt(strArray[i]));
            i++;

            switch(strArray[i]){
                case "+":
                    stack.add();
                    break;
                case "-":
                    stack.sub();
                    break;
                case "*":
                    stack.multiply();
                    break;
                case "/":
                    stack.devide();
                    break;
                case ";":
                    break;
            }

        }
        return stack.top();
    }

}









