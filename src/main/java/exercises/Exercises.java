package exercises;

public class Exercises {
    /**
     * Given a string, remove characters until the string is made up of two alternating characters.
     *
     * Example String A = "abaacdabd"
     * (step 1) removing 'b', A = "aaacdabd"
     * (step 2) removing 'c', A = "aaadad"
     *
     * Then maximum possible size is 6
     *
     * @param a A sequence of characters
     * @return maximum possible size of the final string
     * @throws Exception 
     */
    public int twoCharacters(String a){
        //TODO complete here
    	if(a.length()<=2) {
    		return 0;
    	}
		else {
			char[] caracteres = a.toCharArray();
			ArrayLetras<String> ArrayLetras = new ArrayLetras<String>(); 
			for(int i = 0; i<a.length(); i++) {
				ArrayLetras.add(Character.toString(caracteres[i]));
			}
			return numeroLetras(ArrayLetras);
		}
    }
    private int numeroLetras(ArrayLetras<String> ArrayLetras){
    	if(ArrayLetras.cantidadLetras() ==1) {
    		return 0;
    	}
    	else if(ArrayLetras.cantidadLetras() ==2) {
    		if(ArrayLetras.count>2){
    			return ArrayLetras.size();
    		}
    		else {
    			return 0;
    		}
    	}
    	else {
    		ColaPriority<String> letras = new ColaPriority<String>();
    		Letra<String> iter = ArrayLetras.first;
    		for(int i = 0; i<ArrayLetras.countLeters; i++) {
    			letras.enqueue(iter.getData(), iter.getCount());
    			iter = iter.getNext();
			}
    		int count = ArrayLetras.countLeters;
    		int totalLetras =ArrayLetras.count;
    		while(count>2) {
    			totalLetras=letras.dequeue(totalLetras);
    			count--;
    		}
    		if(totalLetras==2) return 0;
    		return totalLetras;
    	}
    }
}
