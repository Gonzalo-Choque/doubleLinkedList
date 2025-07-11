package exercises;

public class ColaPriority<String> {
	private Letra<String> first;
	private Letra<String> last;
	private int count;
	
	public ColaPriority() {
		this.first = null;
		this.last = null;
		this.count = 0;
	}
	public void enqueue(String e,int i) {//no agrego en medio, ademas el primero lo agrego despues
		if(this.isEmpty()) {
			enqueueFrontNew(e,i);
		}
		else {
			enqueueOrder(e,i);
		}
	}
	private void enqueueFrontNew(String e, int i) {
		Letra<String> nuevo = new Letra<String>(e, i, null);
		this.first= nuevo;
		this.last= nuevo;
		this.count++;
	}
	private void enqueueOrder(String e, int i) {
		
		if(this.count==1){//enlazar front con back
			if(i>=this.first.getCount()) {
				this.last = new Letra<String>(e,i,null);
				this.first.setNext(this.last);
			}
			else {
				this.first = new Letra<String>(e,i,this.last);
			}
			this.count++;
		}
		else if(i<this.first.getCount()){
			insertFirst(e,i);
		}
		else if(i>=this.last.getCount()){
			insertLast(e,i);
		}
		else {
			Letra<String> iter=this.first;
			Letra<String> previous = null;
			while(i>=iter.getCount()) {
				previous = iter;
				iter = iter.getNext();
			}
			Letra<String> nuevo = new Letra<String>(e, i, iter);
			previous.setNext(nuevo);
			this.count++;
		}
	}
	private void insertFirst(String e, int i) {
		this.first = new Letra<String>(e, i, this.first );
		this.count++;
	}
	private void insertLast(String e, int i) {
		Letra<String> iter = this.last;
		this.last = new Letra<String>(e,i, null);
		iter.setNext(this.last);
		this.count++;
	}
	public int dequeue(int count) {//saca el 1ero
		int letrasEliminadas = this.first.getCount();
		this.first=this.first.getNext();
		this.count--;
		count = count-letrasEliminadas;
		return count;
	}
	public boolean isEmpty() {//si esta vacio
		return this.first == null;
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
