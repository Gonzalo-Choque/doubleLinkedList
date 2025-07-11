package exercises;

@SuppressWarnings("hiding")
public class ArrayLetras<String extends Comparable<String>> {
	public Letra<String> first;
	public Letra<String> last;
	public int countLeters;
	public int count;
	
	public ArrayLetras() {
		this.first = null;
		this.countLeters = 0;
	}
	
	
	public void add(String a) {
		if(this.countLeters==0) {
			this.last = this.first = new Letra<String>(a);
			this.count++;
			this.countLeters++;
		}
		else if(this.countLeters==1) {
			if(a.compareTo(this.first.getData())==0) {
				this.first.setCount(this.first.getCount()+1);
				this.count++;
			}
			else {
				this.last = new Letra<String>(a);
				this.first.setNext(this.last);
				this.count++;
				this.countLeters++;
			}
		}
		else {
			Letra<String> iter = this.first;
			while(iter!=null && a.compareTo(iter.getData())!=0) {
				iter=iter.getNext();
			}
			if(iter==null) {
				Letra<String> nuevo = new Letra<String>(a);
				this.last.setNext(nuevo);
				this.last=nuevo;
				this.count++;
				this.countLeters++;
			}
			else {
				iter.setCount(iter.getCount()+1);
				this.count++;
			}
		}
	}
	public int cantidadLetras() {
		return this.countLeters;
	}
	public int size() {
		return this.count;
	}
	
	public void print() {
		Letra<String> iter = this.first;
		System.out.println("[Letra"+iter.getData()+", cantidad"+iter.getCount()+"]");
		while(iter.getNext()!=null) {
			iter=iter.getNext();
			System.out.println("[Letra"+iter.getData()+", cantidad"+iter.getCount()+"]");
		}
	}
}
